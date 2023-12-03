<template>
  <div>
    <br />
    <h1 style="text-align: center">유저 정보 수정 페이지</h1>
    <div style="text-align: center">
    </div>
    <br />
    <div class="form">
      <fieldset class="text-center">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">아이디</span>
          <input type="text" id="id" v-model="store.loginUser.id" class="form-control view" aria-label="Username"
            aria-describedby="basic-addon1" /><br />
        </div>

        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">비밀번호</span>
          <input type="text" id="password" v-model="store.loginUser.password" aria-label="password"
            aria-describedby="basic-addon1" class="form-control view" /><br />
        </div>

        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">번호</span>
          <input type="text" id="number" v-model="store.loginUser.number" aria-label="number"
            aria-describedby="basic-addon1" class="form-control view" /><br />
        </div>

        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">이메일</span>
          <input type="text" id="email" v-model="store.loginUser.email" aria-label="email" aria-describedby="basic-addon1"
            class="form-control view" /><br />
        </div>

        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">주소</span>
          <input type="text" id="address" v-model="store.loginUser.address" aria-label="address"
            aria-describedby="basic-addon1" class="form-control view" /><br />
        </div>

        <button class="btn" @click="update">수정</button>
      </fieldset>
    </div>
  </div>
</template>

<script setup>
import { useLoginStore } from "../../stores/login";

const store = useLoginStore();
const update = () => {
  store.update();
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

.btn {
  font-size: 20px;
  background-color: blanchedalmond;
}
</style>
