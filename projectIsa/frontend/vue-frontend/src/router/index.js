import { createRouter, createWebHistory } from "vue-router";
import LandingPage from "../components/LandingPage.vue";
import ClientRegistration from "../components/ClientRegistration.vue";
import OwnersInstructorRegistration from "../components/OwnersInstructorRegistration.vue";
import RegistrationChoice from "../components/RegistrationChoice.vue";
import AdminPage from "../components/AdminPage.vue";
import RegistrationRequests from "../components/RegistrationRequests.vue";

import LoginUser from "../components/LoginUser.vue";
import ClientHomePage from "../components/ClientHomePage.vue";
import InstructorHomePage from "../components/InstructorHomePage.vue";


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
      path: "/admin-home-page",
      component: AdminPage,
    },
    {
      path: "/registration-requests",
      component: RegistrationRequests,
    },
    {
      path: "/login",
      component: LoginUser,
    },
    {
      path: "/login/:token?",
      component: LoginUser,
    },
    {
      path: "/client-home-page",
      component: ClientHomePage,
    },
    {
      path: "/instructor-home-page",
      component: InstructorHomePage,
    },
  ],
});

export default router;