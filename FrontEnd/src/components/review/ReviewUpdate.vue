<template>
    <div class="container">
        <h1 style="text-align: center; font-weight: bold">
            {{ reviewStore.review.itemNm }} 리뷰 수정
        </h1>
        <br />

        <div class="container text-center">
            <div class="row">
                <div class="col up">
                    <div style="width: 100%">
                        <img style="width: 100%; height: 470px;" :src="reviewStore.review.img" />
                    </div>
                </div>

                <div class="col">
                    <div>
                        <div style="text-align: left; font-size: 200%">평점</div>
                        <StarRating class="star" :rating="reviewStore.review.rating" @update:rating="setRating"
                            active-on-click="true" />
                    </div>
                    <br />
                    <div style="text-align: left; font-size: 200%" for="content">
                        작성자 : {{ reviewStore.review.userId }}<br>
                        내용
                    </div>
                    <div>
                        <textarea style="font-size: 150%" id="content" cols="53" rows="6"
                            v-model="reviewStore.review.content"></textarea>
                    </div>
                    <button style="width: 15%" type="button" @click="update" class="btn btn-primary">
                        등록
                    </button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { useReviewStore } from "@/stores/review";
import { ref, onBeforeMount } from "vue";
import StarRating from "vue-star-rating";

const reviewStore = useReviewStore();
const route = useRoute();

const setRating = (rating) => {
    reviewStore.review.rating = rating;
};

onBeforeMount(() => {
    reviewStore.getOneReview(route.query.id);
});

const update = function () {
    reviewStore.updateReview(reviewStore.review);
};
</script>

<style scoped>
.up {
    display: flex;
}
</style>
