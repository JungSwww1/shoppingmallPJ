<template>
  <div class="container">
    <img height="330" weight="1296" v-if="route.query.category == '옷'"
      src="https://img.echosting.cafe24.com/skin/dnd_ko_KR/common/module/login/@img_banner1.jpg" class="card-img-top"
      alt="image" />
    <img height="330" v-if="route.query.category == '프로틴'"
      src="https://file.rankingdak.com/image/RANK/BANNER/AR_IMG_1/20220415/IMG1649yjN987750237.jpg" class="card-img-top"
      alt="image" />
    <img height="330" v-if="route.query.category == '기구'"
      src="https://file.rankingdak.com/image/RANK/BANNER/AR_IMG_1/20230414/IMG1681Luv461702456.jpg" class="card-img-top"
      alt="image" />
    <img height="330" v-if="route.query.category == '음식'"
      src="https://file.rankingdak.com/image/RANK/BANNER/AR_IMG_1/20220415/IMG1649bRI987620630.jpg" class="card-img-top"
      alt="image" />

    <div class="headerContainer">
      <span v-if="route.query.category" class="categoryName">{{
        route.query.category
      }}</span>
      <span v-else class="searchSentence">
        {{ route.query.word }}에 대한 검색 결과입니다.</span>
      <div class="orderOption">
        <select @change="orderChange" v-model="order">
          <option value="purchaseCnt">판매량순</option>
          <option value="rowPrice">낮은가격순</option>
          <option value="highPrice">높은가격순</option>
          <option value="date">신상품순</option>
        </select>
      </div>
    </div>
    <div v-if="productList.length" class="row">
      <Product v-for="product in currentPageProductList" :key="product.id" :product="product" />
    </div>

    <div v-else class="noContentContainer">
      <i class="bi bi-exclamation-circle"></i><br />
      <div class="noContent">
        <span class="searchName">{{ route.query.word }}</span>
        에 대한 검색결과가 없습니다.<br />
        검색어가 올바른지 확인 후, 다시 입력해 주세요.
      </div>
    </div>

    <nav aria-label="Page navigation example">
      <ul class="pagination d-flex justify-content-center">
        <li class="page-item">
          <a class="page-link" :class="{ disabled: currentPage <= 1 }" @click.prevent="currentPage--" href="#">&lt;</a>
        </li>
        <li :class="{ active: currentPage == page }" v-for="page in pageCount" :key="page">
          <a class="page-link" @click.prevent="clickPage(page)" href="#">{{ page }}</a>
        </li>
        <li class="page-item"><a class="page-link" :class="{ disabled: currentPage >= pageCount }"
            @click.prevent="currentPage++" href="#">&gt;</a></li>
      </ul>
    </nav>

  </div>
</template>

<script setup>
import Product from "@/components/product/Product.vue";
import { useRoute, useRouter } from "vue-router";
import { useProductStore } from "@/stores/product";
import { ref, watch, computed } from "vue";

const route = useRoute();
const store = useProductStore();

const productList = computed(() => {
  return store.productList;
});

// 페이지네이션
const perPage = 8;

const currentPage = ref(1)

const pageCount = computed(() => {
  return Math.ceil(store.productList.length / perPage)
})

const clickPage = function (page) {
  currentPage.value = page
}

const currentPageProductList = computed(() => {
  return store.productList.slice(
    (currentPage.value - 1) * perPage,
    currentPage.value * perPage
  )
})

// 선택한 정렬 옵션
const order = ref("purchaseCnt");

// 정렬 메소드 구현
const orderChange = function () {
  if (order.value === "purchaseCnt") {
    getInfo.value.orderKey = "purchaseCnt";
    getInfo.value.orderByDir = "desc";
  } else if (order.value === "rowPrice") {
    getInfo.value.orderKey = "price";
    getInfo.value.orderByDir = "asc";
  } else if (order.value === "highPrice") {
    getInfo.value.orderKey = "price";
    getInfo.value.orderByDir = "desc";
  } else if (order.value === "date") {
    getInfo.value.orderKey = "regTime";
    getInfo.value.orderByDir = "desc";
  }
  store.getProductList(getInfo.value);
};

// 검색 단어
const word = computed(() => {
  return route.query.word;
});
// 선택한 카테고리
const category = computed(() => {
  return route.query.category;
});

// axios로 통신할 object
const getInfo = ref({
  category: category,
  word: word,
  orderKey: "purchaseCnt",
  orderByDir: "desc",
});

// getInfo.value가 바뀌면 메소드 실행
watch(() => {
  store.getProductList(getInfo.value);
});
</script>

<style scoped>
.categoryName {
  font-size: 35px;
}

.orderOption {
  text-align: right;
  display: inline-block;
  margin-top: 25px;
}

.headerContainer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 15px;
}

.noContentContainer {
  margin-top: 200px;
  text-align: center;
}

.noContent {
  font-size: 20px;
  font-weight: bold;
}

.searchSentence {
  font-size: 35px;
  font-weight: bold;
}

.bi {
  font-size: 400%;
}

.searchName {
  color: red;
}
</style>
