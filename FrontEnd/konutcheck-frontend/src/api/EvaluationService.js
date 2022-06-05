import axios from "axios";

class EvaluationService{

    saveHomeEvaluation(newHomeEvaluation){
        const url = "/evaluations/home-evaluation";
        return axios.post(url, newHomeEvaluation);
    }

    saveLandlordEvaluation(newLandlordEvaluation){
        const url = '/evaluations/landlord-evaluation';
        return axios.post(url, newLandlordEvaluation);
    }

    saveTenantEvaluation(newTenantEvaluation, tenantId){
        const url = '/evaluations/tenant-evaluation/' + tenantId;
        return axios.post(url, newTenantEvaluation, tenantId);
    }
    
}

export default new EvaluationService();

