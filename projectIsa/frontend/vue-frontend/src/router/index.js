import { createRouter, createWebHistory } from "vue-router";
import LandingPage from "../components/LandingPage.vue";
import ClientRegistration from "../components/ClientRegistration.vue";

const routerHistory = createWebHistory();
const router = createRouter({
  history: routerHistory,
  routes: [
    {
      path: "/",
      component: LandingPage,
    },
    {
      path: "/registration",
      component: ClientRegistration,
    },
  ],
});
export default router;