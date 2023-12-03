import { ref, computed } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "@/util/http-common.js";

export const useOrderStore = defineStore("order", () => {
  const order = ref([]);
  //사용자 아이디에 해당하는 제품들 다 가져오기
  const getOrder = (id) => {
    axios
      .get(`http://localhost:8080/api/order/${id}`)
      .then((res) => {
        order.value = res.data;
      })
      .catch((err) => {
        console.log(err);
      });
  };

  // 총 가격
  const totalPrice = computed(() => {
    if (order.value) {
      return order.value.reduce((total, item) => {
        return total + item.productCnt * item.price;
      }, 0);
    }
    return 0;
  });

  // 결제하기 눌렀을 때 장바구니 삭제
  const orderPay = (id) => {
    axios
      .delete(`http://localhost:8080/api/order1/${id}`)
      .then(() => {})
      .catch((res) => {
        console.log(res);
      });
  };

  // 단일 상품 취소
  const singlePayback = (singleOrder) => {
    const order = ref({
      id: singleOrder.id,
      orderId: singleOrder.orderId,
      productCnt: singleOrder.productCnt,
    });
    //order_product에서 단일 삭제
    axios.put(`http://localhost:8080/api/order`, order.value).then(() => {
      //주문 취소 시 product에서 수량 증가
      axios.put(`http://localhost:8080/api/order1`, order.value).then(() => {
        //order_product가 비어있을 시 해당 order 삭제
        axios
          .put(`http://localhost:8080/api/order2`, order.value)
          .then(() => {});
      });
    });
  };

  //단일 상품 취소 Promise 버전
  const singlePaybackPromise = (singleOrder) => {
    return new Promise((resolve, reject) => {
      const order = ref({
        id: singleOrder.id,
        orderId: singleOrder.orderId,
        productCnt: singleOrder.productCnt,
      });

      //order_product에서 단일 삭제
      axios
        .put(`http://localhost:8080/api/order`, order.value)
        .then(() => {
          return axios.put(`http://localhost:8080/api/order1`, order.value);
        })
        .then(() => {
          // chaining을 하고 싶다면 promise를 return하면된다!
          return axios.put(`http://localhost:8080/api/order2`, order.value);
        })
        .then(() => {
          // 모든 작업이 완료되었을 때
          resolve();
        })
        .catch((e) => {
          reject(e);
        });
    });
  };

  const paybackAll = () => {
    alert("전체 주문이 취소되었습니다.");
    Promise.all(
      order.value.map((singleOrder) => singlePaybackPromise(singleOrder))
    ).then(() => {
      alert("전체 주문이 취소되었습니다.");
      // 모든 작업이 끝났을 때. 여기서만 수행가능..
    });
  };

  const paybackAllPromise = () => {
    return new Promise((resolve, reject) => {
      Promise.all(
        order.value.map((singleOrder) => singlePaybackPromise(singleOrder))
      )
        .then(() => {
          alert("전체 주문이 취소되었습니다.");
          order.value = [];
          resolve();
          // 모든 작업이 끝났을 때.
        })
        .catch(() => {
          reject();
        });
    });
  };

  // 주문 전체 취소
  const payback = () => {
    alert("전체 주문이 취소되었습니다.");
    order.value.forEach((singleOrder) => {
      const targetOrder = {
        orderId: singleOrder.orderId,
        id: singleOrder.id,
        productCnt: singleOrder.productCnt,
      };
      singlePayback(targetOrder);
    });
  };

  return {
    order,
    orderPay,
    getOrder,
    totalPrice,
    payback,
    singlePayback,
    paybackAllPromise,
  };
});
