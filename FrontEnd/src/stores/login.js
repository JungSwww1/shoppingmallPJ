import { defineStore } from "pinia";
import { ref, computed } from "vue";
import axios from "axios";

// js에서는 직접 가져와야 함.
import router from "@/router/index.js";

export const useLoginStore = defineStore(
  "login",
  () => {
    const loginUser = ref({});

    // 관리자 확인
    const isAdmin = computed(() => !!loginUser.value.admin);

    //로그인
    const login = function (user) {
      const API_URL = `http://localhost:8080/api-user/login`;
      axios
        .post(API_URL, {
          id: user.id,
          password: user.password,
        })
        .then((res) => {
          console.log(res.data);
          if (res.data) {
            loginUser.value = res.data;
            localStorage.setItem("loginUser", JSON.stringify(res.data));
            router.push("/");
          } else {
            alert("아이디 또는 비밀번호가 일치하지 않습니다");
          }
        })
        .catch((err) => {
          console.log(err);
          alert("서버 에러");
        });
    };

    //로그아웃
    const logout = function () {
      loginUser.value = {};
      localStorage.removeItem("loginUser");
      router.push("/login");
    };

    //내 정보 비밀번호 확인
    const check = function (user) {
      if (
        loginUser.value.id === user.id &&
        loginUser.value.password === user.password
      ) {
        alert("확인되었습니다");
        router.push("/UserUpdate");
      } else {
        alert("다시 입력해주세요");
      }
    };

    //유저 정보 수정
    const update = function () {
      axios
        .put(`http://localhost:8080/api-user/update`, loginUser.value)
        .then(() => {
          alert("정보 수정 완료");
          router.push("/");
        });
    };
    return { loginUser, login, logout, isAdmin, check, update };
  },
  { persist: true }
);
