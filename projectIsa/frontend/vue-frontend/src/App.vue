<template>
  <div> 
    <router-view />
  </div>
</template>

<script> 

export default {
  name: 'App',
  components: {
    
  },
  data() {
    return {
    }
  },
  methods:{
    
  
    },
  mounted(){ 
    localStorage.removeItem('role');
    localStorage.removeItem('token');
    },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: black;
}

#nav a {
  font-weight: bold;
  padding-left: 20px;
  padding-right: 20px;
}
 
</style>
