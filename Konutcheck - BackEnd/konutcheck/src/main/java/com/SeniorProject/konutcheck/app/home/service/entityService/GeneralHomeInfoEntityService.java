package com.SeniorProject.konutcheck.app.home.service.entityService;

import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import com.SeniorProject.konutcheck.app.home.dao.GeneralHomeInfoDao;
import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails;
import com.SeniorProject.konutcheck.app.home.entity.GeneralHomeInfo;
import com.SeniorProject.konutcheck.app.home.enums.HomeTypes;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GeneralHomeInfoEntityService extends BaseEntityService<GeneralHomeInfo, GeneralHomeInfoDao> {

    private GeneralHomeInfoDao generalHomeInfoDao;

    public GeneralHomeInfoEntityService(GeneralHomeInfoDao dao) {
        super(dao);
        this.generalHomeInfoDao = dao;
    }

   public List<Ho_HomeDetails> findByHomeType(HomeTypes homeType){
        return generalHomeInfoDao.findByHomeType(homeType);
   }

   public List<Ho_HomeDetails> findByBetweenAmount(BigDecimal firstAmount, BigDecimal secondAmount){
        return generalHomeInfoDao.findByAmountBetween(firstAmount, secondAmount);
    }
}
