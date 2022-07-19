<template>
  <div>   
    <NavigationBar />  
    <h1 class="display-2 text-center mt-3 mb-4">Welcome to our booking app!</h1>

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

  <!-- Cottages -->
  <div>
    <button type="button" v-on:click="showAllCottages" v-if="cottagesMode === false" class="btn btn-primary btn-change">Show all cottages</button>
    <div v-if="cottagesMode === true">
      <div class="cottage-inline" v-for="cottage in cottages" v-bind:key="cottage.name" :name="cottage.name" :address="cottage.address" :description="cottage.description">
        <div class="cottageView">
          <h2>{{cottage.name}}</h2>
          <p>{{cottage.address}}</p>
          <p>{{cottage.description}}</p>
        </div>
      </div>
    </div>
  </div> 
</template>

<script>

import NavigationBar from "../components/NavigationBar.vue"; 
import axios from 'axios';

export default {
  name: 'LandingPage',
  components: {
    NavigationBar
  },
  data() {
    return {
      cottagesMode : false,
      cottages : [],
    }
  },
  methods:{
    showAllCottages() {
      this.cottagesMode = true;

      axios.get('http://localhost:8080/cottage/getAll')
      .then(response => {
        this.cottages = response.data;
        console.log(this.cottages);
        //prosecna ocena fali
      })
    },
  
  },
  mounted(){ 
  },
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

.cottageView {
  width: 360px;
  height: 200px;
  border: solid 1px #555;
  background-color:beige;
  box-shadow: 10px -10px 5px  rgba(0,0,0,0.6);
  border-radius:25px;    
  text-align: center;
}

.cottage-inline {
  display: inline-block;
  margin: 2%;
  vertical-align: middle;
}

p {
  font-size: large;
}

</style>