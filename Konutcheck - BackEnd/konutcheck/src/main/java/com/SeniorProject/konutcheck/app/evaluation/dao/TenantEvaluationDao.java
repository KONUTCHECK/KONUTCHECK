package com.SeniorProject.konutcheck.app.evaluation.dao;

import com.SeniorProject.konutcheck.app.evaluation.entity.TenantEvaluation;
import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails;
import com.SeniorProject.konutcheck.app.home.enums.HomeTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantEvaluationDao extends JpaRepository<TenantEvaluation, Long> {
   /* @Query(
            value = "select new com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails(hoHome.Id, generalHomeInfo.homeType, generalHomeInfo.amount, generalHomeInfo.deposit, generalHomeInfo.dues, generalHomeInfo.numberOfRooms, generalHomeInfo.warningSystem, generalHomeInfo.buildingAge, generalHomeInfo.homeAspect, generalHomeInfo.floor, generalHomeInfo.homeSize, hoHome.announcementDate)" +
                    " from Ho_Home  hoHome" +
                    " left join GeneralHomeInfo generalHomeInfo on hoHome.generalHomeInfoId = generalHomeInfo.id" +
                    " where generalHomeInfo.homeType = :homeType"
    )
    Ho_HomeDetails findByHomeType(HomeTypes homeType);*/
}
