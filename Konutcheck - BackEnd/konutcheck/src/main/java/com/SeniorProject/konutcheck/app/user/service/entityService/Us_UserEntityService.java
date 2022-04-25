package com.SeniorProject.konutcheck.app.user.service.entityService;

import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import com.SeniorProject.konutcheck.app.user.dao.Us_UserDao;
import com.SeniorProject.konutcheck.app.user.entity.Us_User;
import com.SeniorProject.konutcheck.app.user.enums.UserType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Us_UserEntityService extends BaseEntityService<Us_User, Us_UserDao> {

    private Us_UserDao usUserDao;

    public Us_UserEntityService(Us_UserDao dao) {
        super(dao);
        this.usUserDao = dao;
    }

    public List<Us_User> getAllByUserType(UserType userType){
        return usUserDao.findByUserType(userType);
    }

    public Us_User findByEmail(String email){
        return usUserDao.findByEmail(email);
    }

    public boolean existByEmail(String email){
        return usUserDao.existsByEmail(email);
    }
}
