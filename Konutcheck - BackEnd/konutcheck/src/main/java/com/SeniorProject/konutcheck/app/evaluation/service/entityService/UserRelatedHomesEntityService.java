package com.SeniorProject.konutcheck.app.evaluation.service.entityService;

import com.SeniorProject.konutcheck.app.evaluation.dao.UserRelatedHomesDao;
import com.SeniorProject.konutcheck.app.evaluation.entity.UserRelatedHomes;
import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class UserRelatedHomesEntityService extends BaseEntityService<UserRelatedHomes, UserRelatedHomesDao> {
    public UserRelatedHomesEntityService(UserRelatedHomesDao dao) {
        super(dao);
    }
}
