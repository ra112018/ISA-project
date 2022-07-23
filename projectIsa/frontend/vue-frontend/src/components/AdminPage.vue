<template>
      <NavigationBar />
      <div class="navAdmin">
      <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <div class="dropleft">
                <div class="links">
                <router-link to="/registration-requests" class="adminLink">Registration Requests</router-link>
                </div>
                <div class="links">
                <router-link to="/" class="adminLink">Admin privileges</router-link>
                </div>
                <div class="links">
                <router-link to="/client-delete-account-requests" class="adminLink">Client delete account requests</router-link>
                </div>
                <div class="links">
                <router-link to="/client-complaints" class="adminLink">Client complaints</router-link>
                </div>
            </div>
      </nav>
    </div>
</template>

<script>
//import router from '@/router'
import NavigationBar from "../components/NavigationBar.vue";

export default {
    name : 'AdminPage',
    components: {
      NavigationBar
    },
    data() {
       return {

        showErrorMessage : false,
       
       }
    },
    methods: {
    },
    created() {
        
    }

}
</script>

<style>

.navAdmin{
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
  border-right: solid lightgreen 1px;
  border-bottom: solid lightgreen 1px;
  border-radius: 2%;
  width:25%;
}

.navAdmin a {
  font-weight: bold;
  padding-left: 20px;
  padding-right: 20px;
  text-decoration: none;
}
.adminLink {
    font-size: 15px;
    color: green;
}


.links{
    margin-top:7%;
    padding-top:5%;
    margin-bottom:7%;
}

</style>