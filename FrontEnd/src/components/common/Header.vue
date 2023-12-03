<template>
  <div class="container">
    <nav>

      <div class="head">
        <a href="#" v-if="store2.loginUser.id" @click="logout">로그아웃 </a>
        <span v-if="store2.loginUser.id">| </span>
        <RouterLink v-if="store2.loginUser.id" :to="{ name: 'userCheck' }">내 정보</RouterLink>
        <span v-if="store2.loginUser.id"> | </span>
        <RouterLink v-if="store2.loginUser.id" :to="{ name: 'reviewList', query: { userId: store2.loginUser.id } }">리뷰 관리
        </RouterLink>
        <div v-else>
          <RouterLink to="/login">로그인 </RouterLink>|
          <RouterLink :to="{ name: 'regist' }">회원가입</RouterLink>
        </div>
        <RouterLink :to="{ name: 'productRegist' }" v-if="store2.isAdmin">
          <span> |</span>
          물품 등록
        </RouterLink>
      </div>

      <div class="middle">
        <RouterLink class="home" to="/">SSAFYMALL</RouterLink>
        <div class="input-group mb-3">
          <input type="text" class="form-control" placeholder="상품명을 입력하세요." aria-label="Recipient's username"
            aria-describedby="button-addon2" @keyup.enter="searchProductList" v-model="word" />
          <button class="btn btn-outline-secondary" type="button" id="button-addon2" @click="searchProductList">
            검색
          </button>
        </div>
        <div class="icon1">
          <RouterLink v-if="store2.loginUser.id" :to="{ name: 'orderInfo', params: { id: store2.loginUser.id } }">
            <i class="bi bi-wallet2"></i>
            <div class="iconName">주문내역</div>
          </RouterLink>
        </div>
        <span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <div class="idcon2">
          <RouterLink v-if="store2.loginUser.id" :to="{ name: 'cartList', params: { id: store2.loginUser.id } }"><i
              class="bi bi-cart2"></i>
            <div class="iconName">장바구니</div>
          </RouterLink>
        </div>
      </div>
    </nav>
    <hr />

    <ul class="nav category">
      <li class="nav-item">
        <RouterLink class="nav-link" :to="{ name: 'productList', query: { category: '옷' } }"><i
            class="bi bi-backpack2"></i>옷</RouterLink>
      </li>
      <li class="nav-item">
        <RouterLink class="nav-link" :to="{ name: 'productList', query: { category: '기구' } }"><i
            class="bi bi-lungs"></i>기구</RouterLink>
      </li>
      <li class="nav-item">
        <RouterLink class="nav-link" :to="{ name: 'productList', query: { category: '음식' } }"><i class="bi bi-egg"></i>음식
        </RouterLink>
      </li>
      <li class="nav-item">
        <RouterLink class="nav-link" :to="{ name: 'productList', query: { category: '프로틴' } }"><i
            class="bi bi-cup-straw"></i>프로틴</RouterLink>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from "vue";
import { useProductStore } from "@/stores/product";
import { useLoginStore } from "@/stores/login";
import { useRouter } from "vue-router";
const router = useRouter();

const store = useProductStore();

//로그아웃
const { loginUser, logout } = useLoginStore();
const store2 = useLoginStore();

onMounted(() => {
  const savedUser = localStorage.getItem(loginUser.value);
  if (savedUser) {
    user.value = JSON.parse(savedUser);
  }
});

//헤더 검색 2
const word = ref("");
const searchProductList = function () {
  if (word.value.length < 1) {
    alert("글자를 입력해 주세요");
  } else {
    router.push({ name: "productList", query: { word: word.value } });
  }
};
</script>

<style scoped>
/* 헤더 css */

/* 헤더-헤더 css */

.head {
  text-align: right;
  font-size: 80%;
  opacity: 0.6;
}

.input-group {
  width: 40%;
  margin: 0 auto;
}

/* 헤더-middle css */

.middle {
  margin-top: 20px;
  display: flex;
  text-align: center;
  align-items: center;
}

.input-group {
  margin: auto auto;
  align-items: center;
}

.home {
  font-size: 200%;
}

.iconName {
  font-size: 80%;
}

/* 카테고리 css */
nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  text-decoration: none;
  color: black;
}

.nav:hover {
  text-decoration: none;
}

.nav-item a {
  color: black;
  font-size: 20px;
}

.nav-item a:hover {
  color: red;
}

.bi {
  font-size: 30px;
}

hr {
  margin: 0px;
}

.category {
  margin-bottom: 15px;
}

.hrMargin {
  margin-bottom: 30px;
}
</style>
