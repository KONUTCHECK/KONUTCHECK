import axios from "axios";

class EvaluationService {

    saveHomeEvaluation(newHomeEvaluation) {
        const url = "/evaluations/home-evaluation";
        return axios.post(url, newHomeEvaluation);
    }

    saveLandlordEvaluation(newLandlordEvaluation) {
        const url = '/evaluations/landlord-evaluation';
        return axios.post(url, newLandlordEvaluation);
    }

    saveTenantEvaluation(newTenantEvaluation, tenantId) {
        const url = '/evaluations/tenant-evaluation/' + tenantId;
        return axios.post(url, newTenantEvaluation, tenantId);
    }

    getTotalPointOfHome(id) {
        const url = '/evaluations/home-total-point/' + id;
        return axios.get(url, id);
    }
    getTotalPointOflandlord(id) {
        const url = '/evaluations/landlord-total-point/' + id;
        return axios.get(url, id);
    }

}

export default new EvaluationService();

