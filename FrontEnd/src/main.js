import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-icons/font/bootstrap-icons.css";
import "bootstrap/dist/js/bootstrap.js";
import { createApp } from "vue";
import { createPinia } from "pinia";
import piniaPluginPersistedstate from "pinia-plugin-persistedstate";
import App from "./App.vue";
import router from "./router";

const app = createApp(App);
const pinia = createPinia();
// app.config.globalProperties.$axios = axios;
pinia.use(piniaPluginPersistedstate);
app.use(createPinia());
app.use(router);
app.use(pinia);

app.mount("#app");
