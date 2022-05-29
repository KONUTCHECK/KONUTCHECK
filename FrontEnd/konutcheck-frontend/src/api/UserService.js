import axios from "axios";

class UserService{

    findAllUsers(){
        const url = "/users";
        return axios.get(url);
    }

    getUserInfo(){
        const url = "/users/user-info";
        return axios.get(url);
    }

    deleteUser(id) {
        const url = '/users/' + id;
        return axios.delete(url, id);
    }
    
}

export default new UserService();

