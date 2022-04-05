package com.SeniorProject.konutcheck.app.home.dao;

import com.SeniorProject.konutcheck.app.home.entity.GeneralHomeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralHomeInfoDao extends JpaRepository<GeneralHomeInfo, Long> {
}
