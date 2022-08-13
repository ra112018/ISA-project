<template>
    <div>     
        <NavigationBar/>
    <h1 class="display-2 text-center mt-3 mb-4">Welcome to your home page!</h1>
      <!-- Carousel -->
      <div id="demo" class="carousel slide" data-bs-ride="carousel">

        <!-- Indicators/dots -->
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
          <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
          <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
        </div>
    
        <!-- The slideshow/carousel -->
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="../images/cottage.jpg" alt="Cottage" class="d-block" style="width:100%">
          </div>
          <div class="carousel-item">
            <img src="../images/fishing.jpg" alt="Fishing" class="d-block" style="width:100%">
          </div>
          <div class="carousel-item">
            <img src="../images/fishingBoat.jpg" alt="Fishing Boat" class="d-block" style="width:100%">
          </div>
        </div>
    
        <!-- Left and right controls/icons -->
        <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
          <span class="carousel-control-prev-icon"></span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
          <span class="carousel-control-next-icon"></span>
        </button>
      </div>
  </div>   
</template>

<script>
import NavigationBar from "../components/NavigationBar.vue";
import VueJwtDecode from 'vue-jwt-decode';

export default {
    name : 'BoatOwnerHomePage',
    components: {
        NavigationBar
   },
    data() {

    },
    methods: {
       getToken() {
        const token = localStorage.getItem('token');
        if (token === null || token === undefined) {
            alert("Nije dozvoljen pristup");
            this.$router.push({path: '/'});
        }else {
        const decodedToken = VueJwtDecode.decode(token);
          if(decodedToken.user_role === 'Administrator'){
              alert("Nije dozvoljen pristup");
              this.$router.push({path: '/'});
          }else {
            if(decodedToken.user_role === 'FishingInstructor'){
              alert("Nije dozvoljen pristup");
              this.$router.push({path: '/'});
            }
          }  
        } 
      }
    },
    mounted(){ 
      this.getToken();
    },
    created() {
        
    }

}
</script>

<style>

.carousel-item {
  height: 500px;
}

img {
 width: auto; 
 max-height: 100%; 
}

.carousel {
  margin-bottom: 5%;
}

</style>