<template>
  <div class="container">
    <div class="form">
      <h2>안녕하세요!</h2>
      <h3>SSAFY몰에 오신걸 환영합니다</h3>
      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">아이디</span>
        <input
          type="text"
          v-model="id"
          id="id"
          class="form-control view"
          placeholder="Username"
          aria-label="Username"
          aria-describedby="basic-addon1"
          @keyup.enter="login"
        />
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">패스워드</span>
        <input
          type="password"
          v-model="password"
          id="password"
          class="form-control view"
          placeholder="Password"
          aria-label="Password"
          aria-describedby="basic-addon1"
          @keyup.enter="login"
        />
      </div>
      <button
        class="btn"
        style="background-color: blanchedalmond"
        @click="login"
      >
        로그인
      </button>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useLoginStore } from "@/stores/login";

const store = useLoginStore();

const id = ref("");
const password = ref("");

const login = () => {
  let user = {
    id: id.value,
    password: password.value,
  };

  store.login(user);
};
</script>

<style scoped>
.input-group {
  margin: auto auto;
  width: 500px;
  height: 50px;
}

.form {
  text-align: center;
  margin-top: 150px;
}

h2 {
  margin-right: 350px;
}

h3 {
  margin-right: 140px;
  margin-bottom: 80px;
}

#basic-addon1 {
  width: 100px;
}
</style>
