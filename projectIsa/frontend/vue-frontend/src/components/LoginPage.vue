<template>
    <div>
    <h1>Login</h1>
     
    <div class="d-flex ">
        <form @submit="formSubmit">
            <div class="mb-3 mt-3">
                <label for="name" class="form-label">Username:</label>
                <input type="text" class="form-control text-center" id="username" placeholder="Enter your Username" name="name" v-model="username" required>
            </div>
             <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" class="form-control text-center" id="password" placeholder="Enter your password" name="password" v-model="password" required>
            </div>
            <button type="submit" class="btn btn-primary">Log In</button>
        </form><img src="../images/login2.jpg" class="image">
    </div>
    <div>
    </div>
    </div>   
</template>

<script>
import ClientRegistrationService from '../services/ClientRegistrationService'

export default {
    name : 'LoginPage',
    data() {
       return {
            name : null,
	        password :null,
            showErrorMessage : false,
       }
    },
    methods: {
        getRegist(){
            ClientRegistrationService.getRegist().then((response) => {
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
      		}else {
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
        
    }

}
</script>

<style>
h1 {
    padding-top: 3%;
    padding-bottom: 3%;
}

form {
    margin-left: 3%;
    padding: 6% 5% 6% 2%;
    width: 50%;
    display: inline;
}

.end {
    padding-bottom: 10%;
}

button {
    width: 150px;
}

.image{
    width: 45%;
    height: 45%;
    display: inline;
    border-radius: 10px;
}

</style>