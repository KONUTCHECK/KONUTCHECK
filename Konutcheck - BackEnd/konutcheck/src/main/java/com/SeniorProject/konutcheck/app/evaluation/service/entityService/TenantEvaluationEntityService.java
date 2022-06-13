package com.SeniorProject.konutcheck.app.evaluation.service.entityService;

import com.SeniorProject.konutcheck.app.evaluation.dao.TenantEvaluationDao;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetStatusTypeDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetTotalPoint;
import com.SeniorProject.konutcheck.app.evaluation.entity.TenantEvaluation;
import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TenantEvaluationEntityService extends BaseEntityService<TenantEvaluation, TenantEvaluationDao> {
    private TenantEvaluationDao tenantEvaluationDao;
    public TenantEvaluationEntityService(TenantEvaluationDao dao) {
        super(dao);
        this.tenantEvaluationDao = dao;
    }

    public List<GetTotalPoint> getTotalPoint(Long id){
        return tenantEvaluationDao.getTotalPoint(id);
    }

    public GetHomeIdDto getTenantId(){
        return tenantEvaluationDao.getTenantId();
    }

    public GetStatusTypeDto getLandlordStatus(Long userId){
        return tenantEvaluationDao.getLandlordStatus(userId);
    }

}


