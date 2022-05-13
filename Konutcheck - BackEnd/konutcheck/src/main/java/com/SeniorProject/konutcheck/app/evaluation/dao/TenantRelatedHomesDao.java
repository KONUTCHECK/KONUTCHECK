package com.SeniorProject.konutcheck.app.evaluation.dao;

import com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.UserHomeDetails;
import com.SeniorProject.konutcheck.app.evaluation.entity.TenantRelatedHomes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantRelatedHomesDao extends JpaRepository<TenantRelatedHomes, Long> {
    @Query(
            value = "select new com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto(tenantRelatedHomes.homeId)" +
                    " from TenantRelatedHomes tenantRelatedHomes" +
                    " where tenantRelatedHomes.landlordId = :id" +
                    " group by tenantRelatedHomes.homeId"
    )
    GetHomeIdDto getHomeIdByLandlordId(Long id);

    @Query(
            value = "select new com.SeniorProject.konutcheck.app.evaluation.dto.UserHomeDetails(hoHome.Id, tenantRelatedHomes.tenantId, generalHomeInfo.homeType, generalHomeInfo.amount, generalHomeInfo.deposit, generalHomeInfo.dues, generalHomeInfo.numberOfRooms, generalHomeInfo.warningSystem, generalHomeInfo.buildingAge, generalHomeInfo.homeAspect, generalHomeInfo.floor, generalHomeInfo.homeSize, homeAddress.country, homeAddress.city, homeAddress.district, homeAddress.neighborhood, homeAddress.street, homeAddress.buildingNo, homeAddress.apartmentNo, hoHome.announcementDate)" +
                    " from TenantRelatedHomes tenantRelatedHomes" +
                    " left join GeneralHomeInfo generalHomeInfo on generalHomeInfo.id = tenantRelatedHomes.homeId" +
                    " left join Ho_Home hoHome on hoHome.generalHomeInfoId = generalHomeInfo.id" +
                    " left join HomeAddress homeAddress on hoHome.homeAddressId = homeAddress.id " +
                    " where tenantRelatedHomes.tenantId = :tenantId"
    )
    List<UserHomeDetails> getHomeDetailsByTenantId(Long tenantId);
}
