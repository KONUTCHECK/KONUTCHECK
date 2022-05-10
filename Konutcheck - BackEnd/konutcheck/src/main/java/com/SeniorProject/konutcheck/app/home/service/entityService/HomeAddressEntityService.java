package com.SeniorProject.konutcheck.app.home.service.entityService;

import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import com.SeniorProject.konutcheck.app.home.dao.HomeAddressDao;
import com.SeniorProject.konutcheck.app.home.entity.HomeAddress;
import org.springframework.stereotype.Service;

@Service
public class HomeAddressEntityService extends BaseEntityService<HomeAddress, HomeAddressDao> {
    public HomeAddressEntityService(HomeAddressDao dao) {
        super(dao);
    }
}
