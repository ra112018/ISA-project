import axios from 'axios'

class ClientRegistrationService {

    registerClient(client){
        return axios.post('http://localhost:8080/registration-client/registration', client)
    }
}

export default new ClientRegistrationService()