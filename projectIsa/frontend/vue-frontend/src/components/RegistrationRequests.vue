<template>
      <h1>Requests</h1>
      <table class="table">
        <thead>
            <tr class="table-success">
            <th scope="col">#</th>
            <th scope="col">Email</th>
            <th scope="col">Name</th>
            <th scope="col">Surname</th>
            <th scope="col">Role</th>
            <th scope="col">Explanation</th>
            <th scope="col">Approve</th>


            </tr>
        </thead>
        <tbody>
            <tr v-for="request in requests" :key="request">
            <th scope="row"></th>
            <td>{{request.email}}</td>
            <td>{{request.name}}</td>
            <td>{{request.surname}}</td>
            <td>{{request.role}}</td>
            <td>{{request.explanation}}</td>
            <td><button class="dugme" id="yes">Yes</button><button class="dugme" id="no">No</button></td>
            </tr>
        </tbody>
    </table>
</template>

<script>
//import router from '@/router'
import AdminService from '../services/AdminService'

export default {
    name : 'RegistrationRequests',
    data() {
       return {
        requests:[],
        showErrorMessage : false,
       
       }
    },
    methods: {
       
    },
    created() {
        this.requests = AdminService.getRegistrationRequests().then((res=>{
            this.requests = res.data;
            console.log(this.requests);
        }));
    }

}
</script>

<style>
table{
    max-width:70%;
}
.dugme{
    width: 35%;
    margin: 3%;
    height: 50%;
    border-radius:10%;
    border: 1px solid white;
    color: white;
}
#yes{
    background-color: lightgreen;
}
#no{
    background-color: palevioletred;
}

</style>