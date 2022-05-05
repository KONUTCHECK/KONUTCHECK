package com.SeniorProject.konutcheck.app.evaluation.service;

import com.SeniorProject.konutcheck.app.evaluation.converter.UserRelatedHomesMapperConverter;
import com.SeniorProject.konutcheck.app.evaluation.dto.TenantEvaluationSaveDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.TenantRelatedHomesDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.TenantRelatedHomesSaveDto;
import com.SeniorProject.konutcheck.app.evaluation.entity.TenantRelatedHomes;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.TenantRelatedHomesEntityService;
import com.SeniorProject.konutcheck.app.securityGeneral.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenantRelatedHomesService {
    private final TenantRelatedHomesEntityService tenantRelatedHomesEntityService;
    private final AuthenticationService authenticationService;

    public TenantRelatedHomesDto save(TenantRelatedHomesSaveDto tenantRelatedHomesSaveDto){
        Long tenantId = authenticationService.getCurrentUserId();
        TenantRelatedHomes tenantRelatedHomes = UserRelatedHomesMapperConverter.INSTANCE.convertToTenantRelatedHomesFromTenantRelatedHomesSaveDto(tenantRelatedHomesSaveDto);
        tenantRelatedHomes.setTenantId(tenantId);
        tenantRelatedHomes = tenantRelatedHomesEntityService.save(tenantRelatedHomes);

        TenantRelatedHomesDto tenantRelatedHomesDto = UserRelatedHomesMapperConverter.INSTANCE.convertToTenantRelatedHomesDtoFromTenantRelatedHomes(tenantRelatedHomes);
        return tenantRelatedHomesDto;
    }
}
