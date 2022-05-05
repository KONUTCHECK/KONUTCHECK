package com.SeniorProject.konutcheck.app.evaluation.dao;

import com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto;
import com.SeniorProject.konutcheck.app.evaluation.entity.LandlordEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LandlordEvaluationDao extends JpaRepository<LandlordEvaluation, Long>{
   /* @Query(
            value = "select new com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto(userRelatedHomes.homeId)" +
                    " from UserRelatedHomes userRelatedHomes" +
                    " where userRelatedHomes.landlordId = :id" +
                    " group by userRelatedHomes.homeId"

    )
    GetHomeIdDto findHomeByLandlordId(Long id);*/

    /*@Query(
            value = "select new com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto(userRelatedHomes.homeId)" +
                    " from UserRelatedHomes userRelatedHomes" +
                    " where userRelatedHomes.tenantId = :id" +
                    " group by userRelatedHomes.homeId"
    )
    GetHomeIdDto findHomeByTenantId(Long id);*/
}

