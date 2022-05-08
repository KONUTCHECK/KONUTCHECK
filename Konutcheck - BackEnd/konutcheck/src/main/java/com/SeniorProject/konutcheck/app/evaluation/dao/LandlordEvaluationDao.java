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

    /*@Query(
            value = "select new com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto(userRelatedHomes.homeId)" +
                    " from UserRelatedHomes userRelatedHomes" +
                    " where userRelatedHomes.tenantId = :id" +
                    " group by userRelatedHomes.homeId"
    )
    GetHomeIdDto findHomeByTenantId(Long id);*/
}

