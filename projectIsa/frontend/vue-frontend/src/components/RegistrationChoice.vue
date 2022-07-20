<template>
  <div>    
    <NavigationBar /> 
    <h1 class="text-center mt-5 mb-3">Registration</h1>
    <h2 class="text-center mt-3 mb-5">Please choose user role</h2>

    <div class="container mt-3">
        <a href="/registration-client" class="btn btn-success fs-4">Register me as client</a>
    </div>
    <div class="container mt-3">
        <a href="/registration-owner-instructor" class="btn btn-success fs-4">Register me as cottage owner, boat owner or instructor</a>
    </div>  
  </div>   
</template>

<script>

import NavigationBar from "../components/NavigationBar.vue"; 

export default {
  name: 'RegistrationChoice',
  components: {
    NavigationBar
  },
  data() {
    return {
    }
  },
  methods:{
    
  
    },
  mounted(){ 
    },
}
</script>

<style>

</style>