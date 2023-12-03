import { defineStore } from "pinia";
// import { ref } from "vue";
import axios from "axios";

import router from "@/router/index.js";

export const useRegistStore = defineStore("regist", () => {
  const regist = function (user) {
    const API_URL = `http://localhost:8080/api-user/signup`;
    axios
      .post(API_URL, {
        id: user.id,
        password: user.password,
        name: user.name,
        address: user.address,
        email: user.email,
        number: user.number,
      })
      .then((res) => {
        if (res.data == 1) {
          alert("등록 완료");
          router.push("/");
        } else {
          alert("아이디가 중복되었습니다");
        }
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return { regist };
});
