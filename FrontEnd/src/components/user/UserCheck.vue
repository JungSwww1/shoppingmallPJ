<template>
  <div>
    <br />
    <h2 style="text-align: center">비밀번호 확인</h2>
    <br /><br />
    <fieldset class="text-center">
      <div class="input-group mb-3">
        <input
          type="password"
          id="password"
          v-model="password"
          class="form-control view"
          aria-label="Username"
          aria-describedby="basic-addon1"
          @keyup.enter="check"
          placeholder="비밀번호를 입력해주세요"
        /><br />
        <button class="btn btn-primary" @click="check" s>확인</button>
      </div>
    </fieldset>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useLoginStore } from "@/stores/login";

const store = useLoginStore();
const password = ref("");
// 비밀번호 확인
const check = () => {
  let user = {
    id: store.loginUser.id,
    password: password.value,
  };

  store.check(user);
};
</script>

<style scoped>
.input-group {
  margin: auto auto;
  width: 500px;
  height: 50px;
}
</style>
