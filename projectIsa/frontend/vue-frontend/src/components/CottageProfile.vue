<template>
    <NavigationBar />
    <div align="center">
    <h1>Cottage profile</h1>
     
    <div class="d-flex justify-content-around">
        <form @submit="formSubmit">
            <div class="w-50 m-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control text-center" id="name" placeholder="Enter your name" name="name" v-model="name" required>
            </div>
            <div class="w-50 m-3">
                <label for="address" class="form-label">Address:</label>
                <input type="text" class="form-control text-center" id="address" placeholder="Enter address" address="address" v-model="address" required>
            </div>
            <div class="w-50 m-3">
                <label for="description" class="form-label">Description:</label>
                <input type="text" class="form-control text-center" id="description" placeholder="Enter description" description="description" v-model="description" required>
            </div>
            <div class="w-50 m-3">
                <label for="images" class="form-label">Images:</label>
                <input type="text" class="form-control text-center" id="images" placeholder="Enter images" images="images" v-model="images" required>
            </div>
            <div class="w-50 m-3">
                <label for="room" class="form-label">Room:</label>
                <input type="text" class="form-control text-center" id="room" placeholder="Enter room" room="room" v-model="room" required>
            </div>
            <div class="w-50 m-3">
                <label for="beds" class="form-label">Beds:</label>
                <input type="text" class="form-control text-center" id="beds" placeholder="Enter beds" beds="beds" v-model="beds" required>
            </div>
            <div class="w-50 m-3">
                <label for="availableDates" class="form-label">Available dates:</label>
                <input type="text" class="form-control text-center" id="availableDates" placeholder="Enter availableDates" availableDates="availableDates" v-model="availableDates" required>
            </div>
            <div class="w-50 m-3">
                <label for="rules" class="form-label">Rules:</label>
                <input type="text" class="form-control text-center" id="rules" placeholder="Enter rules" rules="rules" v-model="rules" required>
            </div>
            <div class="w-50 m-3">
                <label for="price" class="form-label">Price:</label>
                <input type="text" class="form-control text-center" id="price" placeholder="Enter price" price="price" v-model="price" required>
            </div>
            <button type="submit" class="btn btn-primary">Edit</button>
        </form>
        </div>
    </div>
</template>

<script>
import NavigationBar from "../components/NavigationBar.vue";

export default {
    name : 'CottageProfile',
    components: {
        NavigationBar
    },
    data() {
       return {
            name : null,
	        address: null,
            description: null,
            images: null,
            room: null,
            beds: null,
            availableDates: null,
            rules: null,
            price: null
       }
    },
    methods: {
    },
    mounted(){              
    },
    created() {
        
    }

}
</script>

<style>
h1 {
    padding-top: 3%;
    padding-bottom: 3%;
}

form {
    margin-bottom: 5%;
}

.end {
    padding-bottom: 5%;
}

button {
    width: 200px;
}

.p-5 {
  padding: 300px;
}

.btn-change {
    margin-bottom: 5%;
    margin-top: -3%;
}

.description {
    height: 200px;
    width: 300px;
}

</style>