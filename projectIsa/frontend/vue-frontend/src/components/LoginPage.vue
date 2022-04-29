<template>
    <div>
    <h1>Login</h1>
     
    <div class="d-flex ">
        <form @submit="formSubmit">
            <div class="mb-3 mt-3">
                <label for="name" class="form-label">Username:</label>
                <input type="text" class="form-control text-center" id="username" placeholder="Enter your username" name="username" v-model="username" required>
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
import router from '@/router'
import LoginService from '../services/LoginService'

export default {
    name : 'LoginPage',
    data() {
       return {
        user: null,
        password: null,
        username: null,

        showErrorMessage : false,
       }
    },
    methods: {
        getRegist(){
            this.client = {}
            
      		this.client.username = this.username;
      		this.client.password = this.password;
            this.nesto = LoginService.Login(this.client);
            if(localStorage.getItem('statusLogin')=="200"){
                console.log(localStorage.getItem('ROLE'));
                if(localStorage.getItem('ROLE') == 'Administrator') {
                    console.log("nestooo")
                    router.push('/admin')
                }
            }
        },
        formSubmit(e) {
        e.preventDefault();
        this.errors = null;
      	alert("Salje se!")
        this.getRegist()  
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