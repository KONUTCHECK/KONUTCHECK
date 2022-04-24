package com.SeniorProject.konutcheck.app.evaluation.service.entityService;
import com.SeniorProject.konutcheck.app.evaluation.dao.LandlordEvaluationDao;
import com.SeniorProject.konutcheck.app.evaluation.entity.LandlordEvaluation;
import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class LandlordEvaluationEntityService extends BaseEntityService<LandlordEvaluation, LandlordEvaluationDao> {
    public LandlordEvaluationEntityService(LandlordEvaluationDao dao) {
        super(dao);
    }
}
