package com.SeniorProject.konutcheck.app.evaluation.service.entityService;

import com.SeniorProject.konutcheck.app.evaluation.dao.TenantEvaluationDao;
import com.SeniorProject.konutcheck.app.evaluation.entity.TenantEvaluation;
import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import org.springframework.stereotype.Service;


@Service
public class TenantEvaluationEntityService extends BaseEntityService<TenantEvaluation, TenantEvaluationDao> {
    public TenantEvaluationEntityService(TenantEvaluationDao dao) {
        super(dao);
    }
}


