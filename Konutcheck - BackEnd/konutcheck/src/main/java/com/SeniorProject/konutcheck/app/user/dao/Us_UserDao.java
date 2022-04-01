package com.SeniorProject.konutcheck.app.user.dao;

import com.SeniorProject.konutcheck.app.user.entity.Us_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Us_UserDao extends JpaRepository<Us_User, Long> {
}
