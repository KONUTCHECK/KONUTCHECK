import axios from "axios";

class HomeService{

    findAllHomes(){
        const url = "/homes";
        return axios.get(url);
    }

    saveHome(newHome){
        const url = "/homes/home-infos"
        return axios.post(url, newHome)
    }
}

export default new HomeService();