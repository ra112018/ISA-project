<template>
    <div>
    <NavigationBar /> 
      <h1>Client delete account requests</h1>
      <table class="table">
        <thead>
            <tr class="table-success">
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Surname</th>
            <th scope="col">Email</th>
            <th scope="col">Explanation</th>
            <th scope="col">Approve</th>


            </tr>
        </thead>
        <tbody>
            <tr v-for="(request,index) in requests" :key="index">
            <th scope="row"></th>
            <td>{{request.client.name}}</td>
            <td>{{request.client.surname}}</td>
            <td>{{request.client.email}}</td>
            <td>{{request.description}}</td>
            <td><button class="dugme" @Click="approve(request, explanation[index], index)" id="yes">Yes</button><button @Click="deny(request, explanation[index], index)" class="dugme" id="no">No</button></td>
            <td>because of <input v-model='explanation[index]'></td>
            </tr>
        </tbody>
    </table>
    </div>
</template>

<script>
import NavigationBar from "../components/NavigationBar.vue";
import VueJwtDecode from 'vue-jwt-decode';
import axios from 'axios';

export default {
    name : 'ClientDeleteAccountRequests',
    components: {
        NavigationBar
    },
    data() {
       return {
        requests:[],
        showErrorMessage : false,
        explanation :[]
       }
    },
    methods: {
        approve(request, explanation, index){

        this.reply = {}
        this.reply.clientDeleteAccountRequestId = request.id;
        this.reply.description = explanation;
        this.reply.clientId = request.client.id;
        
        axios.post('http://localhost:8080/clientDeleteAccountRequests/approve', this.reply)
        .then(
            alert("Approved!")
        )

        this.requests.splice(index,1);
        this.explanation[index] = null;

       },
        deny(request, explanation, index){

        this.reply = {}
        this.reply.clientDeleteAccountRequestId = request.id;
        this.reply.description = explanation;
        this.reply.clientId = request.client.id;
        
        axios.post('http://localhost:8080/clientDeleteAccountRequests/deny', this.reply)
        .then(
            alert("Denied!")
        )

        this.requests.splice(index,1);
        this.explanation[index] = null;

       },

    },
    mounted() {
        const token = localStorage.getItem('token');
        if (token === null || token === undefined) {
            alert("Nije dozvoljen pristup");
            this.$router.push({path: '/'});
        }else {
            const decodedToken = VueJwtDecode.decode(token);
            if(decodedToken.user_role === 'Client'){
                alert("Nije dozvoljen pristup");
                this.$router.push({path: '/'});
            }else if(decodedToken.user_role === 'FishingInstructor'){
                alert("Nije dozvoljen pristup");
                this.$router.push({path: '/'});
            }else {
                axios.get('http://localhost:8080/clientDeleteAccountRequests/getAll')
                .then(response => {
                    this.requests = response.data;   
                })
            } 
        } 
    }

}
</script>

<style>
table{
    max-width:90%;
}
.dugme{
    width: 40%;
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