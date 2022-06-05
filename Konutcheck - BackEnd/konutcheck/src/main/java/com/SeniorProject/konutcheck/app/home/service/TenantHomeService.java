package com.SeniorProject.konutcheck.app.home.service;

import com.SeniorProject.konutcheck.app.evaluation.converter.UserRelatedHomesMapperConverter;
import com.SeniorProject.konutcheck.app.home.converter.GeneralHomeInfoMapperConverter;
import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails;
import com.SeniorProject.konutcheck.app.home.dto.TenantHomeDetails;
import com.SeniorProject.konutcheck.app.home.dto.TenantHomeDto;
import com.SeniorProject.konutcheck.app.home.entity.TenantHome;
import com.SeniorProject.konutcheck.app.home.service.entityService.TenantHomeEntityService;
import com.SeniorProject.konutcheck.app.user.enums.StatusType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TenantHomeService {
    private final TenantHomeEntityService tenantHomeEntityService;

    public TenantHomeDto saveTenantHome(Long homeId){
        TenantHome tenantHome = new TenantHome();
        tenantHome.setTenantId(tenantHomeEntityService.getCurrentUser());
        tenantHome.setHomeId(homeId);
        tenantHome.setStatusType(StatusType.Pasif);
        tenantHome = tenantHomeEntityService.save(tenantHome);

        TenantHomeDto tenantHomeDto = GeneralHomeInfoMapperConverter.INSTANCE.convertToTenantHomeDtoFromTenantHome(tenantHome);
        return tenantHomeDto;
    }

    public List<TenantHomeDetails> getTenantHomeList(){
        Long landlordId = tenantHomeEntityService.getCurrentUser();
        List<TenantHomeDetails> tenantHomeDetails = tenantHomeEntityService.getTenantHomeList(landlordId);
        return tenantHomeDetails;
    }

    public List<TenantHomeDetails> getLandlordTenants(){
        Long landlordId = tenantHomeEntityService.getCurrentUser();
        List<TenantHomeDetails> tenantHomeDetails = tenantHomeEntityService.getLandlordTenant(landlordId);
        return tenantHomeDetails;
    }

    public TenantHome saveTenantHomeStatusActive(Long id){
        TenantHome tenantHome = tenantHomeEntityService.getIdWithControl(id);
        tenantHome.setStatusType(StatusType.Aktif);
        tenantHome = tenantHomeEntityService.save(tenantHome);
        return tenantHome;
    }

    public List<Ho_HomeDetails> getTenantAllHomesDetails(){
        Long tenantId = tenantHomeEntityService.getCurrentUser();
        List<Ho_HomeDetails> homeDetailsList = tenantHomeEntityService.getTenantAllHomesDetails(tenantId);
        return homeDetailsList;
    }
}
