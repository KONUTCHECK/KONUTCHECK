package com.SeniorProject.konutcheck.app.home.dao;

import com.SeniorProject.konutcheck.app.evaluation.dto.GetStatusTypeDto;
import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails;
import com.SeniorProject.konutcheck.app.home.dto.TenantHomeDetails;
import com.SeniorProject.konutcheck.app.home.entity.TenantHome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantHomeDao extends JpaRepository<TenantHome, Long> {

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.home.dto.TenantHomeDetails(tenantHome.tenantId, tenantHome.id, user.name, user.surname,generalHomeInfo.country, generalHomeInfo.city, generalHomeInfo.district, generalHomeInfo.neighborhood, generalHomeInfo.street, generalHomeInfo.buildingNo, generalHomeInfo.apartmentNo)" +
                    " from TenantHome tenantHome" +
                    " left join GeneralHomeInfo generalHomeInfo on generalHomeInfo.id = tenantHome.homeId" +
                    " left join Us_User user on user.Id = tenantHome.tenantId" +
                    " where generalHomeInfo.homeOwner = :landlordId and tenantHome.statusType = 'Pasif'"
    )
    List<TenantHomeDetails> getTenantHomeList(Long landlordId);

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.home.dto.TenantHomeDetails(tenantHome.tenantId, tenantHome.id, user.name, user.surname,generalHomeInfo.country, generalHomeInfo.city, generalHomeInfo.district, generalHomeInfo.neighborhood, generalHomeInfo.street, generalHomeInfo.buildingNo, generalHomeInfo.apartmentNo)" +
                    " from TenantHome tenantHome" +
                    " left join GeneralHomeInfo generalHomeInfo on generalHomeInfo.id = tenantHome.homeId" +
                    " left join Us_User user on user.Id = tenantHome.tenantId" +
                    " where generalHomeInfo.homeOwner = :landlordId and tenantHome.statusType = 'Aktif'"
    )
    List<TenantHomeDetails> getLandlordsTenant(Long landlordId);

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails(generalHomeInfo.id, generalHomeInfo.homeType, generalHomeInfo.amount, generalHomeInfo.deposit, generalHomeInfo.dues, generalHomeInfo.numberOfRooms, generalHomeInfo.warningSystem, generalHomeInfo.buildingAge, generalHomeInfo.homeAspect, generalHomeInfo.floor, generalHomeInfo.homeSize,generalHomeInfo.country, generalHomeInfo.city, generalHomeInfo.district, generalHomeInfo.neighborhood, generalHomeInfo.street, generalHomeInfo.buildingNo, generalHomeInfo.apartmentNo, generalHomeInfo.announcementDate)" +
                    " from GeneralHomeInfo generalHomeInfo" +
                    " left join TenantHome tenantHome on tenantHome.homeId = generalHomeInfo.id" +
                    " where tenantHome.tenantId = :tenantId and tenantHome.statusType = 'Aktif'"
    )
    List<Ho_HomeDetails> homesBelongToTenant(Long tenantId);

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.evaluation.dto.GetStatusTypeDto(user.statusType)" +
                    " from Us_User user" +
                    " where user.Id = :userId " +
                    " group by user.statusType"
    )
    GetStatusTypeDto getUserStatus(Long userId);
}
