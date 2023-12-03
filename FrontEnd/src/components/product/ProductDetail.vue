<template>
  <div class="container">
    <div class="container">
      <div class="row" style="margin-top: 100px">
        <div class="col">
          <img height="500" width="500" :src="store.product.img" alt="image" />
        </div>
        <div class="col">
          <h1 class="title">{{ store.product.itemNm }}</h1>
          <h3 class="title2">{{ store.product.itemDetail }}</h3>
          <div class="rating" style="display: flex; align-items: center;">
            <StarRating star-size="25" :increment="0.01" style="font-size: 0px;" class="star" read-only="true"
              :rating="store.product.avgRating" />
            <span style="margin-left: 5px;">{{ store.product.avgRating }}</span>
          </div>
          <div class="price">
            {{ price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") }}
            <span style="font-size: 40%">원</span>
          </div>

          <br /><br /><br /><br /><br /><br /><br /><br />
          <div class="totalPrice">
            총 상품 금액
            <span style="font-size: 200%; margin-left: 240px; font-weight: bold">{{
              totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")
            }}</span><span style="font-size: 100%">&nbsp;&nbsp;원</span>
          </div>

          <div class="under">
            <div>
              <span class="num">수량 : {{ quantity }}</span>
              <div class="btn-group-vertical" role="group" aria-label="Vertical button group">
                <button type="button" class="btn btn-primary" @click="up">
                  <span>+</span>
                </button>
                <button type="button" class="btn btn-primary" @click="down">
                  <span>-</span>
                </button>
              </div>
            </div>
            <div>
              <button type="button" @click="addCart" class="btn btn-light">
                장바구니
              </button>
            </div>
            <div>
              <button type="button" @click="singlePay" class="btn btn-danger">
                구매
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- 관리자 물품 수정 페이지 -->
    <div>
      <button @click="updateProduct" v-if="store2.isAdmin">물품 수정</button>
    </div>
    <br /><br /><br />
    <hr />
    <br />
    <!-- 리뷰 화면 -->
    <h3>구매후기</h3>
    <br />
    <table class="table">
      <thead>
        <tr>
          <th style="width: 22%" scope="col">평점</th>
          <th style="width: 10%" scope="col">아이디</th>
          <th style="width: 60%" scope="col">내용</th>
          <th scope="col">날짜</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="review in reviewStore.reviewList" :key="review.id">
          <td>
            <StarRating class="star" read-only="true" :rating="review.rating" />
          </td>
          <td class="reviewId">{{ review.userId }}</td>
          <td>{{ review.content }}</td>
          <td>{{ review.regDate }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { useProductStore } from "@/stores/product";
import { useLoginStore } from "@/stores/login";
import { useReviewStore } from "@/stores/review";
import { ref, onMounted, computed, onBeforeMount } from "vue";
import StarRating from "vue-star-rating";

const store = useProductStore();
const store2 = useLoginStore();
const reviewStore = useReviewStore();
const route = useRoute();
const router = useRouter();
const quantity = ref(1);

const price = computed(() => {
  return store.product.price;
});

//관리자 물품 수정
const updateProduct = () => {
  const productId = route.params.id;
  router.push(`/productUpdate/${productId}`);
};

// 장바구니
const addCart = () => {
  if (store2.loginUser.id == null) {
    alert("로그인 후 이용하세요");
  } else {
    const cartItem = ref({
      product_id: store.product.id,
      user_id: store2.loginUser.id,
      quantity: quantity.value,
      product_price: store.product.price,
    });
    store.cartRegist(cartItem.value);
  }
};

// 증가
const up = () => {
  quantity.value++;
};
// 감소
const down = () => {
  if (quantity.value > 1) quantity.value--;
};

onBeforeMount(() => {
  // 물품 가져오기
  store.getProduct(route.params.id);
  // 리뷰 가져오기
  reviewStore.getProductReview(route.params.id);
});

onMounted(() => { });

// 총 금액
const totalPrice = computed(() => {
  return quantity.value * price.value;
});

// 구매 버튼 눌렀을 때 작동
const singlePay = () => {
  if (store2.loginUser.id == null) {
    alert("로그인 후 이용하세요");
  } else {
    alert("결제 페이지로 이동합니다");
    const singleOrder = ref({
      img: store.product.img,
      itemNm: store.product.itemNm,
      id: store.product.id,
      purchaseCnt: quantity.value,
      productPrice: store.product.price,
    });
    store.orderRegist(singleOrder);
    // 결제 폼으로 이동
    router.push({
      name: "singleOrderForm",
      params: { id: store2.loginUser.id },
    });
  }
};
</script>

<style scoped>
.title {
  text-align: left;
}

.title2 {
  font-size: 22px;
}

.price {
  text-align: left;
  font-size: 300%;
  font-weight: bold;
}

.totalPrice {
  font-size: 120%;
  display: flex;
  align-items: center;
}

.under {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.num {
  font-size: 170%;
  margin-right: 20px;
}

.btn-primary {
  width: 50px;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.btn-light {
  width: 200px;
  height: 60px;
  padding: 0px;
}

.btn-danger {
  width: 200px;
  height: 60px;
  padding: 0px;
}
</style>
