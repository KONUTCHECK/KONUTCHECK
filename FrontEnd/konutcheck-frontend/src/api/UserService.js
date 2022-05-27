import axios from "axios";

class UserService{

    findAllUsers(){
        const url = "/users";
        return axios.get(url);
    }


    
}

export default new UserService();

