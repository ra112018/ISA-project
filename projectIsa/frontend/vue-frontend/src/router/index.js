import { createRouter, createWebHistory } from "vue-router";
import LandingPage from "../components/LandingPage.vue";
import ClientRegistration from "../components/ClientRegistration.vue";
import RegistrationChoice from "../components/RegistrationChoice.vue";
import LoginUser from "../components/LoginUser.vue";
import ClientHomePage from "../components/ClientHomePage.vue";

const routerHistory = createWebHistory();
const router = createRouter({
  history: routerHistory,
  routes: [
    {
      path: "/",
      component: LandingPage,
    },
    {
      path: "/registration-choice",
      component: RegistrationChoice,
    },
    {
      path: "/registration-client",
      component: ClientRegistration,
    },
    {
      path: "/login",
      component: LoginUser,
    },
    {
      path: "/client-home-page",
      component: ClientHomePage,
    },
  ],
});
export default router;