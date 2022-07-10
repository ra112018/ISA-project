import axios from 'axios'

class OwnerInstructorRegistrationService {
    
    Register(owner){
        console.log(owner)
        axios.post('http://localhost:8080/registration-owner-instructor/registration', owner).then((response) => {
            alert("Uspešna registracija!");
            return response.data;
            }).catch(error => {
            console.log(error.response);
            alert(error.response.data)
            if(error.response.status == 403){
                alert("Your email is already used, please register with different email or try to log in");
            }
        }) ; 
    }
}

export default new OwnerInstructorRegistrationService()