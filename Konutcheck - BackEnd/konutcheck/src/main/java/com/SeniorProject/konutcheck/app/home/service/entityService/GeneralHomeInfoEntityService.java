package com.SeniorProject.konutcheck.app.home.service.entityService;

import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import com.SeniorProject.konutcheck.app.home.dao.GeneralHomeInfoDao;
import com.SeniorProject.konutcheck.app.home.entity.GeneralHomeInfo;
import com.SeniorProject.konutcheck.app.home.enums.Cities;
import com.SeniorProject.konutcheck.app.home.enums.HomeTypes;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class GeneralHomeInfoEntityService extends BaseEntityService<GeneralHomeInfo, GeneralHomeInfoDao> {

    private GeneralHomeInfoDao generalHomeInfoDao;

    public GeneralHomeInfoEntityService(GeneralHomeInfoDao dao) {
        super(dao);
        this.generalHomeInfoDao = dao;
    }

   public List<GeneralHomeInfo> findByHomeType(HomeTypes homeType){
        return generalHomeInfoDao.findByHomeType(homeType);
   }

   public List<GeneralHomeInfo> findByBetweenAmount(BigDecimal firstAmount, BigDecimal secondAmount){
        return generalHomeInfoDao.findByAmountBetween(firstAmount, secondAmount);
    }

    public List<GeneralHomeInfo> findByAnnouncementDateBetween(LocalDate date1, LocalDate date2){
        return generalHomeInfoDao.findByAnnouncementDateBetween(date1, date2);
    }

    public List<GeneralHomeInfo> findByCity(Cities city){
        return generalHomeInfoDao.findByCity(city);
    }

    public List<GeneralHomeInfo> findByCityAndDistrict(Cities city, String district ){
        return generalHomeInfoDao.findByCityAndDistrict(city, district);
    }

    public List<GeneralHomeInfo> findByCityAndDistrictAndNeighborHood(Cities city, String district, String neighborhood){
        return generalHomeInfoDao.findByCityAndDistrictAndNeighborhood(city, district, neighborhood);
    }

    public List<GeneralHomeInfo> findByCityAndDistrictAndNeighborHoodAndStreet(Cities city, String district, String neighborhood, String street){
        return generalHomeInfoDao.findByCityAndDistrictAndNeighborhoodAndStreet(city, district, neighborhood, street);
    }
}
