<template>
  <div>
    <br />
    <h1 style="text-align: center">물품 수정페이지입니다</h1>
    <div class="form">
      <fieldset class="text-center">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">상품명</span>
          <input
            type="text"
            id="itemNm"
            v-model="store.product.itemNm"
            class="form-control view"
            aria-label="itemNm"
            aria-describedby="basic-addon1"
          /><br />
        </div>
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">가격</span>
          <input
            type="text"
            id="price"
            v-model="store.product.price"
            class="form-control view"
            aria-label="price"
            aria-describedby="basic-addon1"
          /><br />
        </div>
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">재고</span>
          <input
            type="text"
            id="stockNumber"
            v-model="store.product.stockNumber"
            class="form-control view"
            aria-label="stockNumber"
            aria-describedby="basic-addon1"
          /><br />
        </div>
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">상품 설명</span>
          <input
            type="text"
            id="itemDetail"
            v-model="store.product.itemDetail"
            class="form-control view"
            aria-label="itemDetail"
            aria-describedby="basic-addon1"
          /><br />
        </div>
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">카테고리</span>
          <input
            type="text"
            id="category"
            v-model="store.product.category"
            class="form-control view"
            aria-label="category"
            aria-describedby="basic-addon1"
          /><br />
        </div>
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">이미지</span>
          <input type="file" @change="handleFileUpload" accept="image/*" />
        </div>
        <button class="btn btn-primary" @click="update">수정</button>
      </fieldset>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useProductStore } from "@/stores/product";
import { useRoute } from "vue-router";

const route = useRoute();
const store = useProductStore();
const productId = route.params.id;

//업데이트 버튼 누를 때
const update = () => {
  store.productUpdate();
};

//초기 화면 띄우기
onMounted(() => {
  store.getProduct(productId);
});
</script>

<style scoped>
.input-group {
  margin: auto auto;
  width: 800px;
  height: 50px;
}

.form {
  text-align: center;
  margin-top: 50px;
}
#basic-addon1 {
  width: 140px;
}
</style>
