package com.SeniorProject.konutcheck.app.home.service.entityService;

import com.SeniorProject.konutcheck.app.home.dao.Ho_HomeDao;
import com.SeniorProject.konutcheck.app.home.entity.Ho_Home;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Ho_HomeEntityService {
    private final Ho_HomeDao hoHomeDao;

    public Ho_Home save(Ho_Home hoHome){
        return hoHomeDao.save (hoHome);
    }
}

