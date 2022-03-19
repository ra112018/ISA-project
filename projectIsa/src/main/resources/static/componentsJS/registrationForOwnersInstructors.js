Vue.component("registration-owners-instructors", {
	name: "registration-owners-instructors",	    
    methods: {      

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
	 
    <h1 class="text-center mt-5 mb-5">Registration as user</h1>
    
    
   	<form>
    <div class="text-center mt-5 mb-3">
      <label for="name">Name</label>
      <input type="text" class="form-control w-25 mx-auto text-center" id="name" placeholder="Enter your name" required>
    </div>
    <div class="text-center mb-3">
      <label for="surname">Surname</label>
      <input type="text" class="form-control w-25 mx-auto text-center" id="surname" placeholder="Enter your surname" required>
    </div>
    <div class="text-center mb-3">
      <label for="email">Email</label>
      <input type="text" class="form-control w-25 mx-auto text-center" id="email" placeholder="Enter your email" required>
    </div>
    <div class="text-center mb-3">
      <label for="password">Password</label>
      <input type="password" class="form-control w-25 mx-auto text-center" id="password" placeholder="Enter your password" required>
    </div>
    <div class="text-center mb-3">
      <label for="repeatPassword">Repeat password</label>
      <input type="password" class="form-control w-25 mx-auto text-center" id="repeatPassword" placeholder="Repeat your password" required>
    </div>
    <div class="text-center mb-3">
      <label for="phoneNumber">Phone number</label>
      <input type="text" class="form-control w-25 mx-auto text-center" id="phoneNumber" placeholder="Enter your phone number" required>
    </div>
    <div class="text-center mb-3">
      <label for="state">State</label>
      <input type="text" class="form-control w-25 mx-auto text-center" id="state" placeholder="Enter your state" required>
    </div>
    <div class="text-center mb-3">
      <label for="city">City</label>
      <input type="text" class="form-control w-25 mx-auto text-center" id="city" placeholder="Enter your city" required>
    </div>
    <div class="text-center mb-3">
      <label for="street">Street</label>
      <input type="text" class="form-control w-25 mx-auto text-center" id="street" placeholder="Enter your street" required>
    </div>
    <div class="text-center mb-3">
      <label for="houseNumber">House number</label>
      <input type="text" class="form-control w-25 mx-auto text-center" id="houseNumber" placeholder="Enter your house number" required>
    </div>
    <div class="text-center mb-3">
      <label for="postcode">Postcode</label>
      <input type="text" class="form-control w-25 mx-auto text-center" id="postcode" placeholder="Enter your postcode" required>
    </div>
	<div class="text-center mb-3">
      <label for="role">Role</label>
      <select type="text" class="form-control w-25 mx-auto text-center" id="role" placeholder="Enter your user role" required>
		<option value="cottageOwner">Cottage owner</option>
		<option value="boatOwner">Boat owner</option>
		<option value="instructor">Fishing instructor</option>
	  </select>
    </div>
	<div class="text-center mb-3">
      <label for="explanation">Why you registered?</label>
      <textarea rows="4" class="form-control w-25 mx-auto text-center" id="explanation" placeholder="Enter your reasons for choosing our site" />
    </div>
  	<div class="col text-center mb-5 mt-5">
  	<button class="btn btn-primary" type="submit">Submit form</button>
  	</div>
</form>
    
     	
    </div>   
    `
    ,
});