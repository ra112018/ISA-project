import axios from 'axios'

class AdminService {
     async getRegistrationRequests(){
        return await axios.get('http://localhost:8080/registration-owner-instructor/requests');
    }
}

export default new AdminService()