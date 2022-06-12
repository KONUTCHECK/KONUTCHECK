package com.SeniorProject.konutcheck.app.evaluation.service.entityService;
import com.SeniorProject.konutcheck.app.evaluation.dao.LandlordEvaluationDao;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetTotalPoint;
import com.SeniorProject.konutcheck.app.evaluation.entity.LandlordEvaluation;
import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LandlordEvaluationEntityService extends BaseEntityService<LandlordEvaluation, LandlordEvaluationDao> {
    private LandlordEvaluationDao landlordEvaluationDao;
    public LandlordEvaluationEntityService(LandlordEvaluationDao dao) {
        super(dao);
        this.landlordEvaluationDao = dao;
    }

    public List<GetTotalPoint> getTotalPoint(Long id){
        return landlordEvaluationDao.getTotalPoint(id);
    }

    public GetHomeIdDto getLandlordId(Long tenantId){
        return landlordEvaluationDao.getLandlordId(tenantId);
    }

    public Boolean isExistEvaluationOwnerTenantId(Long tenantId){
        return landlordEvaluationDao.existsByEvaluationOwnerTenantId(tenantId);
    }
}
