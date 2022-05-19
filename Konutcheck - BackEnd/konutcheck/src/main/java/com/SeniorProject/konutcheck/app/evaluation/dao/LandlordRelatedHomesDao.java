package com.SeniorProject.konutcheck.app.evaluation.dao;

import com.SeniorProject.konutcheck.app.evaluation.dto.UserHomeDetails;
import com.SeniorProject.konutcheck.app.evaluation.entity.LandlordRelatedHomes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandlordRelatedHomesDao extends JpaRepository<LandlordRelatedHomes, Long> {

    Boolean existsByHomeId(Long id);

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.evaluation.dto.UserHomeDetails(generalHomeInfo.id, landlordRelatedHomes.landlordId, generalHomeInfo.homeType, generalHomeInfo.amount, generalHomeInfo.deposit, generalHomeInfo.dues, generalHomeInfo.numberOfRooms, generalHomeInfo.warningSystem, generalHomeInfo.buildingAge, generalHomeInfo.homeAspect, generalHomeInfo.floor, generalHomeInfo.homeSize, generalHomeInfo.country, generalHomeInfo.city, generalHomeInfo.district, generalHomeInfo.neighborhood, generalHomeInfo.street, generalHomeInfo.buildingNo, generalHomeInfo.apartmentNo, generalHomeInfo.announcementDate)" +
                    " from LandlordRelatedHomes landlordRelatedHomes" +
                    " left join GeneralHomeInfo generalHomeInfo on generalHomeInfo.id = landlordRelatedHomes.homeId" +
                    " where landlordRelatedHomes.landlordId = :landlordId"
    )
    List<UserHomeDetails> getHomeDetailsByLandlordId(Long landlordId);
}
