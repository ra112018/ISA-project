<template>
    <div align="center">
    <NavigationBar />
    <h1>Registration as client</h1>
     
    <div class="d-flex flex-column justify-content-center align-items-center">
        <form @submit="formSubmit">
            <div class="w-50 m-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control text-center" id="name" placeholder="Enter your name" name="name" v-model="name" required>
            </div>
            <div class="w-50 m-3">
                <label for="surname" class="form-label">Surname:</label>
                <input type="text" class="form-control text-center" id="surname" placeholder="Enter your surname" name="surname" v-model="surname" required>
            </div>
            <div class="w-50 m-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" class="form-control text-center" id="email" placeholder="Enter your email" name="email" v-model="email" required>
            </div>
            <div class="w-50 m-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" class="form-control text-center" id="password" placeholder="Enter your password" name="password" v-model="password" required>
            </div>
            <div class="w-50 m-3">
                <label for="repeatPassword" class="form-label">Repeat password:</label>
                <input type="password" class="form-control text-center" id="repeatPassword" placeholder="Repeat your password" name="repeatPassword" v-model="repeatPassword" required>
            </div>
            <div class="w-50 m-3">
                <label for="phoneNumber" class="form-label">Phone number:</label>
                <input type="text" class="form-control text-center" id="phoneNumber" placeholder="Enter your phone number" name="phoneNumber" v-model="phoneNumber" required>
            </div>
            <div class="w-50 m-3">
                <label for="state" class="form-label">State:</label>
                <input type="text" class="form-control text-center" id="state" placeholder="Enter state" name="state" v-model="state" required>
            </div>
            <div class="w-50 m-3">
                <label for="city" class="form-label">City:</label>
                <input type="text" class="form-control text-center" id="city" placeholder="Enter city" name="city" v-model="city" required>
            </div>
            <div class="w-50 m-3">
                <label for="street" class="form-label">Street:</label>
                <input type="text" class="form-control text-center" id="street" placeholder="Enter street" name="street" v-model="street" required>
            </div>
            <div class="w-50 m-3">
                <label for="houseNumber" class="form-label">House number:</label>
                <input type="text" class="form-control text-center" id="houseNumber" placeholder="Enter house number" name="houseNumber" v-model="houseNumber" required>
            </div>
            <div class="w-50 m-3 end">
                <label for="postcode" class="form-label">Postcode:</label>
                <input type="text" class="form-control text-center" id="postcode" placeholder="Enter postcode" name="postcode" v-model="postcode" required>
            </div>
            
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    </div>   
</template>

<script>
import axios from 'axios';
import NavigationBar from "../components/NavigationBar.vue"; 

export default {
    name : 'ClientRegistration',
    components: {
        NavigationBar
    },
    data() {
       return {
            name : null,
	        surname : null,
	        email : null,
	        password :null,
	        repeatPassword : null,
            phoneNumber : null,
            state : null,
            city : null,
            street : null,
            houseNumber : null,
            postcode : null,
            showErrorMessage : false
       }
    },
    methods: {
        formSubmit(e) {
        e.preventDefault();
        this.errors = null;
			if(!this.Word(this.name.trim())){
			    alert("Name must contain a capital letter and letters only!")
			    e.preventDefault();
			}else if(!this.Word(this.surname.trim())){
			    alert("Surname must contain a capital letter and letters only!")
			    e.preventDefault();
			}else if(this.repeatPassword.trim() != this.password.trim()){
                this.showErrorMessage = true;
				alert("Password and repeated password must be the same!")
				e.preventDefault();
      		}else if(!this.Email(this.email.trim())){
                this.showErrorMessage = true;
				alert("Email is invalid!")
				e.preventDefault();
      		}else if(!this.Number(this.phoneNumber.trim())){
                this.showErrorMessage = true;
				alert("Phone number can only contain digits!")
				e.preventDefault();
      		}else if(!this.Word(this.state.trim())){
                this.showErrorMessage = true;
				alert("State must contain a capital letter and letters only!")
				e.preventDefault();
      		}else if(!this.Word(this.city.trim())){
                this.showErrorMessage = true;
				alert("City must contain a capital letter and letters only!")
				e.preventDefault();
      		}else if(!this.Word(this.street.trim())){
                this.showErrorMessage = true;
				alert("Street must contain a capital letter and letters only!")
				e.preventDefault();
      		}else if(!this.Number(this.houseNumber.trim())){
                this.showErrorMessage = true;
				alert("House number can only contain digits!")
				e.preventDefault();
      		}else if(!this.Number(this.postcode.trim())){
                this.showErrorMessage = true;
				alert("Postcode can only contain digits!")
				e.preventDefault();
      		}else {
      			this.client = {}
      			this.address = {}
      			this.client.name = this.name;
      			this.client.surname = this.surname;
      			this.client.email = this.email;
      			this.client.password = this.password;
      			this.client.phoneNumber = this.phoneNumber;
      			this.address.state = this.state;
      			this.address.city = this.city;
      			this.address.street = this.street;
      			this.address.houseNumber = this.houseNumber;
      			this.address.postcode = this.postcode;
      			this.client.address = this.address;
      			
      			alert("Please check your email to activate account!")
                axios.post('http://localhost:8080/client/registration', this.client)
    			
      		}    
        },
        Word: function(value){
            return /^[A-Z][a-zA-Z]+(?:[\s-][a-zA-Z]+)*$/.test(value);
        }, 
	    Email: function(value){
            return /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(value);
        },
        Number: function (value) {
            return /^[0-9]+$/.test(value);
        },
    },
    created() {
        
    }

}
</script>

<style>
h1 {
    padding-top: 3%;
    padding-bottom: 3%;
}

form {
    margin-bottom: 5%;
}

.end {
    padding-bottom: 10%;
}

button {
    width: 150px;
}

</style>