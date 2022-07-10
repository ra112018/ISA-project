<template> <div> 
    <div id="nav">
      <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <div class="navbar-nav me-auto">
                <router-link to="/" class="nav-item nav-link">Home</router-link>
            </div>
            <div class="navbar-nav ms-auto">
                <router-link to="/" class="nav-item nav-link">Logout</router-link>
            </div>
      </nav>
    </div>
    <router-view />
  </div></template>

<script>

    export default{
        components:{
        }
    }

</script>

<style>
    body{
        margin: 0px;
        padding: 0px;
    }
</style>

