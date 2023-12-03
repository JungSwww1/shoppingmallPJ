<template>
  <div>
    <h1 style="text-align: center">{{ store.loginUser.id }}님의 주문 정보</h1>
    <br />
    <div v-if="!store2.order" class="noContentContainer">
      <div class="noContent">
        <i class="bi bi-exclamation-circle" style="font-size: 3em"></i><br />
        주문 정보가 없습니다.
      </div>
    </div>
    <!-- 주문 정보가 있을 때 -->
    <div v-else class="container" style="text-align: center">
      <table class="table">
        <thead>
          <tr>
            <th scope="col">상품 사진</th>
            <th scope="col">상품명</th>
            <th scope="col">가격</th>
            <th scope="col">구매 수량</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="singleOrder in store2.order" :key="singleOrder.order_id">
            <td width="300">
              <img height="150" width="180" :src="singleOrder.img" alt="image" style="border-radius: 5%" />
            </td>
            <td style="vertical-align: middle">
              <p class="card-title">{{ singleOrder.itemNm }}</p>
            </td>
            <td style="vertical-align: middle">
              <p>
                {{
                  singleOrder.price
                    .toString()
                    .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                }}
                원
              </p>
            </td>
            <td style="vertical-align: middle">
              <p>{{ singleOrder.productCnt }}</p>
            </td>
            <td style="vertical-align: middle">
              <button @click="singlePayback(singleOrder)" class="btn btn-danger">
                환불
              </button>
              <span style="margin-left: 20px"></span>
              <div>
                <RouterLink v-if="singleOrder.reviewCheck == 0" :to="{
                  name: 'reviewForm',
                  query: {
                    productId: singleOrder.id,
                    userId: singleOrder.userId,
                    orderId: singleOrder.orderId,
                  },
                }" style="
                          text-decoration: none;
                          color: black;
                          display: inline-block;
                          border: 1px solid #ccc;
                          padding: 5px;
                          border-radius: 10%;
                          background-color: antiquewhite;
                          margin-top: 10px;
                          margin-right: 17px;
                        ">리뷰
                </RouterLink>
              </div>
            </td>
          </tr>
        </tbody>
      </table>

      <!-- 전체환불 부분 -->
      <div class="card-footer" style="text-align: end">
        <button @click="payback(store.loginUser.id)" class="btn btn-danger">
          전체 환불</button><br /><br />
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { useLoginStore } from "../../stores/login";
import { useOrderStore } from "@/stores/order";
import { onMounted, ref } from "vue";
import axios from "axios";

const store = useLoginStore();
const store2 = useOrderStore();
const router = useRouter();
const user = store.loginUser.id;

// 단일 상품 취소
const singlePayback = (singleOrder) => {
  store2.singlePayback(singleOrder);
  alert("해당 주문이 취소되었습니다.");
  store2.getOrder(user);
  router.push("/orderInfo");
};

// 전체 취소
const payback = (userId) => {
  // store2.payback(); // 비동기 작업(서버에 요청을 날리는 코드 포함)
  // store2.getOrder(userId); // 비동기 작업
  // router.push("/orderInfo"); // 동기
  store2.paybackAllPromise().then(() => {
    store2.getOrder(userId);
  });
};

// order에 있는 것을 가져오기 위함
onMounted(() => {
  store2.getOrder(user);
});
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
