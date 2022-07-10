import axios from 'axios'

const registration_url = 'http://localhost:8080/registration-owner-instructor';

class AdminService {

     async getRegistrationRequests(){
        return await axios.get(registration_url + '/requests');
    }


    approveRegistrationRequest(body){
        return axios.put(registration_url + '/acceptRegistrationRequest', body);
    }
}

export default new AdminService()