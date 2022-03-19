const LandingPage = { template: '<landing-page></landing-page>' }
const RegistrationChoice = { template: '<registration-choice></registration-choice>' }
const RegistrationOwnersInstructors = { template: '<registration-owners-instructors></registration-owners-instructors>' }


const router = new VueRouter({
	  mode: 'hash',
	  routes: [	  
	    { path: '/', component: LandingPage},
	    { path: '/registration-choice', component: RegistrationChoice},
		{ path: '/registration-owners-instructors', component: RegistrationOwnersInstructors}

	  ]
});

var app = new Vue({
	router,
	el: '#landing-page'
});