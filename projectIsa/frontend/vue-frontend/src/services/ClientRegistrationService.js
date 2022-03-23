import axios from 'axios'

class ClientRegistrationService {
    getRegist(){
        return axios.get('http://localhost:8080/registration-client/hello');
    }
}

export default new ClientRegistrationService()