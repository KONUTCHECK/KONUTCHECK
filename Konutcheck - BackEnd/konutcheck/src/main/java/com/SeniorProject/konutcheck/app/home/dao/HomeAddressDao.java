package com.SeniorProject.konutcheck.app.home.dao;

import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails;
import com.SeniorProject.konutcheck.app.home.entity.HomeAddress;
import com.SeniorProject.konutcheck.app.home.enums.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeAddressDao extends JpaRepository<HomeAddress, Long> {

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails(hoHome.Id, generalHomeInfo.homeType, generalHomeInfo.amount, generalHomeInfo.deposit, generalHomeInfo.dues, generalHomeInfo.numberOfRooms, generalHomeInfo.warningSystem, generalHomeInfo.buildingAge, generalHomeInfo.homeAspect, generalHomeInfo.floor, generalHomeInfo.homeSize, homeAddress.country, homeAddress.city, homeAddress.district, homeAddress.neighborhood, homeAddress.street, homeAddress.buildingNo, homeAddress.apartmentNo, hoHome.announcementDate)" +
                    " from Ho_Home  hoHome" +
                    " left join GeneralHomeInfo generalHomeInfo on hoHome.generalHomeInfoId = generalHomeInfo.id" +
                    " left join HomeAddress homeAddress on hoHome.homeAddressId = homeAddress.id " +
                    " where homeAddress.city = :city"
    )
    List<Ho_HomeDetails> findByCity(Cities city);

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails(hoHome.Id, generalHomeInfo.homeType, generalHomeInfo.amount, generalHomeInfo.deposit, generalHomeInfo.dues, generalHomeInfo.numberOfRooms, generalHomeInfo.warningSystem, generalHomeInfo.buildingAge, generalHomeInfo.homeAspect, generalHomeInfo.floor, generalHomeInfo.homeSize, homeAddress.country, homeAddress.city, homeAddress.district, homeAddress.neighborhood, homeAddress.street, homeAddress.buildingNo, homeAddress.apartmentNo, hoHome.announcementDate)" +
                    " from Ho_Home  hoHome" +
                    " left join GeneralHomeInfo generalHomeInfo on hoHome.generalHomeInfoId = generalHomeInfo.id" +
                    " left join HomeAddress homeAddress on hoHome.homeAddressId = homeAddress.id " +
                    " where homeAddress.city = :city and homeAddress.district = :district"
    )
    List<Ho_HomeDetails> findByCityAndDistrict(Cities city, String district);

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails(hoHome.Id, generalHomeInfo.homeType, generalHomeInfo.amount, generalHomeInfo.deposit, generalHomeInfo.dues, generalHomeInfo.numberOfRooms, generalHomeInfo.warningSystem, generalHomeInfo.buildingAge, generalHomeInfo.homeAspect, generalHomeInfo.floor, generalHomeInfo.homeSize, homeAddress.country, homeAddress.city, homeAddress.district, homeAddress.neighborhood, homeAddress.street, homeAddress.buildingNo, homeAddress.apartmentNo, hoHome.announcementDate)" +
                    " from Ho_Home  hoHome" +
                    " left join GeneralHomeInfo generalHomeInfo on hoHome.generalHomeInfoId = generalHomeInfo.id" +
                    " left join HomeAddress homeAddress on hoHome.homeAddressId = homeAddress.id " +
                    " where homeAddress.city = :city and homeAddress.district = :district and homeAddress.neighborhood = :neighborhood"
    )
    List<Ho_HomeDetails> findByCityAndDistrictAndNeighborhood(Cities city, String district, String neighborhood);

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails(hoHome.Id, generalHomeInfo.homeType, generalHomeInfo.amount, generalHomeInfo.deposit, generalHomeInfo.dues, generalHomeInfo.numberOfRooms, generalHomeInfo.warningSystem, generalHomeInfo.buildingAge, generalHomeInfo.homeAspect, generalHomeInfo.floor, generalHomeInfo.homeSize, homeAddress.country, homeAddress.city, homeAddress.district, homeAddress.neighborhood, homeAddress.street, homeAddress.buildingNo, homeAddress.apartmentNo, hoHome.announcementDate)" +
                    " from Ho_Home  hoHome" +
                    " left join GeneralHomeInfo generalHomeInfo on hoHome.generalHomeInfoId = generalHomeInfo.id" +
                    " left join HomeAddress homeAddress on hoHome.homeAddressId = homeAddress.id " +
                    " where homeAddress.city = :city and homeAddress.district = :district and homeAddress.neighborhood = :neighborhood and homeAddress.street = :street"
    )
    List<Ho_HomeDetails> findByCityAndDistrictAndNeighborhoodAndStreet(Cities city, String district, String neighborhood, String street);
}
