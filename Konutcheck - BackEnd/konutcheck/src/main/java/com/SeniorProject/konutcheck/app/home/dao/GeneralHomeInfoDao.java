package com.SeniorProject.konutcheck.app.home.dao;

import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails;
import com.SeniorProject.konutcheck.app.home.entity.GeneralHomeInfo;
import com.SeniorProject.konutcheck.app.home.enums.HomeTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GeneralHomeInfoDao extends JpaRepository<GeneralHomeInfo, Long> {

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails(hoHome.Id, generalHomeInfo.homeType, generalHomeInfo.amount, generalHomeInfo.deposit, generalHomeInfo.dues, generalHomeInfo.numberOfRooms, generalHomeInfo.warningSystem, generalHomeInfo.buildingAge, generalHomeInfo.homeAspect, generalHomeInfo.floor, generalHomeInfo.homeSize, homeAddress.country, homeAddress.city, homeAddress.district, homeAddress.neighborhood, homeAddress.street, homeAddress.buildingNo, homeAddress.apartmentNo, hoHome.announcementDate)" +
                    " from Ho_Home  hoHome" +
                    " left join GeneralHomeInfo generalHomeInfo on hoHome.generalHomeInfoId = generalHomeInfo.id" +
                    " left join HomeAddress homeAddress on hoHome.homeAddressId = homeAddress.id " +
                    " where generalHomeInfo.homeType = :homeType"
    )
    List<Ho_HomeDetails> findByHomeType(HomeTypes homeType);

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails(hoHome.Id, generalHomeInfo.homeType, generalHomeInfo.amount, generalHomeInfo.deposit, generalHomeInfo.dues, generalHomeInfo.numberOfRooms, generalHomeInfo.warningSystem, generalHomeInfo.buildingAge, generalHomeInfo.homeAspect, generalHomeInfo.floor, generalHomeInfo.homeSize, homeAddress.country, homeAddress.city, homeAddress.district, homeAddress.neighborhood, homeAddress.street, homeAddress.buildingNo, homeAddress.apartmentNo, hoHome.announcementDate)" +
                    " from Ho_Home  hoHome" +
                    " left join GeneralHomeInfo generalHomeInfo on hoHome.generalHomeInfoId = generalHomeInfo.id" +
                    " left join HomeAddress homeAddress on hoHome.homeAddressId = homeAddress.id " +
                    " where generalHomeInfo.amount between :firstAmount and :secondAmount"
    )
    List<Ho_HomeDetails> findByAmountBetween(BigDecimal firstAmount, BigDecimal secondAmount);

}
