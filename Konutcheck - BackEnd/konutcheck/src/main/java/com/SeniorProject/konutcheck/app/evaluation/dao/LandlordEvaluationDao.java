package com.SeniorProject.konutcheck.app.evaluation.dao;

import com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetTotalPoint;
import com.SeniorProject.konutcheck.app.evaluation.entity.LandlordEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandlordEvaluationDao extends JpaRepository<LandlordEvaluation, Long>{
   @Query(
            value = "select new com.SeniorProject.konutcheck.app.evaluation.dto.GetTotalPoint(SUM(landlordEvaluation.landlordPoint))" +
                    " from LandlordEvaluation landlordEvaluation" +
                    " where landlordEvaluation.landlordId = :id"
    )
   List<GetTotalPoint> getTotalPoint(Long id);

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto(generalHomeInfo.homeOwner)" +
                    " from GeneralHomeInfo generalHomeInfo" +
                    " left join TenantHome  tenantHome on tenantHome.homeId = generalHomeInfo.id" +
                    " where tenantHome.tenantId = :tenantId" +
                    " group by generalHomeInfo.homeOwner"
    )
    GetHomeIdDto getLandlordId(Long tenantId);

    Boolean existsByEvaluationOwnerTenantId(Long tenantId);
}

