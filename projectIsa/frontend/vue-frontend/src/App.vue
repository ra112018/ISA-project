<template>
  <div> 
    <div id="nav">
      <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <div class="navbar-nav me-auto">
                <router-link to="/" class="nav-item nav-link">Home</router-link>
            </div>
            <div class="navbar-nav ms-auto">
                <router-link to="/registration-choice" class="nav-item nav-link">Registration</router-link>
                <router-link to="/Login" class="nav-item nav-link">Login</router-link>
            </div>
      </nav>
    </div>
    <router-view />
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {

  }
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
