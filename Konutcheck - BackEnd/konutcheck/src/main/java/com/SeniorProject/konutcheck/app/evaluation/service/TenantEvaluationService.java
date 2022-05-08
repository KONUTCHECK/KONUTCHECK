package com.SeniorProject.konutcheck.app.evaluation.service;

import com.SeniorProject.konutcheck.app.evaluation.converter.EvaluationMapperConverter;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto;

import com.SeniorProject.konutcheck.app.evaluation.dto.GetTotalPoint;
import com.SeniorProject.konutcheck.app.evaluation.dto.TenantEvaluationDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.TenantEvaluationSaveDto;
import com.SeniorProject.konutcheck.app.evaluation.entity.TenantEvaluation;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.LandlordRelatedHomesEntityService;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.TenantEvaluationEntityService;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.TenantRelatedHomesEntityService;
import com.SeniorProject.konutcheck.app.general.exceptionEnums.GeneralErrorMessage;
import com.SeniorProject.konutcheck.app.general.exceptions.InvalidInformationExceptions;
import com.SeniorProject.konutcheck.app.securityGeneral.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TenantEvaluationService {
    private final TenantEvaluationEntityService tenantEvaluationEntityService;
    private final AuthenticationService authenticationService;

    private final TenantRelatedHomesEntityService tenantRelatedHomesEntityService;
    private final LandlordRelatedHomesEntityService landlordRelatedHomesEntityService;

    public List<GetTotalPoint> getTotalPointOfTenant(Long id){
        List<GetTotalPoint> getTotalPointList = tenantEvaluationEntityService.getTotalPoint(id);
        return getTotalPointList;
    }

    public TenantEvaluationDto saveTenantEvaluation(TenantEvaluationSaveDto tenantEvaluationSaveDto){
         TenantEvaluation tenantEvaluation = EvaluationMapperConverter.INSTANCE.convertToTenantEvaluationFromTenantEvaluationSaveDto(tenantEvaluationSaveDto);
         Long currentUserId = authenticationService.getCurrentUserId();
         validationOfHomeId(currentUserId);
         tenantEvaluation.setEvaluationOwnerLandlordId(currentUserId);
         tenantEvaluation.setTenantPoint(calculateTenantSinglePoint(tenantEvaluationSaveDto));
         tenantEvaluation = tenantEvaluationEntityService.save(tenantEvaluation);
         TenantEvaluationDto tenantEvaluationDto = EvaluationMapperConverter.INSTANCE.convertToTenantEvaluationDtoFromTenantEvaluation(tenantEvaluation);
         return tenantEvaluationDto;
    }

    private BigDecimal calculateTenantSinglePoint(TenantEvaluationSaveDto tenantEvaluationSaveDto){
        int gradeOfRentPayment = tenantEvaluationSaveDto.getGradeOfRentPayment();
        int gradeOfBillPayment = tenantEvaluationSaveDto.getGradeOfBillPayment();
        int gradeOfTenantSatisfaction = tenantEvaluationSaveDto.getGradeOfTenantSatisfaction();
        int gradeOfTenantNeighborliness = tenantEvaluationSaveDto.getGradeOfTenantNeighborliness();
        int getGradeOfTenantHomeTreat = tenantEvaluationSaveDto.getGetGradeOfTenantHomeTreat();
        int sum = gradeOfRentPayment + gradeOfBillPayment + gradeOfTenantSatisfaction + gradeOfTenantNeighborliness + getGradeOfTenantHomeTreat;
        BigDecimal singlePoint = BigDecimal.valueOf(sum / 5);
        return singlePoint;
    }

    private Boolean validationOfHomeId(Long id){
        GetHomeIdDto homeId = tenantRelatedHomesEntityService.getHomeIdByLandlordId(id);
        Boolean isHomeIdExist = landlordRelatedHomesEntityService.isHomeIdExist(homeId.getHomeId());

        if(isHomeIdExist){
            return true;
        }else {
            throw new InvalidInformationExceptions(GeneralErrorMessage.ID_NOT_MATCH);
        }
    }

}
