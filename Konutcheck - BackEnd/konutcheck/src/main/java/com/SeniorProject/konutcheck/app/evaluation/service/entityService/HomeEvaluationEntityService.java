package com.SeniorProject.konutcheck.app.evaluation.service.entityService;

import com.SeniorProject.konutcheck.app.evaluation.dao.HomeEvaluationDao;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetTotalPoint;
import com.SeniorProject.konutcheck.app.evaluation.entity.HomeEvaluation;
import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeEvaluationEntityService extends BaseEntityService<HomeEvaluation, HomeEvaluationDao> {
    private HomeEvaluationDao homeEvaluationDao;
    public HomeEvaluationEntityService(HomeEvaluationDao dao) {
        super(dao);
        this.homeEvaluationDao = dao;
    }

    public GetHomeIdDto getHomeId(Long id){
        return homeEvaluationDao.getHomeId(id);
    }

    public List<GetTotalPoint> getTotalPoint(Long id){
        return homeEvaluationDao.getTotalPoint(id);
    }
}
