<template>
    <div>
    <NavigationBar /> 
      <h1>Client complaints</h1>
      <table class="table">
        <thead>
            <tr class="table-success">
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Surname</th>
            <th scope="col">Email</th>
            <th scope="col">Renting item</th>
            <th scope="col">Address</th>
            <th scope="col">Complaint</th>
            <th scope="col">Answer</th>


            </tr>
        </thead>
        <tbody>
            <tr v-for="(complaint,index) in complaints" :key="index">
            <th scope="row"></th>
            <td>{{complaint.client.name}}</td>
            <td>{{complaint.client.surname}}</td>
            <td>{{complaint.client.email}}</td>
            <td>{{complaint.rentingItem.name}}</td>
            <td>{{complaint.rentingItem.address}}</td>
            <td>{{complaint.description}}</td>
            <td><button class="dugme" @Click="answer(complaint, explanation[index], index)" id="yes">Send</button></td>
            <td>Answer <input v-model='explanation[index]'></td>
            </tr>
        </tbody>
    </table>

    <h1>Answered client complaints</h1>
      <table class="table">
        <thead>
            <tr class="table-success">
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Surname</th>
            <th scope="col">Email</th>
            <th scope="col">Renting item</th>
            <th scope="col">Address</th>
            <th scope="col">Answer</th>


            </tr>
        </thead>
        <tbody>
            <tr v-for="(answeredComplaint,index) in answeredComplaint" :key="index">
            <th scope="row"></th>
            <td>{{answeredComplaint.client.name}}</td>
            <td>{{answeredComplaint.client.surname}}</td>
            <td>{{answeredComplaint.client.email}}</td>
            <td>{{answeredComplaint.rentingItem.name}}</td>
            <td>{{answeredComplaint.rentingItem.address}}</td>
            <td>{{answeredComplaint.description}}</td>
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
    name : 'ClientComplaints',
    components: {
        NavigationBar
    },
    data() {
       return {
        complaints:[],
        showErrorMessage : false,
        explanation :[],
        answeredComplaint : [],
        unansweredComplaints : [],
       }
    },
    methods: {
        answer(complaint, explanation, index){

        this.reply = {}
        this.reply.complaintId = complaint.id;
        this.reply.clientId = complaint.client.id;
        this.reply.rentingItemId = complaint.rentingItem.id;
        this.reply.description = explanation;
        
        axios.post('http://localhost:8080/complaint/addReply', this.reply)
        .then(
            alert("Answer sent!")
        )

        this.complaints.splice(index,1);
        this.explanation[index] = null;

       },  
       findAll(){
        axios.get('http://localhost:8080/complaint/getAll')
            .then(response => {
                this.complaints = response.data;
                for(let i = 0; i < this.complaints.length; i++){
                    if(this.complaints[i].answered == false){
                        this.unansweredComplaints.push(this.complaints[i]);
                    }
                }  
                this.complaints = this.unansweredComplaints;
            })
        },
        findReplies(){
            axios.get('http://localhost:8080/complaint/getAllReplies')
            .then(response => { 
                this.answeredComplaint = response.data;
                console.log(this.answeredComplaint)
            })
        }    
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
                this.findAll();
                this.findReplies();
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
    width: 100%;
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