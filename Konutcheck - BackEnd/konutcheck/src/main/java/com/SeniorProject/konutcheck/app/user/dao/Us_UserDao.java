package com.SeniorProject.konutcheck.app.user.dao;

import com.SeniorProject.konutcheck.app.user.entity.Us_User;
import com.SeniorProject.konutcheck.app.user.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Us_UserDao extends JpaRepository<Us_User, Long> {

    List<Us_User> findByUserType(UserType userType);
    Us_User findByEmail(String email);
    Boolean existsByEmail(String email);

}
