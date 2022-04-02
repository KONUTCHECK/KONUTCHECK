package com.SeniorProject.konutcheck.app.user.service.entityService;

import com.SeniorProject.konutcheck.app.general.service.BaseEntityService;
import com.SeniorProject.konutcheck.app.user.dao.Us_UserDao;
import com.SeniorProject.konutcheck.app.user.entity.Us_User;
import com.SeniorProject.konutcheck.app.user.enums.UserTypeEnums;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Us_UserEntityService extends BaseEntityService<Us_User, Us_UserDao> {

    private Us_UserDao usUserDao;

    public Us_UserEntityService(Us_UserDao dao) {
        super(dao);
        this.usUserDao = dao;
    }

    public List<Us_User> getAllByUserType(UserTypeEnums userType){
        return usUserDao.findByUserType(userType);
    }
}
