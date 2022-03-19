Vue.component("registration-choice", {
	name: "registration-choice",	    
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
	 
    <h1 class="text-center mt-5 mb-3">Registration</h1>
    <h2 class="text-center mt-3 mb-5">Please choose user role</h2>
    
    
    <div class="text-center">
    	<div class="mt-5 mb-4"><a href="#/registration-client" class="btn btn-info btn-lg" role="button">Register me as client</a></div>
    	<div><a href="#" class="btn btn-info btn-lg" role="button">Register me as cottage owner, boat owner or instructor</a></div>
    </div>
    
    

     	
    </div>   
    `
    ,
});