import axios from 'axios'

class LoginService {

    Login(userInfo){
        console.log("servis")
        return axios.post('http://localhost:8080/users/login', userInfo).then((res) => {
            this.isLogin = true;
            this.roleAs = res.data.role;
            console.log(res.data.role)
            localStorage.setItem('STATE', 'true');
            localStorage.setItem('currentUser', JSON.stringify(res));
            localStorage.setItem('currentUserId' , res.id)
            localStorage.setItem('ROLE', res.data.role);
            localStorage.setItem('statusLogin', res.status);
            this.currentUser = res;
            return res;
          });

    }
}

export default new LoginService()