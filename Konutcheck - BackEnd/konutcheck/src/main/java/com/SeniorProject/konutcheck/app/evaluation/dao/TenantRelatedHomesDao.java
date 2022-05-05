package com.SeniorProject.konutcheck.app.evaluation.dao;

import com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto;
import com.SeniorProject.konutcheck.app.evaluation.entity.TenantRelatedHomes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRelatedHomesDao extends JpaRepository<TenantRelatedHomes, Long> {
    @Query(
            value = "select new com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto(tenantRelatedHomes.homeId)" +
                    " from TenantRelatedHomes tenantRelatedHomes" +
                    " where tenantRelatedHomes.landlordId = :id" +
                    " group by tenantRelatedHomes.homeId"
    )
    GetHomeIdDto getHomeIdByLandlordId(Long id);
}
