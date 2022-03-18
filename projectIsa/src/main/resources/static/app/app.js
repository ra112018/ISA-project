const LandingPage = { template: '<landing-page></landing-page>' }
const RegistrationChoice = { template: '<registration-choice></registration-choice>' }
const RegistrationUser = { template: '<registration-user></registration-user>' }

const router = new VueRouter({
	  mode: 'hash',
	  routes: [	  
	    { path: '/', component: LandingPage},
	    { path: '/registration-choice', component: RegistrationChoice},
	    { path: '/registration-user', component: RegistrationUser}
	  ]
});

var app = new Vue({
	router,
	el: '#landing-page'
});