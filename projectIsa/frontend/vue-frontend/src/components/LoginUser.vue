<template>
    <div>
        <h2>Login</h2>  
        <div class="d-flex flex-column justify-content-center align-items-center">   
            <form @submit="formSubmit"> 
                <div class="mb-3 mt-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="email" class="form-control text-center" id="email" placeholder="Enter your email" name="email" v-model="email" required>
                </div>   
                <div class="mb-3">
                    <label for="password" class="form-label">Password:</label>
                    <input type="password" class="form-control text-center" id="password" placeholder="Enter your password" name="password" v-model="password" required>
                </div> 

                <button type="submit" class="btn btn-primary mt-3">Login</button>
              
            </form>
        </div>
    </div>   
</template>

<script>
import axios from 'axios'

export default {
    name : 'LoginUser',
    data() {
       return {
	        email : null,
	        password : null
       }
    },
    methods: {
        formSubmit(e) {
        e.preventDefault();
        this.errors = null;			
      		if(!this.Email(this.email.trim())){
                this.showErrorMessage = true;
				alert("Email is invalid!")
				e.preventDefault();
      		}else {     			
                var data = {
                    username: this.email,
                    password: this.password
                }
                
                axios.post('http://localhost:8080/auth/login', data)
                .then(response => {
                    if(response.data.user.role == "Client"){
                        this.$router.push({path: '/client-home-page'});
                    }
                })	
                .catch(error => {
                switch (error.response.status) {
                    case 401:
                        alert("Bad credentials or you haven't activated your account yet!")  
                        break;
                    default:
                        console.log('some other error'); 
                        break;
                    }
                });
 	
      		}    
        },
	    Email: function(value){
            return /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(value);
        },
    },
    mounted(){
        const token = this.$route.params.token;
        if (token) {
            axios.put('http://localhost:8080/client/activateAccount', token)
            .then(
                    this.$router.push({path: '/login'})
                )
        }
    },
    created() {
        
    }

}
</script>

<style>
h2 {
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