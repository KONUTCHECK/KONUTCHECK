package com.SeniorProject.konutcheck.app.evaluation.dao;

import com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetStatusTypeDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetTotalPoint;
import com.SeniorProject.konutcheck.app.evaluation.entity.TenantEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantEvaluationDao extends JpaRepository<TenantEvaluation, Long> {
    @Query(
            value = "select new com.SeniorProject.konutcheck.app.evaluation.dto.GetTotalPoint(SUM(tenantEvaluation.tenantPoint))" +
                    " from TenantEvaluation tenantEvaluation" +
                    " where tenantEvaluation.tenantId = :id"
    )
    List<GetTotalPoint> getTotalPoint(Long id);

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto(tenantHome.tenantId)" +
                    " from TenantHome tenantHome" +
                    " left join TenantEvaluation tenantEvaluation on tenantEvaluation.tenantId = tenantHome.tenantId" +
                    " group by tenantHome.tenantId"
    )
    GetHomeIdDto getTenantId();

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.evaluation.dto.GetStatusTypeDto(user.statusType)" +
                    " from Us_User user" +
                    " where user.Id = :userId " +
                    " group by user.statusType"
    )
    GetStatusTypeDto getLandlordStatus(Long userId);

}
