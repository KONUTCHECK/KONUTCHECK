package com.SeniorProject.konutcheck.app.evaluation.dao;

import com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetTotalPoint;
import com.SeniorProject.konutcheck.app.evaluation.entity.HomeEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeEvaluationDao extends JpaRepository<HomeEvaluation, Long> {

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto(tenantHome.homeId)" +
                    " from TenantHome tenantHome" +
                    " left join HomeEvaluation  homeEvaluation on homeEvaluation.homeId = tenantHome.homeId" +
                    " group by tenantHome.homeId"
    )
    GetHomeIdDto getHomeId();

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.evaluation.dto.GetTotalPoint(SUM(homeEvaluation.homePoint))" +
                    " from HomeEvaluation homeEvaluation" +
                    " where homeEvaluation.homeId = :id"
    )
    List<GetTotalPoint> getTotalPoint(Long id);

    Boolean existsByEvaluationOwnerTenantId(Long id);

}
