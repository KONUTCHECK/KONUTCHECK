package com.SeniorProject.konutcheck.app.home.service.entityService;

import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import com.SeniorProject.konutcheck.app.home.dao.GeneralHomeInfoDao;
import com.SeniorProject.konutcheck.app.home.entity.GeneralHomeInfo;
import org.springframework.stereotype.Service;

@Service
public class GeneralHomeInfoEntityService extends BaseEntityService<GeneralHomeInfo, GeneralHomeInfoDao> {
    public GeneralHomeInfoEntityService(GeneralHomeInfoDao dao) {
        super(dao);
    }
}
