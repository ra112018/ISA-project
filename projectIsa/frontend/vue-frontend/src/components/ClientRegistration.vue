<template>
    <div>
    <h1>Registration as client</h1> 
    <div class="d-flex flex-column justify-content-center align-items-center">
        <form>
            <div class="mb-3 mt-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control text-center" id="name" placeholder="Enter your name" name="name">
            </div>
            <div class="mb-3 mt-3">
                <label for="surname" class="form-label">Surname:</label>
                <input type="text" class="form-control text-center" id="surname" placeholder="Enter your surname" name="surname">
            </div>
            <div class="mb-3 mt-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" class="form-control text-center" id="email" placeholder="Enter your email" name="email">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" class="form-control text-center" id="password" placeholder="Enter your password" name="password">
            </div>
            <div class="mb-3">
                <label for="repeatPassword" class="form-label">Repeat password:</label>
                <input type="password" class="form-control text-center" id="repeatPassword" placeholder="Repeat your password" name="repeatPassword">
            </div>
            <div class="mb-3 mt-3">
                <label for="phoneNumber" class="form-label">Phone number:</label>
                <input type="text" class="form-control text-center" id="phoneNumber" placeholder="Enter your phone number" name="phoneNumber">
            </div>
            <div class="mb-3 mt-3">
                <label for="state" class="form-label">State:</label>
                <input type="text" class="form-control text-center" id="state" placeholder="Enter state" name="state">
            </div>
            <div class="mb-3 mt-3">
                <label for="city" class="form-label">City:</label>
                <input type="text" class="form-control text-center" id="city" placeholder="Enter city" name="city">
            </div>
            <div class="mb-3 mt-3">
                <label for="street" class="form-label">Street:</label>
                <input type="text" class="form-control text-center" id="street" placeholder="Enter street" name="street">
            </div>
            <div class="mb-3 mt-3">
                <label for="houseNumber" class="form-label">House number:</label>
                <input type="text" class="form-control text-center" id="houseNumber" placeholder="Enter house number" name="houseNumber">
            </div>
            <div class="mb-3 mt-3">
                <label for="postcode" class="form-label">Postcode:</label>
                <input type="text" class="form-control text-center" id="postcode" placeholder="Enter postcode" name="postcode">
            </div>
            
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    </div>   
</template>

<script>
import ClientRegistrationService from '../services/ClientRegistrationService'

export default {
    name : 'ClientRegistration',
    data() {
       return {
           nesto : null
       }
    },
    methods: {
        getRegist(){
            ClientRegistrationService.getRegist().then((response) => {
                this.nesto = response.data;
            });
        }
    },
    created() {
        this.getRegist()
    }

}
</script>

<style>
h1 {
    padding-top: 3%;
    padding-bottom: 3%;
}

</style>