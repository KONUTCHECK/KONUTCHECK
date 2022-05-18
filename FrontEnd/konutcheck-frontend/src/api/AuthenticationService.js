import axios from "axios";

class AuthenticationService {

    login(email, password){

        const data = {
            email : email,
            password : password
        }

        const url = "/auth/login"

       return axios.post(url, data);
    }

}

export default new AuthenticationService();