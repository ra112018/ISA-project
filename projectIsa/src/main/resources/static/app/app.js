const LandingPage = { template: '<landing-page></landing-page>' }
const RegistrationChoice = { template: '<registration-choice></registration-choice>' }

const router = new VueRouter({
	  mode: 'hash',
	  routes: [	  
	    { path: '/', component: LandingPage},
	    { path: '/registration-choice', component: RegistrationChoice}
	  ]
});

var app = new Vue({
	router,
	el: '#landing-page'
});