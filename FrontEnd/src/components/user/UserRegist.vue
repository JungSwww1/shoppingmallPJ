<template>
  <div class="container">
    <div class="form">
      <h2>회원가입</h2>

      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">아이디</span>
        <input
          type="text"
          v-model.trim="id"
          id="id"
          class="form-control view"
          placeholder="Username"
          aria-label="Username"
          aria-describedby="basic-addon1"
          @keyup.enter="regist"
        />
      </div>

      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">패스워드</span>
        <input
          type="password"
          v-model.trim="password"
          id="password"
          class="form-control view"
          placeholder="Password"
          aria-label="Password"
          aria-describedby="basic-addon1"
          @keyup.enter="regist"
        />
      </div>

      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">패스워드 확인</span>
        <input
          type="password"
          v-model.trim="password2"
          id="password2"
          class="form-control view"
          placeholder="Password check"
          aria-label="Password"
          aria-describedby="basic-addon1"
          @keyup.enter="regist"
        />
      </div>

      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">이름</span>
        <input
          type="text"
          v-model.trim="name"
          id="name"
          class="form-control view"
          placeholder="Name"
          aria-label="Password"
          aria-describedby="basic-addon1"
          @keyup.enter="regist"
        />
      </div>

      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">주소</span>
        <input
          type="text"
          v-model.trim="address"
          id="address"
          class="form-control view"
          placeholder="Address"
          aria-label="Password"
          aria-describedby="basic-addon1"
          @keyup.enter="regist"
        />
      </div>

      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">이메일</span>
        <input
          type="text"
          v-model.trim="email"
          id="email"
          class="form-control view"
          placeholder="E-mail"
          aria-label="Password"
          aria-describedby="basic-addon1"
          @keyup.enter="regist"
        />
      </div>

      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">번호</span>
        <input
          type="text"
          v-model.trim="number"
          id="number"
          class="form-control view"
          placeholder="Phone Number"
          aria-label="Password"
          aria-describedby="basic-addon1"
          @keyup.enter="regist"
        />
      </div>

      <button class="btn" @click="regist">등록</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRegistStore } from "@/stores/userregist";

const store = useRegistStore();

const id = ref("");
const password = ref("");
const password2 = ref("");
const name = ref("");
const address = ref("");
const email = ref("");
const number = ref("");

// const users = ref([]);

const regist = () => {
  const user = {
    id: id.value,
    password: password.value,
    name: name.value,
    address: address.value,
    email: email.value,
    number: number.value,
  };

  if (
    id.value.length == 0 ||
    password.value.length == 0 ||
    name.value.length == 0 ||
    address.value.length == 0 ||
    email.value.length == 0 ||
    number.value.length == 0
  ) {
    alert("공백이 존재합니다.");
    return;
  }

  if (password.value.length < 8) {
    alert("비밀번호는 8자리 이상이어야 합니다.");
    return;
  } else {
    if (!passwordValid()) {
      alert("비밀번호는 특수 문자를 포함해야 합니다.");
      return;
    }
  }
  if (!passwordMatch()) {
    alert("비밀번호가 일치하지 않습니다.");
    return;
  }
  if (!emailValid()) {
    alert("올바른 이메일을 입력해주세요.");
    return;
  }

  store.regist(user);
};

//이메일
const emailValid = () => {
  const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
  return emailPattern.test(email.value);
};

//비밀번호 8자리 이상 및 특수문자 포함
const passwordValid = () => {
  const passwordValid = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
  return passwordValid.test(password.value);
};

//비밀번호 일치
const passwordMatch = () => {
  return password.value === password2.value;
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

h2 {
  margin-right: 600px;
  margin-bottom: 50px;
}

#basic-addon1 {
  width: 140px;
}

.btn {
  font-size: 20px;
}
</style>
