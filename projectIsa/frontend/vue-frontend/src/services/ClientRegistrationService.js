import axios from 'axios'

const CLIENT_REGISTRATION_API_BASE_URL = 'http://localhost:8080/'

class ClientRegistrationService {
    getRegist(){
        return axios.get(CLIENT_REGISTRATION_API_BASE_URL);
    }
}

export default new ClientRegistrationService()