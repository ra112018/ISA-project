const LandingPage = { template: '<landing-page></landing-page>' }
const RegistrationChoice = { template: '<registration-choice></registration-choice>' }
const RegistrationClient = { template: '<registration-client></registration-client>' }

const router = new VueRouter({
	  mode: 'hash',
	  routes: [	  
	    { path: '/', component: LandingPage},
	    { path: '/registration-choice', component: RegistrationChoice},
	    { path: '/registration-client', component: RegistrationClient}
	  ]
});

var app = new Vue({
	router,
	el: '#landing-page'
});