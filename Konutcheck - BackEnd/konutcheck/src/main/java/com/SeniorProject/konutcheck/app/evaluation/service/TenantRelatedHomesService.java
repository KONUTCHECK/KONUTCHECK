package com.SeniorProject.konutcheck.app.evaluation.service;

import com.SeniorProject.konutcheck.app.evaluation.converter.UserRelatedHomesMapperConverter;
import com.SeniorProject.konutcheck.app.evaluation.dto.TenantEvaluationSaveDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.TenantRelatedHomesDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.TenantRelatedHomesSaveDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.UserHomeDetails;
import com.SeniorProject.konutcheck.app.evaluation.entity.TenantRelatedHomes;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.TenantRelatedHomesEntityService;
import com.SeniorProject.konutcheck.app.general.exceptionEnums.GeneralErrorMessage;
import com.SeniorProject.konutcheck.app.general.exceptions.ItemNotFoundExceptions;
import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDetails;
import com.SeniorProject.konutcheck.app.home.service.entityService.Ho_HomeEntityService;
import com.SeniorProject.konutcheck.app.securityGeneral.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TenantRelatedHomesService {
    private final TenantRelatedHomesEntityService tenantRelatedHomesEntityService;
    private final AuthenticationService authenticationService;
    private final Ho_HomeEntityService hoHomeEntityService;

    public TenantRelatedHomesDto save(TenantRelatedHomesSaveDto tenantRelatedHomesSaveDto){
        Long tenantId = authenticationService.getCurrentUserId();
        TenantRelatedHomes tenantRelatedHomes = UserRelatedHomesMapperConverter.INSTANCE.convertToTenantRelatedHomesFromTenantRelatedHomesSaveDto(tenantRelatedHomesSaveDto);
        tenantRelatedHomes.setTenantId(tenantId);
        tenantRelatedHomes = tenantRelatedHomesEntityService.save(tenantRelatedHomes);

        TenantRelatedHomesDto tenantRelatedHomesDto = UserRelatedHomesMapperConverter.INSTANCE.convertToTenantRelatedHomesDtoFromTenantRelatedHomes(tenantRelatedHomes);
        return tenantRelatedHomesDto;
    }

    public List<UserHomeDetails> getTenantHomeDetails(Long id){
        List<UserHomeDetails> userHomeDetailsList = tenantRelatedHomesEntityService.getHomeDetailsByTenantId(id);
        return userHomeDetailsList;
    }

}
