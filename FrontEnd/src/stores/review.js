import { ref, computed } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "axios";

import { useLoginStore } from "@/stores/login";

const REST_review_API = `http://localhost:8080/api/review`;

export const useReviewStore = defineStore("review", () => {
  const reviewList = ref([]);
  const review = ref({});
  const loginStore = useLoginStore();

  //유저가 쓴 리뷰들
  const getUserReview = function (id) {
    axios.get(`${REST_review_API}/user/${id}`).then((response) => {
      reviewList.value = response.data;
    });
  };

  //물품 리뷰들
  const getProductReview = function (id) {
    console.log(id);
    axios.get(`${REST_review_API}/product/${id}`).then((response) => {
      reviewList.value = response.data;
    });
  };

  //리뷰 등록
  const registReview = function (review) {
    axios({
      url: REST_review_API,
      method: "POST",
      //아래꺼 없어도 알아서 보내더라 axios 쵝오~
      headers: {
        "Content-Type": "application/json",
      },
      data: review,
    })
      .then(() => {
        alert("리뷰가 등록되었습니다")
        router.push({ name: "orderInfo" });
      })
      .catch((err) => {
        console.log(err);
      });
  };

  // 리뷰 한개 가져오기
  const getOneReview = function (id) {
    console.log(id);
    axios.get(`${REST_review_API}/${id}`).then((response) => {
      review.value = response.data;
    });
  };

  // 리뷰 업데이트
  const updateReview = function (re) {
    console.log(loginStore.loginUser.id)
    axios.put(REST_review_API, re, {
      headers: {
        "Content-type": "application/json",
      }
    }).then(() => {
      console.log(loginStore.loginUser.id)
      alert("수정이 완료되었습니다")
      router.push({ name: "reviewList", query: { userId: loginStore.loginUser.id } });
    })
      .catch((err) => {
        console.log(err);
      });
  };

  // 리뷰 삭제
  const deleteReview = function (id) {
    axios
      .delete(`${REST_review_API}/${id}`)
      .then(() => {
        alert("리뷰가 삭제되었습니다.")
        getUserReview(loginStore.loginUser.id);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return {
    reviewList,
    getUserReview,
    getProductReview,
    review,
    registReview,
    updateReview,
    deleteReview,
    getOneReview
  };
});
