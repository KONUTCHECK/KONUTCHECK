package com.SeniorProject.konutcheck.app.home.service.entityService;

import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import com.SeniorProject.konutcheck.app.home.dao.HomeAddressDao;
import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails;
import com.SeniorProject.konutcheck.app.home.entity.HomeAddress;
import com.SeniorProject.konutcheck.app.home.enums.Cities;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeAddressEntityService extends BaseEntityService<HomeAddress, HomeAddressDao> {
    private HomeAddressDao homeAddressDao;
    public HomeAddressEntityService(HomeAddressDao dao) {
        super(dao);
        this.homeAddressDao = dao;
    }

    public List<Ho_HomeDetails> findByCity(Cities city){
        return homeAddressDao.findByCity(city);
    }

    public List<Ho_HomeDetails> findByCityAndDistrict(Cities city, String district ){
        return homeAddressDao.findByCityAndDistrict(city, district);
    }

    public List<Ho_HomeDetails> findByCityAndDistrictAndNeighborHood(Cities city, String district, String neighborhood){
        return homeAddressDao.findByCityAndDistrictAndNeighborhood(city, district, neighborhood);
    }

    public List<Ho_HomeDetails> findByCityAndDistrictAndNeighborHoodAndStreet(Cities city, String district, String neighborhood, String street){
        return homeAddressDao.findByCityAndDistrictAndNeighborhoodAndStreet(city, district, neighborhood, street);
    }


}
