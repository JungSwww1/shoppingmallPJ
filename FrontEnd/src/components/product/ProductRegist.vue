<template>
  <div class="container">
    <br />
    <h2 style="text-align: center">상품 등록</h2>
    <br />
    <fieldset class="text-center">
      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">상품명</span>
        <input
          type="text"
          id="itemNm"
          v-model="itemNm"
          class="form-control view"
          aria-label="Username"
          aria-describedby="basic-addon1"
        /><br />
      </div>

      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">가격</span>
        <input
          type="text"
          id="price"
          v-model="price"
          class="form-control view"
          aria-label="Username"
          aria-describedby="basic-addon1"
        /><br />
      </div>

      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">재고</span>
        <input
          type="text"
          id="stockNumber"
          v-model="stockNumber"
          class="form-control view"
          aria-label="Username"
          aria-describedby="basic-addon1"
        /><br />
      </div>

      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">상품 설명</span>
        <input
          type="text"
          id="itemDetail"
          v-model="itemDetail"
          class="form-control view"
          aria-label="Username"
          aria-describedby="basic-addon1"
        /><br />
      </div>

      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">카테고리</span>
        <input
          type="text"
          id="category"
          v-model="category"
          class="form-control view"
          aria-label="Username"
          aria-describedby="basic-addon1"
        /><br />
      </div>

      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">파일</span>
        <input type="file" @change="handleFileUpload" accept="image/*" />
        <br /><br />
      </div>
      <button class="btn btn-primary" @click="regist">등록</button>
    </fieldset>
    <img :src="imageUrl" v-if="imageUrl" alt="Uploaded Image" />
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useProductStore } from "@/stores/product";

const store = useProductStore();

const itemNm = ref("");
const price = ref("");
const stockNumber = ref("");
const itemDetail = ref("");
const category = ref("");
const imgUrl = ref("");

let file = null;

const handleFileUpload = (event) => {
  file = event.target.files[0];
  console.log(file);
  imgUrl.value = URL.createObjectURL(file);
  console.log(imgUrl.value);
};

const regist = () => {
  const formData = new FormData();
  formData.append("file", file);

  const product = {
    itemNm: itemNm.value,
    price: price.value,
    stockNumber: stockNumber.value,
    itemDetail: itemDetail.value,
    category: category.value,
  };
  // formData.append('product', product)
  formData.append(
    "product",
    new Blob([JSON.stringify(product)], {
      type: "application/json",
    })
  );
  store.productregist(formData);
};
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
