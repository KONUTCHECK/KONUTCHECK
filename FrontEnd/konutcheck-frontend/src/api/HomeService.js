import axios from "axios";

class HomeService {

    findAllHomes() {
        const url = "/homes";
        return axios.get(url);
    }

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

    getHomeBetweenAmounts(amount1, amount2) {
        const url = '/homes/between-amounts/?firstAmount=' + amount1 + '&secondAmount=' + amount2;
        return axios.get(url);
    }

    getHomeByCity(city) {
        const url = '/homes/cities/?city=' + city.toString();
        return axios.get(url);
    }

    listPassiveHomes() {
        const url = '/homes/list-passive-homes';
        return axios.get(url);
    }

    setTenantHome(id) {
        const url = '/homes/save-tenant-home/' + id;
        return axios.patch(url, id)
    }

    setTenantHomeStatusActive(id) {
        const url = '/homes/set-status-active/' + id;
        return axios.patch(url, id)
    }

    getTenantHomeDetails() {
        const url = '/homes/tenant-homes-details';
        return axios.get(url);
    }

    getLandlordHomeDetails() {
        const url = '/homes/landlord-homes';
        return axios.get(url);
    }

    listLandlordTenants() {
        const url = '/homes/landlord-tenants';
        return axios.get(url);
    }

}

export default new HomeService();