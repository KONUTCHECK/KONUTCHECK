package com.SeniorProject.konutcheck.app.home.dao;

import com.SeniorProject.konutcheck.app.home.entity.HomeAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeAddressDao extends JpaRepository<HomeAddress, Long> {
}
