Vue.component("registration-client", {
	name: "registration-client",
	data: function () {
	    return {
	      name: null,
	      surname: null,
	      email: null,
	      password:null,
	      repeatPassword: null,
	      phoneNumbe: null,
	      state: null,
	      city: null,
	      street: null,
	      houseNumber: null,
	      postcode: null,
	      showErrorMessage: false
	  	};
  	},	    
    methods: { 
    formSubmit: function (e) {
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
      			alert("Poslato!")
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
	template: `
    <div>
     
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
    	<ul class="navbar-nav mr-auto">
		    <li class="nav-item active">
		      <a class="nav-link" href="#/">Home</a>
		    </li>
		</ul>
		<ul class="navbar-nav ml-auto">
		    <li class="nav-item active">
		      <a class="nav-link" href="#">Login</a>
		    </li>
		</ul>
	</nav>
	 
    <h1 class="text-center mt-5 mb-5">Registration as client</h1>
    
    
   	<form @submit="formSubmit">
	    <div class="text-center mt-5 mb-3">
	      <label for="name">Name</label>
	      <input type="text" class="form-control w-25 mx-auto text-center" id="name" placeholder="Enter your name" v-model="name" required>
	    </div>
	    <div class="text-center mb-3">
	      <label for="surname">Surname</label>
	      <input type="text" class="form-control w-25 mx-auto text-center" id="surname" placeholder="Enter your surname" v-model="surname" required>
	    </div>
	    <div class="text-center mb-3">
	      <label for="email">Email</label>
	      <input type="text" class="form-control w-25 mx-auto text-center" id="email" placeholder="Enter your email" v-model="email" required>
	    </div>
	    <div class="text-center mb-3">
	      <label for="password">Password</label>
	      <input type="password" class="form-control w-25 mx-auto text-center" id="password" placeholder="Enter your password" v-model="password" required>
	    </div>
	    <div class="text-center mb-3">
	      <label for="repeatPassword">Repeat password</label>
	      <input type="password" class="form-control w-25 mx-auto text-center" id="repeatPassword" placeholder="Repeat your password" v-model="repeatPassword" required>
	    </div>
	    <div class="text-center mb-3">
	      <label for="phoneNumber">Phone number</label>
	      <input type="text" class="form-control w-25 mx-auto text-center" id="phoneNumber" placeholder="Enter your phone number" v-model="phoneNumber" required>
	    </div>
	    <div class="text-center mb-3">
	      <label for="state">State</label>
	      <input type="text" class="form-control w-25 mx-auto text-center" id="state" placeholder="Enter your state" v-model="state" required>
	    </div>
	    <div class="text-center mb-3">
	      <label for="city">City</label>
	      <input type="text" class="form-control w-25 mx-auto text-center" id="city" placeholder="Enter your city" v-model="city" required>
	    </div>
	    <div class="text-center mb-3">
	      <label for="street">Street</label>
	      <input type="text" class="form-control w-25 mx-auto text-center" id="street" placeholder="Enter your street" v-model="street" required>
	    </div>
	    <div class="text-center mb-3">
	      <label for="houseNumber">House number</label>
	      <input type="text" class="form-control w-25 mx-auto text-center" id="houseNumber" placeholder="Enter your house number" v-model="houseNumber" required>
	    </div>
	    <div class="text-center mb-3">
	      <label for="postcode">Postcode</label>
	      <input type="text" class="form-control w-25 mx-auto text-center" id="postcode" placeholder="Enter your postcode" v-model="postcode" required>
	    </div>
	
	  	<div class="col text-center mb-5 mt-5">
	  	<button class="btn btn-primary" type="submit">Submit form</button>
	  	</div>
	</form>

    
     	
    </div>   
    `
    ,
});