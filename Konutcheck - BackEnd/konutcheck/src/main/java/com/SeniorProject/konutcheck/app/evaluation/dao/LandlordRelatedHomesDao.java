package com.SeniorProject.konutcheck.app.evaluation.dao;

import com.SeniorProject.konutcheck.app.evaluation.entity.LandlordRelatedHomes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandlordRelatedHomesDao extends JpaRepository<LandlordRelatedHomes, Long> {

    Boolean existsByHomeId(Long id);
}
