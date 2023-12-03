<template>
  <div class="container">
    <h1 style="text-align: center; font-weight: bold">
      {{ store.product.itemNm }} 리뷰 작성
    </h1>
    <br />

    <div class="container text-center">
      <div class="row">
        <div class="col up">
          <div style="width: 100%">
            <img style="width: 100%" :src="store.product.img" />
          </div>
        </div>

        <div class="col">
          <div>
            <div style="text-align: left; font-size: 200%">평점</div>
            <StarRating class="star" @update:rating="setRating" active-on-click="true" />
          </div>
          <br />
          <div style="text-align: left; font-size: 200%" for="content">
            작성자 : {{ reviewStore.review.userId }}<br>
            내용
          </div>
          <div>
            <textarea style="font-size: 150%" id="content" cols="53" rows="6" v-model="review.content"></textarea>
          </div>
          <button style="width: 15%" type="button" @click="regist" class="btn btn-primary">
            등록
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { useProductStore } from "@/stores/product";
import { useReviewStore } from "@/stores/review";
import { ref, onBeforeMount } from "vue";
import StarRating from "vue-star-rating";

const store = useProductStore();
const reviewStore = useReviewStore();
const route = useRoute();

const setRating = (rating) => {
  review.value.rating = rating;
  console.log(review.value.rating);
};

onBeforeMount(() => {
  store.getProduct(route.query.productId);
});

const review = ref({
  productId: route.query.productId,
  userId: route.query.userId,
  orderId: route.query.orderId,
  content: "",
  rating: 0,
});

const regist = function () {
  reviewStore.registReview(review.value);
};
</script>

<style scoped>
.up {
  display: flex;
}
</style>
