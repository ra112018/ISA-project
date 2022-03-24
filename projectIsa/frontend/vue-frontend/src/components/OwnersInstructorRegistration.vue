<template>
    <div>
    <h1>Registration as owner or instructor</h1>
     
    <div class="d-flex flex-row m-3 justify-content-left align-items-left">
        <form @submit="formSubmit" >
            <div class="m-3" style="width: 45%; display:inline-block">
                <input type="text" class="form-control text-center " id="name" placeholder="Name" name="name" v-model="name" required>
            </div>           
            <div class="m-3" style="width: 45%; display:inline-block">
                <input type="text" class="form-control text-center" id="surname" placeholder="Surname" name="surname" v-model="surname" required>
            </div>
            <div class="m-3" style="width: 45%; display:inline-block">
                <input type="email" class="form-control text-center" id="email" placeholder="Email" name="email" v-model="email" required>
            </div>
            <div class="m-3" style="width: 45%; display:inline-block">
                <input type="text" class="form-control text-center" id="phoneNumber" placeholder="Phone number" name="phoneNumber" v-model="phoneNumber" required>
            </div>
            <div class="m-3" style="width: 45%; display:inline-block">
                <input type="password" class="form-control text-center" id="password" placeholder="Password" name="password" v-model="password" required>
            </div>
            <div class="m-3" style="width: 45%; display:inline-block">
                <input type="password" class="form-control text-center" id="repeatPassword" placeholder="Repeat your password" name="repeatPassword" v-model="repeatPassword" required>
            </div>
            <div class="m-3" style="width: 45%; display:inline-block">
                <input type="text" class="form-control text-center" id="state" placeholder="State" name="state" v-model="state" required>
            </div>
            <div class="m-3" style="width: 13%; display:inline-block">
                <input type="text" class="form-control text-center" id="postcode" placeholder="Postcode" name="postcode" v-model="postcode" required>
            </div>
            <div class="m-3" style="width: 29%; display:inline-block">
                <input type="text" class="form-control text-center" id="city" placeholder="City" name="city" v-model="city" required>
            </div>
            <div class="m-3" style="width: 45%; display:inline-block">
                <input type="text" class="form-control text-center" id="street" placeholder="Street" name="street" v-model="street" required>
            </div>
            <div class="m-3" style="width: 45%; display:inline-block">
                <input type="text" class="form-control text-center" id="houseNumber" placeholder="House number" name="houseNumber" v-model="houseNumber" required>
            </div>
            
            <div class="m-3" style="width: 95%; display:inline-block">
                <label for="role" class="form-label">Role:</label>
                <select type="text" class="form-control mx-auto text-center" id="role" placeholder="Enter your user role" required>
                    <option value="cottageOwner">Cottage owner</option>
                    <option value="boatOwner">Boat owner</option>
                    <option value="instructor">Fishing instructor</option>
                </select>           
            </div>
            <div class="m-3 end">
                <textarea type="text" rows="3" class="form-control text-center" id="explanation" placeholder="Enter reasons for choosing our site" name="explanation" v-model="explanation" required/>
            </div>
            <button type="submit" class="btn btn-outline-primary bg-green">Submit</button>
        </form>
    </div>
    </div>   
</template>

<script>
import OwnerInstructorRegistrationService from '../services/OwnerInstructorRegistrationService'

export default {
    name : 'OwnerInstructorRegistration',
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
            role: null,
            explanation: null,
            showErrorMessage : false,
            nesto : null
       }
    },
    methods: {
        getRegist(){
            OwnerInstructorRegistrationService.Register().then((response) => {
                console.log("evo")
                this.nesto = response.data;
                console.log(this.nesto);
            });
        },
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
      			
      			alert("Salje se!")
                this.getRegist()
    			
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
        console.log("h")
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
    width: 60%;
}

.end {
    padding-bottom: 5%;
}

button {
    width: 150px;
    box-shadow: 2px 3px 0px rgba(28, 135, 167, 0.459);
}


</style>