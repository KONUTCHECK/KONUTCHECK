package com.SeniorProject.konutcheck.app.user.service.entityService;

import com.SeniorProject.konutcheck.app.user.dao.Us_UserDao;
import com.SeniorProject.konutcheck.app.user.entity.Us_User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Us_UserEntityService {
    private final Us_UserDao usUserDao;

    public Us_User save(Us_User usUser){
        return usUserDao.save(usUser);
    }
}
