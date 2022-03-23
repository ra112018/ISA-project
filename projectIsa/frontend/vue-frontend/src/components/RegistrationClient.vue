<template>
    <h1>Registration as client</h1> 
</template>

<script>
import ClientRegistrationService from '../services/ClientRegistrationService'

export default {
    name : 'RegistrationClient',
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
