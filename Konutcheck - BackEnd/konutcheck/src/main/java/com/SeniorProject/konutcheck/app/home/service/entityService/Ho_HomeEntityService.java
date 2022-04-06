package com.SeniorProject.konutcheck.app.home.service.entityService;

import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import com.SeniorProject.konutcheck.app.home.dao.Ho_HomeDao;
import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails;
import com.SeniorProject.konutcheck.app.home.entity.Ho_Home;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}

