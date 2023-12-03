<template>
  <div class="container">
    <h1>리뷰 관리</h1>
    <table class="table">
      <thead>
        <tr>
          <th style="width:15%;" scope="col">이미지</th>
          <th style="width:10%;" scope="col">상품명</th>
          <th style="width:10%;" scope="col">평점</th>
          <th style="width:8%;" scope="col">아이디</th>
          <th style="width:50%;" scope="col">내용</th>
          <th scope="col">날짜</th>
          <th scope="col">수정</th>
          <th scope="col">삭제</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="review in reviewStore.reviewList" :key="review.id">
          <td><img class="pimg" :src="review.img" /></td>
          <td>{{ review.itemNm }}</td>
          <td>
            <StarRating star-size="30" style="font-size: 0px;" class="star" read-only="true" :rating="review.rating" />
          </td>
          <td class="reviewId">{{ review.userId }}</td>
          <td>{{ review.content }}</td>
          <td>{{ review.regDate }}</td>
          <td><button type="button" @click="updateReview(review.id)" class="btn btn-light">수정</button></td>
          <td>
            <button type="button" @click="deleteReview(review.id)" class="btn btn-danger">
              삭제
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { useProductStore } from "@/stores/product";
import { useReviewStore } from "@/stores/review";
import { ref, onBeforeMount } from "vue";
import StarRating from "vue-star-rating";

const reviewStore = useReviewStore();
const route = useRoute();
const router = useRouter();

const deleteReview = (id) => {
  reviewStore.deleteReview(id);
};

const updateReview = (id) => {
  router.push({ name: 'reviewUpdate', query: { id: id } })
};

onBeforeMount(() => {
  reviewStore.getUserReview(route.query.userId);
});
</script>

<style scoped>
.pimg {
  width: 100%;
}

td {
  text-align: center;
  display: table-cell;
  vertical-align: middle;
}
</style>
