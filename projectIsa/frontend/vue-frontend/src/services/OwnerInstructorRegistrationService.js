import axios from 'axios'

class OwnerInstructorRegistrationService {
    
    Register(owner){
        console.log("servis")
        axios.get('http://localhost:8080/registration-owner-instructor/hello');
        console.log(owner)
        axios.post('http://localhost:8080/registration-owner-instructor/registration', owner).then((response) => {
            alert("Uspešna registracija!");
            return response.data;
        }); 
    }
}

export default new OwnerInstructorRegistrationService()