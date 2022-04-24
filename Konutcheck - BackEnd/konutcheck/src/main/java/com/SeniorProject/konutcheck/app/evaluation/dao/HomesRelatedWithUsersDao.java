package com.SeniorProject.konutcheck.app.evaluation.dao;

import com.SeniorProject.konutcheck.app.evaluation.entity.HomesRelatedWithUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomesRelatedWithUsersDao extends JpaRepository<HomesRelatedWithUsers, Long> {
}
