package com.SeniorProject.konutcheck.app.home.service.entityService;

import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import com.SeniorProject.konutcheck.app.home.dao.Ho_HomeDao;
import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails;
import com.SeniorProject.konutcheck.app.home.entity.Ho_Home;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class Ho_HomeEntityService extends BaseEntityService<Ho_Home, Ho_HomeDao> {
    private Ho_HomeDao hoHomeDao;

    public Ho_HomeEntityService(Ho_HomeDao dao) {
        super(dao);
        this.hoHomeDao = dao;
    }

    public List<Ho_HomeDetails> getAllHomes(){
        return hoHomeDao.getAllHomesWithDetails();
    }

    public List<Ho_HomeDetails> findByAnnouncementDateBetween(LocalDate date1, LocalDate date2){
        return hoHomeDao.findByAnnouncementDateBetween(date1, date2);
    }
}

