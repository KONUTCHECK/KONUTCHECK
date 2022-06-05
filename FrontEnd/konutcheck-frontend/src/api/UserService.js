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

    cancelUser(){
        const url = '/users/cancel/';
        return axios.patch(url);
    }
    getUserByType(type) {
        const url = '/users/' + type.toString();
        return axios.get(url);
}
}
export default new UserService();

