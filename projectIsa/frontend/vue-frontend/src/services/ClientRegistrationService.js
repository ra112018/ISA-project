import axios from 'axios'

class ClientRegistrationService {
    getRegist(){
        return axios.get('http://localhost:8080/registration-client/hello');
    }

    registerClient(client){
        return axios.post('http://localhost:8080/registration-client/registration', client)
    }
}

export default new ClientRegistrationService()