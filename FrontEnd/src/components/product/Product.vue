<template>
  <RouterLink :to="`/productDetail/${product.id}`" class="card col-12 col-sm-6 col-md-3" style="width: 18rem">
    <img style="margin-bottom: 13px;" height="270" width="200" :src="product.img" class="card-img-top" alt="image" />
    <div class="rating" style="display: flex; align-items: center;">
      <StarRating star-size="25" :increment="0.01" style="font-size: 0px; margin-left:5%" class="star" read-only="true"
        :rating="product.avgRating" />
      <span style="margin-left: 5px;">{{ product.avgRating }}</span>
    </div>
    <div class="card-body">
      <p class="card-title">{{ product.itemNm }}</p>
      <p class="card-text">{{ price }}</p>
      원
    </div>
  </RouterLink>
</template>

<script setup>
import { ref, computed } from "vue";
import StarRating from "vue-star-rating";

const props = defineProps({
  product: Object,
});

const price = computed(() => {
  return props.product.price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
});
</script>

<style scoped>
.card-text {
  display: inline;
  font-size: 25px;
  font-weight: bold;
}

.card-title {
  font-size: 18px;
}

.card {
  text-decoration: none;
  margin: 20px 21px 60px;
}
</style>
