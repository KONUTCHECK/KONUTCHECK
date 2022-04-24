package com.SeniorProject.konutcheck.app.evaluation.service.entityService;

import com.SeniorProject.konutcheck.app.evaluation.dao.HomesRelatedWithUsersDao;
import com.SeniorProject.konutcheck.app.evaluation.entity.HomesRelatedWithUsers;
import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;

public class HomeRelatedWithUsersEntityService extends BaseEntityService <HomesRelatedWithUsers, HomesRelatedWithUsersDao> {
    public HomeRelatedWithUsersEntityService(HomesRelatedWithUsersDao dao) {
        super(dao);
    }
}
