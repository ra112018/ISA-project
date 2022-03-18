Vue.component("landing-page", {
	name: "landing-page",	    
    methods: {      

    },
	template: `
    <div>
     
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-end sticky-top">
		<ul class="navbar-nav">
			<li class="nav-item active">
		      <a class="nav-link" href="#/registration-choice">Registration</a>
		    </li>
		    <li class="nav-item active">
		      <a class="nav-link" href="#">Login</a>
		    </li>
		</ul>
	</nav>
	 
    <h1 class="display-2 text-center mt-3 mb-4">Welcome to our booking app!</h1>
     	
	<div id="demo" class="carousel slide" data-ride="carousel">

  	<!-- Indicators -->
  	<ul class="carousel-indicators">
    	<li data-target="#demo" data-slide-to="0" class="active"></li>
    	<li data-target="#demo" data-slide-to="1"></li>
    	<li data-target="#demo" data-slide-to="2"></li>
  	</ul>
  
  	<!-- The slideshow -->
  	<div class="carousel-inner">
    	<div class="carousel-item active">
      		<img src="../images/cabin.jpg" alt="Cabin" width=auto>
    	</div>
    	<div class="carousel-item">
      		<img src="../images/fishing.jpg" alt="Fishing" width=auto>
    	</div>
    	<div class="carousel-item">
      	<img src="../images/fishingBoat.jpg" alt="Fishing Boat" width=auto>
    	</div>
  	</div>
  
  	<!-- Left and right controls -->
  		<a class="carousel-control-prev" href="#demo" data-slide="prev">
    		<span class="carousel-control-prev-icon"></span>
  		</a>
  		<a class="carousel-control-next" href="#demo" data-slide="next">
    		<span class="carousel-control-next-icon"></span>
  		</a>
	</div>
     	
    </div>   
    `
    ,
});