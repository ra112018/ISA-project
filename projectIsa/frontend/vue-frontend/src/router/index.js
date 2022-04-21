import { createRouter, createWebHistory } from "vue-router";
import LandingPage from "../components/LandingPage.vue";
import ClientRegistration from "../components/ClientRegistration.vue";
import OwnersInstructorRegistration from "../components/OwnersInstructorRegistration.vue";
import RegistrationChoice from "../components/RegistrationChoice.vue";
import LoginPage from "../components/LoginPage.vue";


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
      path: "/registration-owner-instructor",
      component: OwnersInstructorRegistration,
    },
    {
      path: "/login",
      component: LoginPage,
    },
  ],
});
export default router;