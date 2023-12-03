import { ref, computed } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "@/util/http-common.js";

const REST_PRODUCT_API = `http://localhost:8080/api/product`;
export const useProductStore = defineStore("product", () => {
  const productList = ref([]);
  const product = ref({});
  const cart = ref([]);
  const purProductList = ref([]);
  const stockProductList = ref([]);
  const newProductList = ref([]);

  // 장바구니 총 금액
  const totalPrice = computed(() => {
    if (cart.value) {
      return cart.value.reduce((total, item) => {
        return total + item.productCnt * item.productPrice;
      }, 0);
    }
    return 0;
  });

  // 장바구니에서 수량 증가 버튼
  const cartCntUp = function (id) {
    cart.value = cart.value.map((c) => {
      if (c.id === id) {
        c.productCnt++;
        return c;
      } else {
        return c;
      }
    });
  };

  // 장바구니에서 수량 감소 버튼
  const cartCntDown = function (id) {
    cart.value = cart.value.map((c) => {
      if (c.id === id && c.productCnt > 1) {
        c.productCnt--;
        return c;
      } else {
        return c;
      }
    });
  };

  const getProductList = function (getInfo) {
    axios({
      url: "product",
      method: "GET",
      params: getInfo,
    }).then((res) => {
      productList.value = res.data;
    });
  };

  //id값에 따른 제품값 가져오기
  const getProduct = function (id) {
    const API_URL = `http://localhost:8080/api/product/${id}`;
    axios({
      url: API_URL,
      method: "GET",
    }).then((res) => {
      product.value = res.data;
    });
  };

  // 장바구니 화면 get방식으로 데이터 가져옴
  const getCartById = function (id) {
    const API_URL = `http://localhost:8080/api-cart/cart/${id}`;
    axios({
      url: API_URL,
      method: "GET",
    }).then((res) => {
      cart.value = res.data;
    });
  };

  //제품 등록
  const productregist = function (formData) {
    const API_URL = `http://localhost:8080/api/product`;
    console.log(formData.get("product"));
    axios
      .post(API_URL, formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      })
      .then(() => {
        alert("장바구니에 담았습니다");
        router.push("/");
      })
      .catch((err) => {
        console.log(err);
      });
  };

  // 장바구니에 추가
  const cartRegist = function (cartItem) {
    const API_URL = `http://localhost:8080/api-cart/cart`;
    axios
      .post(API_URL, {
        userId: cartItem.user_id,
        productId: cartItem.product_id,
        productPrice: cartItem.product_price,
        productCnt: cartItem.quantity,
      })
      .then(() => {
        alert("등록 완료");
        router.push("/");
      })
      .catch((err) => {
        console.log(err);
      });
  };

  //물품 수정
  const productUpdate = function () {
    axios.put(`http://localhost:8080/api/product`, product.value).then(() => {
      alert("물품 수정 완료");
    });
  };

  // 메인페이지 구매 많은 리스트 가져오기
  const getPurProductList = function () {
    const API_URL = `http://localhost:8080/api/product/purchase`;
    axios
      .get(API_URL)
      .then((res) => {
        purProductList.value = res.data;
      })
      .catch((err) => {
        console.log(err);
      });
  };

  // 메인페이지 판매 임박 리스트 가져오기
  const getStockProductList = function () {
    const API_URL = `http://localhost:8080/api/product/stock`;
    axios
      .get(API_URL)
      .then((res) => {
        stockProductList.value = res.data;
      })
      .catch((err) => {
        console.log(err);
      });
  };

  // 신상품 순으로 가져오기
  const getNewProductList = function () {
    const API_URL = `http://localhost:8080/api/product/new`;
    axios
      .get(API_URL)
      .then((res) => {
        newProductList.value = res.data;
      })
      .catch((err) => {
        console.log(err);
      });
  };

  //결제하기 재고 처리
  const orderUpdate = function () {
    cart.value.forEach((singleOrder) => {
      const targetOrder = {
        id: singleOrder.id,
        productCnt: singleOrder.productCnt,
      };

      axios
        .put(`http://localhost:8080/api/product/order`, targetOrder)
        .then(() => {
          console.log(`주문 ${targetOrder.id}이(가) 업데이트되었습니다.`);
        })
        .catch((err) => {
          console.error(err);
        });
    });

    alert("결제가 완료되었습니다.");
    router.push("/");
  };

  const getPrice = (id) => {
    const targetCart = cart.value.find((c) => c.id === id);
    return targetCart.productPrice * targetCart.productCnt;
  };
  //결제하기 눌렀을 때
  const finalPay = (user) => {
    const products = cart.value.map((c) => {
      return {
        id: c.productId,
        userId: c.userId,
        purchaseCnt: c.productCnt,
        itemNm: c.itemNm,
        totalPrice: getPrice(c.id),
      };
    });
    // 주소를 가져오기 위해 먼저 통신 후 DB에 넣기 위해 POST 통신
    axios
      .get(`http://localhost:8080/api-user/${user}`)
      .then((res) => {
        const userData = res.data[0]; // 데이터가 배열 형태이므로 [0]로 첫 번째 요소에 접근
        const userAddress = userData.address;
        const data = {
          userId: user,
          address: userAddress,
          products: products,
        };
        axios
          .post("http://localhost:8080/api-cart/order", data)
          .then(() => {})
          .catch(() => {
            console.log("주문 실패");
          });
      })
      .catch((err) => {
        console.log(err);
      });
  };

  //단일 결제하기 용도
  const order1 = ref({});
  const orderRegist = (order) => {
    order1.value = order.value;
  };

  const finalPay1 = (user) => {
    // 주소를 가져오기 위해 먼저 통신 후 DB에 넣기 위해 POST 통신
    axios
      .get(`http://localhost:8080/api-user/${user}`)
      .then((res) => {
        const userData = res.data[0]; // 데이터가 배열 형태이므로 [0]로 첫 번째 요소에 접근
        const userAddress = userData.address;
        const data = {
          userId: user,
          address: userAddress,
          products: [order1.value],
        };
        axios
          .post("http://localhost:8080/api-cart/order", data)
          .then(() => {})
          .catch(() => {
            console.log("주문 실패");
          });
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const orderUpdate1 = function () {
    axios
      .put(`http://localhost:8080/api/product/order`, order1.value)
      .then(() => {})
      .catch((err) => {
        console.error(err);
      });

    alert("결제가 완료되었습니다.");
    router.push("/");
  };

  return {
    order1,
    orderRegist,
    finalPay1,
    orderUpdate1,
    product,
    productList, // searchProductList
    productregist,
    productUpdate,
    getProduct,
    getProductList,
    cart,
    cartRegist,
    getCartById,
    cartCntDown,
    cartCntUp,
    totalPrice,
    getStockProductList,
    purProductList,
    getPurProductList,
    stockProductList,
    getNewProductList,
    newProductList,
    orderUpdate,
    finalPay,
  };
});
