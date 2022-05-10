package com.SeniorProject.konutcheck.app.home.dao;

import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails;
import com.SeniorProject.konutcheck.app.home.entity.Ho_Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface Ho_HomeDao extends JpaRepository<Ho_Home, Long> {

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails(hoHome.Id, generalHomeInfo.homeType, generalHomeInfo.amount, generalHomeInfo.deposit, generalHomeInfo.dues, generalHomeInfo.numberOfRooms, generalHomeInfo.warningSystem, generalHomeInfo.buildingAge, generalHomeInfo.homeAspect, generalHomeInfo.floor, generalHomeInfo.homeSize, homeAddress.country, homeAddress.city, homeAddress.district, homeAddress.neighborhood, homeAddress.street, homeAddress.buildingNo, homeAddress.apartmentNo, hoHome.announcementDate)" +
                    " from Ho_Home  hoHome" +
                    " left join GeneralHomeInfo generalHomeInfo on hoHome.generalHomeInfoId = generalHomeInfo.id" +
                    " left join HomeAddress homeAddress on hoHome.homeAddressId = homeAddress.id"
    )
    List<Ho_HomeDetails> getAllHomesWithDetails();

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails(hoHome.Id, generalHomeInfo.homeType, generalHomeInfo.amount, generalHomeInfo.deposit, generalHomeInfo.dues, generalHomeInfo.numberOfRooms, generalHomeInfo.warningSystem, generalHomeInfo.buildingAge, generalHomeInfo.homeAspect, generalHomeInfo.floor, generalHomeInfo.homeSize, homeAddress.country, homeAddress.city, homeAddress.district, homeAddress.neighborhood, homeAddress.street, homeAddress.buildingNo, homeAddress.apartmentNo, hoHome.announcementDate)" +
                    " from Ho_Home  hoHome" +
                    " left join GeneralHomeInfo generalHomeInfo on hoHome.generalHomeInfoId = generalHomeInfo.id" +
                    " left join HomeAddress homeAddress on hoHome.homeAddressId = homeAddress.id" +
                    " where hoHome.announcementDate between :date1 and :date2"
    )
    List<Ho_HomeDetails> findByAnnouncementDateBetween(LocalDate date1, LocalDate date2);
}

