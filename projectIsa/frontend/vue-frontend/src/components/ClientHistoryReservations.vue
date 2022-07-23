<template>
  <div>     
    <NavigationBar />
    <div>
        <h1 class="display-2 text-center mt-3 mb-4">Upcoming reservations</h1>

        <div class="reservation-inline" v-for="upcomingReservation in upcomingReservations" v-bind:key="upcomingReservation.id">
            <div class="reservationView">
            <h2>{{upcomingReservation.rentingItem.name}}</h2>
            <p>{{upcomingReservation.rentingItem.address}}</p>
            <p>{{upcomingReservation.rentingItem.description}}</p>
            <p>{{upcomingReservation.startTime}} - {{upcomingReservation.endTime}}</p>
            <p>{{upcomingReservation.price}} din</p>
            <button type="button" v-on:click="cancelReservation(upcomingReservation.id)" v-if="checkDates(upcomingReservation.startTime) == true" class="btn btn-primary btn-margin">Cancel</button>
            </div>
        </div>
    </div>
    <h1 class="display-2 text-center mt-3 mb-4">Reservation history</h1>

    <div>
        <div class="search-inline">
            <label class="sort-text"><b>Type</b></label>           
            <select v-model="typeCriteria" class="sort-inline">
                    <option value="cottage">Cottage</option>
                    <option value="boat">Boat</option>
                    <option value="fishingAdventure">Fishing adventure</option>
                    <option value="all">All</option>
            </select> 
            <button v-on:click="typeShow" class="btn btn-primary btn-width">Show</button> 

            <label class="sort-text"><b>Criteria</b></label>            
            <select v-model="sortCriteria" class="sort-inline">
                    <option value="startTime">Date</option>
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

        <div v-if="allMode === true">
            <div class="reservation-inline" v-for="reservation in reservations" v-bind:key="reservation.id">
                <div class="reservationView">
                <h2>{{reservation.rentingItem.name}}</h2>
                <p>{{reservation.rentingItem.address}}</p>
                <p>{{reservation.rentingItem.description}}</p>
                <p>{{reservation.startTime}} - {{reservation.endTime}}</p>
                <p>{{reservation.price}} din</p>
                <button v-on:click="turnComplaintMode(reservation.rentingItem.id)" v-if="complaintMode === false || !hiddenTodos.includes(reservation.rentingItem.id)" class="btn btn-primary btn-margin">Add complaint</button>
                <div v-if="complaintMode === true && hiddenTodos.includes(reservation.rentingItem.id)" class="reservation-inline textarea-width">
                    <h4 for="text" class="form-label">Your complaint</h4>
                    <textarea type="text" class="form-control textarea-height" id="complaint" placeholder="Enter your complaint" name="complaint" v-model="complaint" required></textarea><br>
                    <button v-on:click="addComplaint(reservation.rentingItem.id)" v-if="complaintMode === true" class="btn btn-primary btn-margin">Send complaint</button><br>
                    <button v-on:click="backComplaint" v-if="complaintMode === true" class="btn btn-primary btn-margin">Cancel</button>
                </div>
                </div>
            </div>
        </div>

        <div v-if="cottagesMode === true">
            <div class="reservation-inline" v-for="cottage in cottages" v-bind:key="cottage.id">
                <div class="reservationView">
                <h2>{{cottage.rentingItem.name}}</h2>
                <p>{{cottage.rentingItem.address}}</p>
                <p>{{cottage.rentingItem.description}}</p>
                <p>{{cottage.startTime}} - {{cottage.endTime}}</p>
                <p>{{cottage.price}} din</p>
                <button v-on:click="turnComplaintMode(cottage.rentingItem.id)" v-if="complaintMode === false || !hiddenTodos.includes(cottage.rentingItem.id)" class="btn btn-primary btn-margin">Add complaint</button>
                <div v-if="complaintMode === true && hiddenTodos.includes(cottage.rentingItem.id)" class="reservation-inline textarea-width">
                    <h4 for="text" class="form-label">Your complaint</h4>
                    <textarea type="text" class="form-control textarea-height" id="complaint" placeholder="Enter your complaint" name="complaint" v-model="complaint" required></textarea><br>
                    <button v-on:click="addComplaint(cottage.rentingItem.id)" v-if="complaintMode === true" class="btn btn-primary btn-margin">Send complaint</button><br>
                    <button v-on:click="backComplaint" v-if="complaintMode === true" class="btn btn-primary btn-margin">Cancel</button>
                </div>
                </div>
            </div>
        </div>

        <div v-if="boatsMode === true">
            <div class="reservation-inline" v-for="boat in boats" v-bind:key="boat.id">
                <div class="reservationView">
                <h2>{{boat.rentingItem.name}}</h2>
                <p>{{boat.rentingItem.address}}</p>
                <p>{{boat.rentingItem.description}}</p>
                <p>{{boat.startTime}} - {{boat.endTime}}</p>
                <p>{{boat.price}} din</p>
                <button v-on:click="turnComplaintMode(boat.rentingItem.id)" v-if="complaintMode === false || !hiddenTodos.includes(boat.rentingItem.id)" class="btn btn-primary btn-margin">Add complaint</button>
                <div v-if="complaintMode === true && hiddenTodos.includes(boat.rentingItem.id)" class="reservation-inline textarea-width">
                    <h4 for="text" class="form-label">Your complaint</h4>
                    <textarea type="text" class="form-control textarea-height" id="complaint" placeholder="Enter your complaint" name="complaint" v-model="complaint" required></textarea><br>
                    <button v-on:click="addComplaint(boat.rentingItem.id)" v-if="complaintMode === true" class="btn btn-primary btn-margin">Send complaint</button><br>
                    <button v-on:click="backComplaint" v-if="complaintMode === true" class="btn btn-primary btn-margin">Cancel</button>
                </div>
                </div>
            </div>
        </div>

        <div v-if="instructorsMode === true">
            <div class="reservation-inline" v-for="instructor in instructors" v-bind:key="instructor.id">
                <div class="reservationView">
                <h2>{{instructor.rentingItem.name}}</h2>
                <p>{{instructor.rentingItem.address}}</p>
                <p>{{instructor.rentingItem.description}}</p>
                <p>{{instructor.startTime}} - {{instructor.endTime}}</p>
                <p>{{instructor.price}} din</p>
                <button v-on:click="turnComplaintMode(instructor.rentingItem.id)" v-if="complaintMode === false || !hiddenTodos.includes(instructor.rentingItem.id)" class="btn btn-primary btn-margin">Add complaint</button>
                <div v-if="complaintMode === true && hiddenTodos.includes(instructor.rentingItem.id)" class="reservation-inline textarea-width">
                    <h4 for="text" class="form-label">Your complaint</h4>
                    <textarea type="text" class="form-control textarea-height" id="complaint" placeholder="Enter your complaint" name="complaint" v-model="complaint" required></textarea><br>
                    <button v-on:click="addComplaint(instructor.rentingItem.id)" v-if="complaintMode === true" class="btn btn-primary btn-margin">Send complaint</button><br>
                    <button v-on:click="backComplaint" v-if="complaintMode === true" class="btn btn-primary btn-margin">Cancel</button>
                </div>
                </div>
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
        searchInput : null,
        token : null,
        decodedToken : null,
        cottages : [],
        boats : [],
        instructors : [],
        allMode : true,
        cottagesMode : false,
        boatsMode : false,
        instructorsMode : false,
        upcomingReservations : [],
        complaintMode : false,
        hiddenTodos : []
      }
    },
    methods: {
    sortThis: function(){
			if(this.sortCriteria != "startTime" && this.sortCriteria != "price" && this.sortCriteria != "duration")
			{
				alert("You must enter criteria for sorting!");
			}
			else if(this.sortType != "descending" && this.sortType != "ascending")
			{
				alert("You must enter sort direction!");
			}
			else
			{
				if(this.sortCriteria == "startTime")
				{
                    if(this.allMode == true){
                        this.reservations.sort(this.compareDate)
                    }else if(this.cottagesMode == true){
                        this.cottages.sort(this.compareDate)
                    }else if(this.boatsMode == true){
                        this.boats.sort(this.compareDate)
                    }else{
                        this.instructors.sort(this.compareDate)
                    }
					
				}
				else if(this.sortCriteria == "price")
				{
                    if(this.allMode == true){
                        this.reservations.sort(this.comparePrice);
                    }else if(this.cottagesMode == true){
                        this.cottages.sort(this.comparePrice)
                    }else if(this.boatsMode == true){
                        this.boats.sort(this.comparePrice)
                    }else{
                        this.instructors.sort(this.comparePrice)
                    }					
				}
				else
				{
                    if(this.allMode == true){
                        this.reservations.sort(this.compareDuration);
                    }else if(this.cottagesMode == true){
                        this.cottages.sort(this.compareDuration)
                    }else if(this.boatsMode == true){
                        this.boats.sort(this.compareDuration)
                    }else{
                        this.instructors.sort(this.compareDuration)
                    }				
				}
										
			}
		},
	  compareDate: function(o,t){
			let first, second;
			if(this.sortCriteria == "startTime")
			{
				first = new Date(o.startTime);
				second = new Date(t.startTime);
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
        compareDuration: function(o,t){
			let first, second;
			if(this.sortCriteria == "duration")
			{
				first = new Date(o.endTime) - new Date(o.startTime);
				second = new Date(t.endTime) - new Date(t.startTime);
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
        typeShow(){          
			if(this.typeCriteria != "cottage" && this.typeCriteria != "boat" && this.typeCriteria != "fishingAdventure" && this.typeCriteria != "all")
			{
				alert("You must enter criteria for type!");
			}
			else if(this.typeCriteria == "cottage")
			{            
                this.cottagesMode = true;
                this.allMode = false;  
                this.boatsMode = false;
                this.instructorsMode = false; 
			}
			else if(this.typeCriteria == "boat")
			{
				this.boatsMode = true;	
                this.cottagesMode = false;
                this.allMode = false;  
                this.instructorsMode = false;				
			}
            else if(this.typeCriteria == "fishingAdventure")
			{
                this.instructorsMode = true;
                this.boatsMode = false;	
                this.cottagesMode = false;
                this.allMode = false;  										
			}
            else 
            {
                this.allMode = true;
                this.instructorsMode = false;
                this.boatsMode = false;	
                this.cottagesMode = false;                
            }
		},
        getAll(){
            axios.get('http://localhost:8080/reservations/getPreviousClientReservations/' + this.decodedToken.id)
            .then(response => {
                this.reservations = response.data;
                for(let i = 0; i < this.reservations.length; i++){
                    var dateStart = new Date(this.reservations[i].startTime);
                    var dateEnd = new Date(this.reservations[i].endTime);
                    this.reservations[i].startTime = dateStart.toString().substring(4, 16);
                    this.reservations[i].endTime = dateEnd.toString().substring(4, 16);

                    if(this.reservations[i].rentingItem.type == "Cottage"){
                        this.cottages.push(this.reservations[i]);
                    }else if(this.reservations[i].rentingItem.type == "Boat"){
                        this.boats.push(this.reservations[i]);
                    }else {
                        this.instructors.push(this.reservations[i]);
                    }

                }

            })
        },
        getUpcoming(){
            axios.get('http://localhost:8080/reservations/getFutureClientReservations/' + this.decodedToken.id)
            .then(response => {
                this.upcomingReservations = response.data;
                for(let i = 0; i < this.upcomingReservations.length; i++){
                    var dateStart = new Date(this.upcomingReservations[i].startTime);
                    var dateEnd = new Date(this.upcomingReservations[i].endTime);
                    this.upcomingReservations[i].startTime = dateStart.toString().substring(4, 16);
                    this.upcomingReservations[i].endTime = dateEnd.toString().substring(4, 16);
                }

            })
        },
        checkDates(date) {
            const today = new Date();
            today.setDate(today.getDate() + 3)
            if(new Date(date) > today){
                return true;
            }else {
                return false;
            }
        },
        cancelReservation(reservationId){
            axios.post('http://localhost:8080/reservations/cancelReservation/' + reservationId)
            .then(
                alert("Successfully canceled!")
            )
            this.getUpcoming()
        },
        turnComplaintMode(id){
            this.hiddenTodos.push(id)
            this.complaintMode = true;
        },
        addComplaint(rentingItemId){
            var data = {
                    clientId: this.decodedToken.id,
                    rentingItemId: rentingItemId,
                    description: this.complaint
                }

            axios.post('http://localhost:8080/complaint/add', data)
            .then(
                alert("Your complaint has been sent to admin!")
            )

            this.complaintMode = false;
            this.complaint = null;
            this.hiddenTodos.splice(0);
        },
        backComplaint() {
            this.complaintMode = false;
            this.complaint = null;
            this.hiddenTodos.splice(0);
        }
    
    },
    mounted(){ 
      this.token = localStorage.getItem('token');
        if (this.token === null || this.token === undefined) {
            alert("Nije dozvoljen pristup");
            this.$router.push({path: '/'});
        }else {
        this.decodedToken = VueJwtDecode.decode(this.token);
          if(this.decodedToken.user_role === 'Administrator'){
              alert("Nije dozvoljen pristup");
              this.$router.push({path: '/'});
          }else if(this.decodedToken.user_role === 'FishingInstructor'){
              alert("Nije dozvoljen pristup");
              this.$router.push({path: '/'});
          }else {
            this.getAll()
            this.getUpcoming()
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
  height: fit-content;
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

.btn-width {
    width: 12%;
    margin-right: 2%;
}

.textarea-width {
    width: 300px;
    height: 320px;
}

.textarea-height {
    height: 150px;
}

.btn-margin {
    margin-bottom: 7%;
}

</style>