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
import com.SeniorProject.konutcheck.app.general.exceptions.ItemNotFoundExceptions;
import com.SeniorProject.konutcheck.app.securityGeneral.service.AuthenticationService;
import com.SeniorProject.konutcheck.app.user.service.entityService.Us_UserEntityService;
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
    private final Us_UserEntityService userEntityService;

    public List<GetTotalPoint> getTotalPointOfTenant(Long id) {
        List<GetTotalPoint> getTotalPointList = tenantEvaluationEntityService.getTotalPoint(id);
        return getTotalPointList;
    }

    public TenantEvaluationDto saveTenantEvaluation(TenantEvaluationSaveDto tenantEvaluationSaveDto, Long tenantId) {
        TenantEvaluation tenantEvaluation = EvaluationMapperConverter.INSTANCE.convertToTenantEvaluationFromTenantEvaluationSaveDto(tenantEvaluationSaveDto);
        Long currentUserId = authenticationService.getCurrentUserId();
        tenantEvaluation.setEvaluationOwnerLandlordId(currentUserId);
        tenantEvaluation.setTenantId(tenantId);
        tenantEvaluation.setTenantPoint(calculateTenantSinglePoint(tenantEvaluationSaveDto));
        tenantEvaluation = tenantEvaluationEntityService.save(tenantEvaluation);
        TenantEvaluationDto tenantEvaluationDto = EvaluationMapperConverter.INSTANCE.convertToTenantEvaluationDtoFromTenantEvaluation(tenantEvaluation);
        return tenantEvaluationDto;
    }

    private BigDecimal calculateTenantSinglePoint(TenantEvaluationSaveDto tenantEvaluationSaveDto) {
        validationGradeOfRentPayment(tenantEvaluationSaveDto);
        int gradeOfRentPayment = tenantEvaluationSaveDto.getGradeOfRentPayment();

        validationGradeOfBillPayment(tenantEvaluationSaveDto);
        int gradeOfBillPayment = tenantEvaluationSaveDto.getGradeOfBillPayment();

        validationGradeOfTenantSatisfaction(tenantEvaluationSaveDto);
        int gradeOfTenantSatisfaction = tenantEvaluationSaveDto.getGradeOfTenantSatisfaction();

        validationGradeOfTenantNeighborliness(tenantEvaluationSaveDto);
        int gradeOfTenantNeighborliness = tenantEvaluationSaveDto.getGradeOfTenantNeighborliness();

        validationGradeOfTenantHomeTreat(tenantEvaluationSaveDto);
        int getGradeOfTenantHomeTreat = tenantEvaluationSaveDto.getGradeOfTenantHomeTreat();

        int sum = gradeOfRentPayment + gradeOfBillPayment + gradeOfTenantSatisfaction + gradeOfTenantNeighborliness + getGradeOfTenantHomeTreat;
        BigDecimal singlePoint = BigDecimal.valueOf(sum / 5);
        return singlePoint;
    }

    /*private Boolean validationOfHomeId(Long id) {
        GetHomeIdDto homeId = tenantRelatedHomesEntityService.getHomeIdByLandlordId(id);
        Boolean isHomeIdExist = landlordRelatedHomesEntityService.isHomeIdExist(homeId.getHomeId());

        if (isHomeIdExist) {
            return true;
        } else {
            throw new InvalidInformationExceptions(GeneralErrorMessage.ID_NOT_MATCH);
        }
    }*/

    private Long getTenantId() {
        GetHomeIdDto tenantId = tenantEvaluationEntityService.getTenantId();
        Boolean isTenantIdExist = userEntityService.existById(tenantId.getHomeId());

        if (isTenantIdExist) {
            return tenantId.getHomeId();
        } else {
            throw new ItemNotFoundExceptions(GeneralErrorMessage.ID_NOT_FOUND);
        }
    }

    private Boolean validationGradeOfRentPayment(TenantEvaluationSaveDto tenantEvaluationSaveDto){
        if (tenantEvaluationSaveDto.getGradeOfRentPayment() > 0 && tenantEvaluationSaveDto.getGradeOfRentPayment() < 6){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }

    private Boolean validationGradeOfBillPayment(TenantEvaluationSaveDto tenantEvaluationSaveDto){
        if (tenantEvaluationSaveDto.getGradeOfBillPayment() > 0 && tenantEvaluationSaveDto.getGradeOfBillPayment() < 6){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }

    private Boolean validationGradeOfTenantSatisfaction(TenantEvaluationSaveDto tenantEvaluationSaveDto){
        if (tenantEvaluationSaveDto.getGradeOfTenantSatisfaction() > 0 && tenantEvaluationSaveDto.getGradeOfTenantSatisfaction() < 6){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }

    private Boolean validationGradeOfTenantNeighborliness(TenantEvaluationSaveDto tenantEvaluationSaveDto){
        if (tenantEvaluationSaveDto.getGradeOfTenantNeighborliness() > 0 && tenantEvaluationSaveDto.getGradeOfTenantNeighborliness() < 6 ){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }

    private Boolean validationGradeOfTenantHomeTreat(TenantEvaluationSaveDto tenantEvaluationSaveDto){
        if (tenantEvaluationSaveDto.getGradeOfTenantHomeTreat() > 0 && tenantEvaluationSaveDto.getGradeOfTenantHomeTreat() < 6){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }

}


