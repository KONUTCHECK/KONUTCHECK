package com.SeniorProject.konutcheck.app.evaluation.dao;

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

}
