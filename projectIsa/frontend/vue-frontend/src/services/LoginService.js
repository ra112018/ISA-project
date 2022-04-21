import axios from 'axios'

class LoginService {

    Login(loginInfo){
        console.log("servis")
        return axios.post('http://localhost:8080/login-user/login', loginInfo).pipe(res => {
            this.isLogin = true;
            this.roleAs = res.user.role;
            localStorage.setItem('STATE', 'true');
            localStorage.setItem('currentUser', JSON.stringify(res));
            localStorage.setItem('currentUserId' , res.user.id.toString())
            localStorage.setItem('ROLE', this.roleAs);
            this.currentUser = res;
            return res;
          });
    }
}

export default new LoginService()