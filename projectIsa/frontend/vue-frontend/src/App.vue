<template>
  <div> 
  <RegistrationClient />
  </div>

</template>

<script>
import RegistrationClient from './components/RegistrationClient.vue'

export default {
  name: 'App',
  components: {
    RegistrationClient
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
