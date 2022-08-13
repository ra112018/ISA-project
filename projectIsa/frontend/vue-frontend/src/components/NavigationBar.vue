<template> 
    <div> 
        <div id="nav">
            <nav class="navbar navbar-expand-sm bg-light navbar-light">
                    <div class="navbar-nav me-auto">
                        <router-link v-if="!isLoggedIn" to="/" class="nav-item nav-link">Home</router-link>
                        <router-link v-if="isLoggedIn ==='Client'" to="/client-home-page" class="nav-item nav-link">Home</router-link>
                        <router-link v-if="isLoggedIn ==='Administrator'" to="/admin-home-page" class="nav-item nav-link">Home</router-link>
                        <router-link v-if="isLoggedIn ==='FishingInstructor'" to="/instructor-home-page" class="nav-item nav-link">Home</router-link>
                        <router-link v-if="isLoggedIn ==='BoatOwner'" to="/boatOwner-home-page" class="nav-item nav-link">Home</router-link>
                        <router-link v-if="isLoggedIn ==='CottageOwner'" to="/cottageOwner-home-page" class="nav-item nav-link">Home</router-link>
                    </div>
                    <div class="navbar-nav ms-auto">
                        <router-link v-if="isLoggedIn ==='Client'" to="/client-reservations-history" class="nav-item nav-link">Reservations</router-link>
                        <router-link v-if="isLoggedIn ==='Client'" to="/client-profile" class="nav-item nav-link">Profile</router-link>
                        <router-link v-if="isLoggedIn ==='BoatOwner'" to="/boatOwner-profile" class="nav-item nav-link">Boat owner profile</router-link>
                        <router-link v-if="isLoggedIn ==='BoatOwner'" to="/boat-profile" class="nav-item nav-link">Boat owner profile</router-link>
                        <router-link v-if="isLoggedIn ==='CottageOwner'" to="/cottageOwner-profile" class="nav-item nav-link">Cottage owner profile</router-link>  
                        <router-link v-if="isLoggedIn ==='CottageOwner'" to="/cottage-profile" class="nav-item nav-link">Cottage owner profile</router-link>                      
                        <router-link v-if="!isLoggedIn" to="/registration-choice" class="nav-item nav-link">Registration</router-link>
                        <router-link v-if="!isLoggedIn" to="/login" class="nav-item nav-link">Login</router-link>
                        <router-link v-if="isLoggedIn ==='Client' || isLoggedIn ==='Administrator' || isLoggedIn ==='FishingInstructor' || isLoggedIn ==='BoatOwner' || isLoggedIn ==='CottageOwner'"  v-on:click="logout" to="/" class="nav-item nav-link">Logout</router-link>
                    </div>
            </nav>
        </div>
        <router-view />
    </div>
</template>

<script>

export default {
    name: 'NavigationBar',
    components: {
    },
    data() {
        return {
            role : null,
        }
    },
    methods:{
        logout() {
            localStorage.removeItem('role');
        }
     
    },
    mounted(){ 
        this.role = localStorage.getItem('role');
    },
    computed: {
        isLoggedIn() {
            return this.role;
        }
    }
}

</script>

<style>
body{
    margin: 0px;
    padding: 0px;
}

</style>

