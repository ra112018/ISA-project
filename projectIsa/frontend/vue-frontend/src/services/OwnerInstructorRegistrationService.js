import axios from 'axios'

class OwnerInstructorRegistrationService {
    Register(owner){
        return axios.post('http://localhost:8080/registration-owner-instructor/registration', owner);
    }
}

export default new OwnerInstructorRegistrationService()