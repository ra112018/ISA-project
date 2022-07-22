<template>
  <div>     
    <NavigationBar />
    <h1 class="display-2 text-center mt-3 mb-4">Reservation history</h1>

    <div>
        <div class="search-inline">
            <input type="search" v-model="searchInput">
            <span><button type="button" v-on:click="searchReservations" class="btn btn-primary">Search</button></span>

            <label class="sort-text"><b>Criteria</b></label>
            
            <select v-model="sortCriteria" class="sort-inline">
                    <option value="date">Date</option>
                    <option value="price">Price</option>
                    <option value="duration">Duration</option>
            </select>    	
            <label class="sort-text"><b>Direction</b></label>
            <select v-model="sortType" class="sort-inline">
                    <option value="ascending">Ascending</option>
                    <option value="descending">Descending</option>
            </select>
                <button v-on:click="sortThis" class="btn btn-primary">Sort</button>    
        </div><br>
        <div class="reservation-inline" v-for="reservation in reservations" v-bind:key="reservation.id">
            <div class="reservationView">
            <h2>{{reservation.rentingItem.name}}</h2>
            <p>{{reservation.rentingItem.address}}</p>
            <p>{{reservation.rentingItem.description}}</p>
            <p>{{reservation.startTime}} - {{reservation.endTime}}</p>
            <p>{{reservation.price}} din</p>
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
    name : 'ClientHistoryReservations',
    components: {
    NavigationBar
    },
    data() {
      return {
        reservations : [],
        searchInput : null
      }
    },
    methods: {
    searchReservations() {
      //axios.get('http://localhost:8080/cottage/search/' + this.searchInput)
      //.then(response => {
      //  this.cottages = response.data;
        
      //})
    },
    sortThis: function(){
			if(this.sortCriteria != "date" && this.sortCriteria != "price" && this.sortCriteria != "duration")
			{
				alert("You must enter criteria for sorting!");
			}
			else if(this.sortType != "descending" && this.sortType != "ascending")
			{
				alert("You must enter sort direction!");
			}
			else
			{
				if(this.sortCriteria == "date")
				{
					this.reservations.sort(this.compareDate)
				}
				else if(this.sortCriteria == "price")
				{
					this.reservations.sort(this.comparePrice);
				}
				else
				{
					this.reservations.sort(this.compareDuration);
				}
										
			}
		},
	  compareDate: function(o,t){
			let first, second;
			if(this.sortCriteria == "date")
			{
				first = o.date;
				second = t.date;
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
    comparePrice: function(o,t){
			let first, second;
			if(this.sortCriteria == "price")
			{
				first = o.price;
				second = t.price;
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
    
    },
    mounted(){ 
      const token = localStorage.getItem('token');
        if (token === null || token === undefined) {
            alert("Nije dozvoljen pristup");
            this.$router.push({path: '/'});
        }else {
        const decodedToken = VueJwtDecode.decode(token);
          if(decodedToken.user_role === 'Administrator'){
              alert("Nije dozvoljen pristup");
              this.$router.push({path: '/'});
          }else if(decodedToken.user_role === 'FishingInstructor'){
              alert("Nije dozvoljen pristup");
              this.$router.push({path: '/'});
          }else {
            axios.get('http://localhost:8080/reservations/getPreviousClientReservations/' + decodedToken.id)
            .then(response => {
                console.log(response);
                this.reservations = response.data;
                for(let i = 0; i < this.reservations.length; i++){
                    var dateStart = new Date(this.reservations[i].startTime);
                    var dateEnd = new Date(this.reservations[i].endTime);
                    this.reservations[i].startTime = dateStart.toString().substring(4, 16);
                    this.reservations[i].endTime = dateEnd.toString().substring(4, 16);
                }

            })
          }
          
        }

    },
    created() {
        
    }

}
</script>

<style>

.reservationView {
  width: 360px;
  height: 300px;
  border: solid 1px #555;
  background-color:beige;
  box-shadow: 10px -10px 5px  rgba(0,0,0,0.6);
  border-radius:25px;    
  text-align: center;
}

.reservation-inline {
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

</style>