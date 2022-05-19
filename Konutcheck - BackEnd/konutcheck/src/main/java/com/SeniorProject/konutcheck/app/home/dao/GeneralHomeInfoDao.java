package com.SeniorProject.konutcheck.app.home.dao;

import com.SeniorProject.konutcheck.app.home.entity.GeneralHomeInfo;
import com.SeniorProject.konutcheck.app.home.enums.Cities;
import com.SeniorProject.konutcheck.app.home.enums.HomeTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface GeneralHomeInfoDao extends JpaRepository<GeneralHomeInfo, Long> {
    

    List<GeneralHomeInfo> findByHomeType(HomeTypes homeType);

    List<GeneralHomeInfo> findByAmountBetween(BigDecimal firstAmount, BigDecimal secondAmount);
    List<GeneralHomeInfo> findByAnnouncementDateBetween(LocalDate date1, LocalDate date2);
    List<GeneralHomeInfo> findByCity(Cities city);
    List<GeneralHomeInfo> findByCityAndDistrict(Cities city, String district);
    List<GeneralHomeInfo> findByCityAndDistrictAndNeighborhood(Cities city, String district, String neighborhood);
    List<GeneralHomeInfo> findByCityAndDistrictAndNeighborhoodAndStreet(Cities city, String district, String neighborhood, String street);



}
