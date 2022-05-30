import axios from "axios";

class HomeService {

    findAllHomes() {
        const url = "/homes";
        return axios.get(url);
    }

    /*findById(homeId){
        const url = "/homes/id/" + homeId
        return axios.get("/homes/id/" +  homeId);
    }*/

    /*getHomeById(homeId){
        return axios.get('homes/id'+ '/' + homeId);
    }*/

    saveHome(newHome) {
        const url = "/homes/home-infos"
        return axios.post(url, newHome)
    }

    deleteHome(id) {
        const url = '/homes/' + id;
        return axios.delete(url, id);
    }

    updateHome(home) {
        const url = '/homes/update-home-infos'
        return axios.put(url)
    }

    getHomeByType(type) {
        const url = '/homes/?homeType=' + type.toString();
        return axios.get(url);
    }

    /* getHomeById(homeId){
         return axios.get(homeId);
     }*/
}

export default new HomeService();