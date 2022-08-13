<template>
  <div>     
    <NavigationBar />
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

  <br>
  <!-- Cottages -->
  <div>
    <button type="button" v-on:click="showAllCottages" class="btn btn-primary btn-change">View all cottages</button>
    <div v-if="cottagesMode === true">
      <div class="search-inline">
        <input type="search" v-model="searchInput">
        <span><button type="button" v-on:click="searchCottages" class="btn btn-primary">Search</button></span>

    	  <label class="sort-text"><b>Criteria</b></label>
    	
        <select v-model="sortCriteria" class="sort-inline">
                <option value="name">Name</option>
                <option value="address">Address</option>
        </select>    	
        <label class="sort-text"><b>Direction</b></label>
        <select v-model="sortType" class="sort-inline">
                <option value="ascending">Ascending</option>
                <option value="descending">Descending</option>
        </select>
		    <button v-on:click="sortThis" class="btn btn-primary">Sort</button>    
      </div><br>
      <div class="cottage-inline" v-for="cottage in cottages" v-bind:key="cottage.name" :name="cottage.name" :address="cottage.address" :description="cottage.description">
        <div class="cottageView">
          <h2>{{cottage.name}}</h2>
          <p>{{cottage.address}}</p>
          <p>{{cottage.description}}</p>
        </div>
      </div>
    </div>
  </div> 

  <br>
  <br>
  <!-- Boats -->
  <div>
    <button type="button" v-on:click="showAllBoats" class="btn btn-primary btn-change">View all boats</button>
    <div v-if="boatsMode === true">
      <div class="search-inline">
        <input type="search" v-model="searchInputBoat">
        <span><button type="button" v-on:click="searchBoats" class="btn btn-primary">Search</button></span>

    	  <label class="sort-text"><b>Criteria</b></label>
    	
        <select v-model="sortCriteriaBoat" class="sort-inline">
                <option value="name">Name</option>
                <option value="address">Address</option>
        </select>    	
        <label class="sort-text"><b>Direction</b></label>
        <select v-model="sortTypeBoat" class="sort-inline">
                <option value="ascending">Ascending</option>
                <option value="descending">Descending</option>
        </select>
		    <button v-on:click="sortThisBoat" class="btn btn-primary">Sort</button>    
      </div><br>
      <div class="cottage-inline" v-for="boat in boats" v-bind:key="boat.name" :name="boat.name" :address="boat.address" :description="boat.description">
        <div class="cottageView">
          <h2>{{boat.name}}</h2>
          <p>{{boat.address}}</p>
          <p>{{boat.description}}</p>
        </div>
      </div>
    </div>
  </div>

  <br>
  <br>
  <!-- FishingInstructorAdventure -->
  <div>
    <button type="button" v-on:click="showAllAdventure" class="btn btn-primary btn-change">View all fishing instructor adventure</button>
    <div v-if="adventureMode === true">
      <div class="search-inline">
        <input type="search" v-model="searchInputAdventure">
        <span><button type="button" v-on:click="searchAdventure" class="btn btn-primary">Search</button></span>

    	  <label class="sort-text"><b>Criteria</b></label>
    	
        <select v-model="sortCriteriaAdventure" class="sort-inline">
                <option value="name">Name</option>
                <option value="address">Address</option>
        </select>    	
        <label class="sort-text"><b>Direction</b></label>
        <select v-model="sortTypeAdventure" class="sort-inline">
                <option value="ascending">Ascending</option>
                <option value="descending">Descending</option>
        </select>
		    <button v-on:click="sortThisAdventure" class="btn btn-primary">Sort</button>    
      </div><br>
      <div class="cottage-inline" v-for="adventure in adventures" v-bind:key="adventure.name" :name="adventure.name" :address="adventure.address" :description="adventure.description">
        <div class="adventureView">
          <h2>{{adventure.name}}</h2>
          <p>{{adventure.address}}</p>
          <p>{{adventure.description}}</p>
          <p>Biografija instruktora: {{adventure.instructorBiography}}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import NavigationBar from "../components/NavigationBar.vue";
import VueJwtDecode from 'vue-jwt-decode';
import axios from 'axios';

export default {
    name : 'ClientHomePage',
    components: {
    NavigationBar
    },
    data() {
      return {
        cottagesMode : false,
        cottages : [],
        searchInput : null,
        boatsMode : false,
        boats : [],
        searchInputBoat : null,
        adventureMode : false,
        adventures : [],
        searchInputAdventure : null,
      }
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
            }else if(decodedToken.user_role === 'BoatOwner'){
              alert("Nije dozvoljen pristup");
              this.$router.push({path: '/'});
            }else if(decodedToken.user_role === 'CottageOwner'){
              alert("Nije dozvoljen pristup");
              this.$router.push({path: '/'});
            }
          }  
        } 
      },
      showAllCottages() {
      this.cottagesMode = true;

      axios.get('http://localhost:8080/cottage/getAll')
      .then(response => {
        this.cottages = response.data;
        //prosecna ocena fali
      })
    },
    searchCottages() {
      axios.get('http://localhost:8080/cottage/search/' + this.searchInput)
      .then(response => {
        this.cottages = response.data;
        //prosecna ocena fali
      })
    },
    //fali sortiranje po oceni
    sortThis: function(){
			if(this.sortCriteria != "name" && this.sortCriteria != "address")
			{
				alert("You must enter criteria for sorting!");
			}
			else if(this.sortType != "descending" && this.sortType != "ascending")
			{
				alert("You must enter sort direction!");
			}
			else
			{
				if(this.sortCriteria == "address")
				{
					this.cottages.sort(this.compareAddress)
				}
				else if(this.sortCriteria == "name")
				{
					this.cottages.sort(this.compareName);
				}
				else
				{
					//this.cottages.sort(this.compareRatings);
				}
										
			}
		},
	  compareName: function(o,t){
			let first, second;
			if(this.sortCriteria == "name")
			{
				first = o.name;
				second = t.name;
			}
			if(first < second)
			{
				if(this.sortType == 'ascending')
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else if(first > second)
			{
				if(this.sortType == 'ascending')
				{
					return 1;
				}
				else
				{
					return -1;
				}
			}
			else
			{
				return 0;
			}

		},
    compareAddress: function(o,t){
			let first, second;
			if(this.sortCriteria == "address")
			{
				first = o.address;
				second = t.address;
			}
			if(first < second)
			{
				if(this.sortType == 'ascending')
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else if(first > second)
			{
				if(this.sortType == 'ascending')
				{
					return 1;
				}
				else
				{
					return -1;
				}
			}
			else
			{
				return 0;
			}

		},
    showAllBoats() {
      this.boatsMode = true;

      axios.get('http://localhost:8080/boat/getAll')
      .then(response => {
        this.boats = response.data;
        //prosecna ocena fali i jos neki podaci
      })
    },
    searchBoats() {
      axios.get('http://localhost:8080/boat/search/' + this.searchInputBoat)
      .then(response => {
        this.boats = response.data;
        //prosecna ocena fali i jos neki podaci
      })
    },
    sortThisBoat: function(){
			if(this.sortCriteriaBoat != "name" && this.sortCriteriaBoat != "address")
			{
				alert("You must enter criteria for sorting!");
			}
			else if(this.sortTypeBoat != "descending" && this.sortTypeBoat != "ascending")
			{
				alert("You must enter sort direction!");
			}
			else
			{
				if(this.sortCriteriaBoat == "address")
				{
					this.boats.sort(this.compareAddressBoat)
				}
				else if(this.sortCriteriaBoat == "name")
				{
					this.boats.sort(this.compareNameBoat);
				}
				else
				{
					//this.boats.sort(this.compareRatingsBoat);
				}
										
			}
		},
	  compareNameBoat: function(o,t){
			let first, second;
			if(this.sortCriteriaBoat == "name")
			{
				first = o.name;
				second = t.name;
			}
			if(first < second)
			{
				if(this.sortTypeBoat == 'ascending')
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else if(first > second)
			{
				if(this.sortTypeBoat == 'ascending')
				{
					return 1;
				}
				else
				{
					return -1;
				}
			}
			else
			{
				return 0;
			}

		},
    compareAddressBoat: function(o,t){
			let first, second;
			if(this.sortCriteriaBoat == "address")
			{
				first = o.address;
				second = t.address;
			}
			if(first < second)
			{
				if(this.sortTypeBoat == 'ascending')
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else if(first > second)
			{
				if(this.sortTypeBoat == 'ascending')
				{
					return 1;
				}
				else
				{
					return -1;
				}
			}
			else
			{
				return 0;
			}

		},
    showAllAdventure() {
      this.adventureMode = true;

      axios.get('http://localhost:8080/fishingInstructorAdventure/getAll')
      .then(response => {
        this.adventures = response.data;
        //prosecna ocena fali
      })
    },
    searchAdventure() {
      axios.get('http://localhost:8080/fishingInstructorAdventure/search/' + this.searchInputAdventure)
      .then(response => {
        this.adventures = response.data;
        //prosecna ocena fali i jos neki podaci
      })
    },
    sortThisAdventure: function(){
			if(this.sortCriteriaAdventure != "name" && this.sortCriteriaAdventure != "address")
			{
				alert("You must enter criteria for sorting!");
			}
			else if(this.sortTypeAdventure != "descending" && this.sortTypeAdventure != "ascending")
			{
				alert("You must enter sort direction!");
			}
			else
			{
				if(this.sortCriteriaAdventure == "address")
				{
					this.adventures.sort(this.compareAddressAdventure)
				}
				else if(this.sortCriteriaAdventure == "name")
				{
					this.adventures.sort(this.compareNameAdventure);
				}
				else
				{
					//this.adventures.sort(this.compareRatingsBoat);
				}
										
			}
		},
	  compareNameAdventure: function(o,t){
			let first, second;
			if(this.sortCriteriaAdventure == "name")
			{
				first = o.name;
				second = t.name;
			}
			if(first < second)
			{
				if(this.sortTypeAdventure == 'ascending')
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else if(first > second)
			{
				if(this.sortTypeAdventure == 'ascending')
				{
					return 1;
				}
				else
				{
					return -1;
				}
			}
			else
			{
				return 0;
			}

		},
    compareAddressAdventure: function(o,t){
			let first, second;
			if(this.sortCriteriaAdventure == "address")
			{
				first = o.address;
				second = t.address;
			}
			if(first < second)
			{
				if(this.sortTypeAdventure == 'ascending')
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else if(first > second)
			{
				if(this.sortTypeAdventure == 'ascending')
				{
					return 1;
				}
				else
				{
					return -1;
				}
			}
			else
			{
				return 0;
			}

		},
       
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

.search-inline {
  display: flex;
  margin-left: 4%;
  height: 40px;
}

span {
    margin: 0 20px;
}

.sort-inline {
  display: flex;
  margin-right: 2%;
  height: 40px;
  width: 200px;
}

.sort-text {
  text-align: center;
  margin-top: 0.5%;
  margin-right: 1%;
}

.adventureView {
  width: 360px;
  height: 300px;
  border: solid 1px #555;
  background-color:beige;
  box-shadow: 10px -10px 5px  rgba(0,0,0,0.6);
  border-radius:25px;    
  text-align: center;
}

</style>