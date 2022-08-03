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
import ClientProfile from "../components/ClientProfile.vue";
import ClientDeleteAccountRequests from "../components/ClientDeleteAccountRequests.vue";
import ClientHistoryReservations from "../components/ClientHistoryReservations.vue";
import ClientComplaints from "../components/ClientComplaints.vue";
import BoatOwnerHomePage from "../components/BoatOwnerHomePage.vue";
import BoatOwnerProfile from "../components/BoatOwnerProfile.vue";
import CottageOwnerHomePage from "../components/CottageOwnerHomePage.vue";
import CottageOwnerProfile from "../components/CottageOwnerProfile.vue";
import CottageProfile from "../components/CottageProfile.vue";
import BoatProfile from "../components/BoatProfile.vue";

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
    {
      path: "/client-profile",
      component: ClientProfile,
    },
    {
      path: "/client-delete-account-requests",
      component: ClientDeleteAccountRequests,
    },
    {
      path: "/client-reservations-history",
      component: ClientHistoryReservations,
    },
    {
      path: "/client-complaints",
      component: ClientComplaints,
    },
    {
      path: "/boatOwner-home-page",
      component: BoatOwnerHomePage,
    },
    {
      path: "/boatOwner-profile",
      component: BoatOwnerProfile,
    },
    {
      path: "/cottageOwner-home-page",
      component: CottageOwnerHomePage,
    },
    {
      path: "/cottageOwner-profile",
      component: CottageOwnerProfile,
    },
    {
      path: "/cottage-profile",
      component: CottageProfile,
    },
    {
      path: "/boat-profile",
      component: BoatProfile,
    },
  ],
});

export default router;