<template>
  <div>
    <h1 style="text-align: center">{{ user }}님의 결제 페이지</h1>
    <br /><br />
    <div v-if="!store2.cart" class="noContentContainer">
      <div class="noContent">
        <i class="bi bi-exclamation-circle" style="font-size: 3em"></i><br />
        결제 정보가 없습니다.
      </div>
    </div>
    <div v-else class="container" style="text-align: center">
      <h2 style="text-align: center">주소 : {{ orderUser.address }}</h2>
      <h2 style="text-align: center">번호 : {{ orderUser.number }}</h2>

      <table class="table">
        <thead>
          <tr>
            <th scope="col">상품 사진</th>
            <th scope="col">상품명</th>
            <th scope="col">구매 수량</th>
            <th scope="col">가격</th>

          </tr>
        </thead>
        <tbody>
          <tr v-for="item in store2.cart" :key="item.id">
            <td width="300">
              <img
                height="150"
                width="180"
                :src="item.img"
                alt="image"
                style="border-radius: 5%"
              />
            </td>
            <td style="vertical-align: middle">
              <p class="card-title">{{ item.itemNm }}</p>
            </td>
            <td style="vertical-align: middle">
              <p class="card-title">{{ item.productCnt }}</p>
            </td>
            <td style="vertical-align: middle">
              <p class="card-title">
                {{
                  item.productPrice
                    .toString()
                    .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                }}
              </p>
            </td>
          </tr>
        </tbody>
      </table>
      <p class="container">
        <div class="text-end" >
          
          결제 총 금액 :
          <div class="card-text">
            {{ store2.totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") }}
          </div>
          원
          <button @click="payment" class="btn btn-primary">결제하기</button>
        </div>
      </p>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onBeforeMount } from "vue";
import { useRoute } from "vue-router";
import { useOrderStore } from "@/stores/order";
import { useProductStore } from "@/stores/product";
import axios from "@/util/http-common.js";
import router from "../../router";

const route = useRoute();
const store = useOrderStore();
const store2 = useProductStore();
const user = route.params.id;

// 화면에 주소 띄우기 용
const orderUser = ref("");
onBeforeMount(() => {
  // store.getOrder(user);
  store2.getCartById(user);
  //주소, 번호 띄우기 용도
  axios.get(`http://localhost:8080/api-user/${user}`).then((res) => {
    const userData = res.data[0]; // 데이터가 배열 형태이므로 [0]로 첫 번째 요소에 접근 -> 애초에 조건에 맞는 1개밖에 안옴
    orderUser.value = userData;
  });
});

// 결제하기 버튼
const payment = () => {
  //하단부 전체는 order 및 order_product 테이블 생성
  store2.finalPay(user);
  //장바구니 비우기
  store.orderPay(user);
  //재고 처리
  store2.orderUpdate();
};
</script>

<style scoped>
.card-text {
  display: inline;
  font-size: 25px;
  font-weight: bold;
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
