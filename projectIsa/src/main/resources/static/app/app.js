const LandingPage = { template: '<landing-page></landing-page>' }

const router = new VueRouter({
	  mode: 'hash',
	  routes: [	  
	    { path: '/', component: LandingPage}
	  ]
});

var app = new Vue({
	router,
	el: '#landing-page'
});