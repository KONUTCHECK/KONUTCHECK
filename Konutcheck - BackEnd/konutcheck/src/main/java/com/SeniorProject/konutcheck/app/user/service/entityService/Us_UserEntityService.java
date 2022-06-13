package com.SeniorProject.konutcheck.app.user.service.entityService;

import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import com.SeniorProject.konutcheck.app.user.dao.Us_UserDao;
import com.SeniorProject.konutcheck.app.user.entity.Us_User;
import com.SeniorProject.konutcheck.app.user.enums.StatusType;
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

    public List<Us_User> findAllActiveUser(){
        return usUserDao.findAllByStatusType(StatusType.Aktif);
    }
    public List<Us_User> getAllByUserTypeWithActiveUser(UserType userType){
        return usUserDao.findByUserTypeAndStatusType(userType, StatusType.Aktif);
    }

    public Us_User findByEmail(String email){
        return usUserDao.findByEmail(email);
    }

    public boolean existByEmail(String email){
        return usUserDao.existsByEmail(email);
    }

    public Boolean existByPhoneNumber1(String phoneNumber1){
        return usUserDao.existsByUserPhoneNumber1(phoneNumber1);
    }

    public Boolean existByPhoneNumber2(String phoneNumber2){
        return usUserDao.existsByUserPhoneNumber1(phoneNumber2);
    }

}
