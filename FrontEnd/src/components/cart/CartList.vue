<template>
  <div>
    <h1 style="text-align: center">{{ user }}님의 장바구니</h1><br>
    <div v-if="!store.cart" class="noContentContainer">
      <div class="noContent">
        <i class="bi bi-exclamation-circle" style="font-size: 3em;"></i><br />
        장바구니가 비어있습니다.
      </div>
    </div>

    <div v-else class="container" style="text-align: center;">
      <table class="table">
        <thead>
          <tr>
            <th scope="col">상품 사진</th>
            <th scope="col">상품명</th>
            <th scope="col">가격</th>
            <th scope="col">구매 수량</th>
            <th scope="col">총 금액</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in store.cart" :key="item.id">
            <td width="300">
              <img height="150" width="180" :src="item.img" alt="image" style="border-radius: 5%;" />
            </td>
            <td style="vertical-align: middle;">
              <p class="card-title">{{ item.itemNm }}</p>
            </td>
            <td style="vertical-align: middle;">
              <p>
                {{
                  item.productPrice
                    .toString()
                    .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                }}
                원
              </p>
            </td>
            <td style="vertical-align: middle;">
              <p>
                {{ item.productCnt }}
                <button @click="down(item.id)" class="btn btn-secondary btn-sm">
                  -
                </button>
                <button @click="up(item.id)" class="btn btn-dark btn-sm">
                  +
                </button>
              </p>
            </td>
            <td style="vertical-align: middle;">
              <p>
                {{
                  getPrice(item.id)
                    .toString()
                    .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                }}
                원
              </p>
            </td>
            <td style="vertical-align: middle;">
              <button @click="deleteCart(item.id)" class="btn btn-danger">삭제</button>
            </td>
          </tr>
        </tbody>
      </table>
      <p class="container">
      <div class="text-end">

        총 금액 :
        <div class="card-text">
          {{ store.totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") }}
        </div>
        원
        <button @click="placeOrder" class="btn btn-primary">주문하기</button>
      </div>
      </p>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from "vue";
import { useRoute } from "vue-router";
import { useProductStore } from "@/stores/product";
import axios from "@/util/http-common.js";
import router from "../../router";

const route = useRoute();
const store = useProductStore();
const user = route.params.id;

//화면 띄우기
onMounted(() => {
  store.getCartById(user);
});

//해당 제품의 총 금액 (총 금액은 store에서 처리!)
const getPrice = (id) => {
  const targetCart = store.cart.find((c) => c.id === id);
  return targetCart.productPrice * targetCart.productCnt;
};

// 증가
const up = (id) => {
  store.cartCntUp(id);
  console.log(id);
  console.log(store.cart.find((c) => c.id === id));
  const targetCart = store.cart.find((c) => c.id === id);
  axios.put(`http://localhost:8080/api-cart/cart`, targetCart);
};

// 감소
const down = (id) => {
  store.cartCntDown(id);
  const targetCart = store.cart.find((c) => c.id === id);
  axios.put(`http://localhost:8080/api-cart/cart`, targetCart);
};

// 삭제
const deleteCart = (id) => {
  axios
    .delete(`http://localhost:8080/api-cart/cart/${user}/${id}`)
    .then(() => {
      alert("상품이 삭제되었습니다.");
      getCart();
      router.push(`${user}`);
    })
    .catch((res) => {
      console.log(res);
    });
};

//주문하기
const placeOrder = function () {
  alert("결제 페이지로 이동합니다");
  router.push({ name: "orderForm", params: { id: user } });
};

// 장바구니에서 삭제 시 화면 다시 가져오는 기능
const getCart = () => {
  store.getCartById(user);
};
</script>

<style scoped>
.card-text {
  display: inline;
  font-size: 25px;
  font-weight: bold;
}

.cart-container {
  display: flex;
  align-items: center;
  flex-wrap: wrap;
  justify-content: space-between;
}

.quantity-text {
  margin: 0 10px;
}

.noContentContainer {
  margin-top: 200px;
  text-align: center;
}

.noContent {
  font-size: 30px;
  font-weight: bold;
}
</style>
