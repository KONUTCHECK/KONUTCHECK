package com.SeniorProject.konutcheck.app.evaluation.service.entityService;

import com.SeniorProject.konutcheck.app.evaluation.dao.LandlordRelatedHomesDao;
import com.SeniorProject.konutcheck.app.evaluation.dto.UserHomeDetails;
import com.SeniorProject.konutcheck.app.evaluation.entity.LandlordRelatedHomes;
import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandlordRelatedHomesEntityService extends BaseEntityService<LandlordRelatedHomes, LandlordRelatedHomesDao> {
    private LandlordRelatedHomesDao landlordRelatedHomesDao;
    public LandlordRelatedHomesEntityService(LandlordRelatedHomesDao dao) {
        super(dao);
        this.landlordRelatedHomesDao = dao;
    }

    public Boolean isHomeIdExist(Long id){
        return landlordRelatedHomesDao.existsByHomeId(id);
    }

    public List<UserHomeDetails> getLandlordHomeDetails(Long id){
        return landlordRelatedHomesDao.getHomeDetailsByLandlordId(id);
    }
}
