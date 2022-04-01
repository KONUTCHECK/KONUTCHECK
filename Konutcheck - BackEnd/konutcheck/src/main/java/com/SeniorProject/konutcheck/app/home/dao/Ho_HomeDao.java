package com.SeniorProject.konutcheck.app.home.dao;

import com.SeniorProject.konutcheck.app.home.entity.Ho_Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_HomeDao extends JpaRepository<Ho_Home, Long> {

}

