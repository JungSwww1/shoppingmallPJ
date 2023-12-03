import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import ProductList from "@/components/product/ProductList.vue";
import ProductRegist from "@/components/product/ProductRegist.vue";
import ProductDetail from "@/components/product/ProductDetail.vue";
import ProductUpdate from "@/components/product/ProductUpdate.vue";
import UserLogin from "@/components/user/UserLogin.vue";
import UserRegist from "@/components/user/UserRegist.vue";
import UserCheck from "@/components/user/UserCheck.vue";
import UserUpdate from "@/components/user/UserUpdate.vue";
import CartList from "@/components/cart/CartList.vue";
import OrderForm from "@/components/order/OrderForm.vue";
import OrderInfo from "@/components/order/OrderInfo.vue";
import SingleOrderForm from "@/components/order/SingleOrderForm.vue";
import ReviewForm from "@/components/review/ReviewForm.vue";
import ReviewList from "@/components/review/ReviewList.vue";
import ReviewUpdate from "@/components/review/ReviewUpdate.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/productList",
      name: "productList",
      component: ProductList,
    },
    //물품 등록
    {
      path: "/productRegist",
      name: "productRegist",
      component: ProductRegist,
    },
    //물품 상세
    {
      path: "/productDetail/:id",
      name: "productDetail",
      component: ProductDetail,
    },
    //물품 수정
    {
      path: "/productUpdate/:id",
      name: "productUpdate",
      component: ProductUpdate,
    },
    // 장바구니
    {
      path: "/cartList/:id",
      name: "cartList",
      component: CartList,
    },
    // 로그인
    {
      path: "/login",
      name: "login",
      component: UserLogin,
    },
    // 로그아웃
    {
      path: "/regist",
      name: "regist",
      component: UserRegist,
    },
    // 내 정보 수정시 비밀번호 확인
    {
      path: "/userCheck",
      name: "userCheck",
      component: UserCheck,
    },
    // 내 정보 수정 페이지
    {
      path: "/userUpdate",
      name: "userUpdate",
      component: UserUpdate,
    },
    // 주문하기
    {
      path: "/orderForm/:id",
      name: "orderForm",
      component: OrderForm,
    },
    // 단일 구매하기
    {
      path: "/singleOrderForm/:id",
      name: "singleOrderForm",
      component: SingleOrderForm,
    },
    // 주문 조회
    {
      path: "/orderInfo",
      name: "orderInfo",
      component: OrderInfo,
    },
    // 리뷰
    {
      path: "/reviewForm",
      name: "reviewForm",
      component: ReviewForm,
    },
    {
      path: "/reviewList",
      name: "reviewList",
      component: ReviewList,
    },
    {
      path: "/reviewUpdate",
      name: "reviewUpdate",
      component: ReviewUpdate,
    },
  ],
});

export default router;
