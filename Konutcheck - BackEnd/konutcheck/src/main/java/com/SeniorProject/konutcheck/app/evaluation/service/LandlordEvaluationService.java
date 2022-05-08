package com.SeniorProject.konutcheck.app.evaluation.service;

import com.SeniorProject.konutcheck.app.evaluation.converter.EvaluationMapperConverter;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetTotalPoint;
import com.SeniorProject.konutcheck.app.evaluation.dto.LandlordEvaluationDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.LandlordEvaluationSaveDto;
import com.SeniorProject.konutcheck.app.evaluation.entity.LandlordEvaluation;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.LandlordEvaluationEntityService;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.LandlordRelatedHomesEntityService;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.TenantEvaluationEntityService;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.TenantRelatedHomesEntityService;
import com.SeniorProject.konutcheck.app.general.exceptionEnums.GeneralErrorMessage;
import com.SeniorProject.konutcheck.app.general.exceptions.InvalidInformationExceptions;
import com.SeniorProject.konutcheck.app.securityGeneral.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LandlordEvaluationService {
    private final LandlordEvaluationEntityService landlordEvaluationEntityService;
    private final AuthenticationService authenticationService;

    private final TenantRelatedHomesEntityService tenantRelatedHomesEntityService;
    private final LandlordRelatedHomesEntityService landlordRelatedHomesEntityService;

    public List<GetTotalPoint> getTotalPointOfLandlord(Long id){
        List<GetTotalPoint> getTotalPointList = landlordEvaluationEntityService.getTotalPoint(id);
        return getTotalPointList;
    }

    public LandlordEvaluationDto saveLandlordEvaluation(LandlordEvaluationSaveDto landlordEvaluationSaveDto) {
        LandlordEvaluation landlordEvaluation = EvaluationMapperConverter.INSTANCE.convertToLandlordEvaluationFromLandlordEvaluationSaveDto(landlordEvaluationSaveDto);
        Long currentUserId = authenticationService.getCurrentUserId();
        validationOfHomeId(landlordEvaluationSaveDto);
        landlordEvaluation.setEvaluationOwnerTenantId(currentUserId);
        landlordEvaluation.setLandlordPoint(calculateLandlordSinglePoint(landlordEvaluationSaveDto));
        landlordEvaluation = landlordEvaluationEntityService.save(landlordEvaluation);
        LandlordEvaluationDto landlordEvaluationDto = EvaluationMapperConverter.INSTANCE.covertToLandlordEvaluationDtoFromLandlordEvaluation(landlordEvaluation);
        return landlordEvaluationDto;
    }

    private BigDecimal calculateLandlordSinglePoint(LandlordEvaluationSaveDto landlordEvaluationSaveDto) {
       // validationOfGrades(landlordEvaluationSaveDto);
        int gradeOfLandlordSatisfaction = landlordEvaluationSaveDto.getGradeOfLandlordSatisfaction();
        int gradeOfLandlordTreatment = landlordEvaluationSaveDto.getGradeOfLandlordTreatment();
        int gradeOfLandlordAccessibility = landlordEvaluationSaveDto.getGradeOfLandlordAccessibility();
        int gradeOfLandlordUnderstanding = landlordEvaluationSaveDto.getGradeOfLandlordUnderstanding();
        int sum = gradeOfLandlordSatisfaction + gradeOfLandlordTreatment + gradeOfLandlordAccessibility + gradeOfLandlordUnderstanding;
        BigDecimal singlePoint = BigDecimal.valueOf(sum / 4);
        return singlePoint;
    }

    private Boolean validationOfHomeId(LandlordEvaluationSaveDto landlordEvaluationSaveDto){
        GetHomeIdDto homeId = tenantRelatedHomesEntityService.getHomeIdByLandlordId(landlordEvaluationSaveDto.getLandlordId());
        Boolean isHomeIdExist = landlordRelatedHomesEntityService.isHomeIdExist(homeId.getHomeId());

        if(isHomeIdExist){
            return true;
        }else {
            throw new InvalidInformationExceptions(GeneralErrorMessage.ID_NOT_MATCH);
        }
    }

    private Boolean validationOfGrades(LandlordEvaluationSaveDto landlordEvaluationSaveDto){
        if(landlordEvaluationSaveDto.getGradeOfLandlordSatisfaction() < 0 || landlordEvaluationSaveDto.getGradeOfLandlordSatisfaction() > 5
        && landlordEvaluationSaveDto.getGradeOfLandlordAccessibility() < 0 || landlordEvaluationSaveDto.getGradeOfLandlordAccessibility() > 5
        && landlordEvaluationSaveDto.getGradeOfLandlordTreatment() < 0 || landlordEvaluationSaveDto.getGradeOfLandlordTreatment() > 5
        && landlordEvaluationSaveDto.getGradeOfLandlordUnderstanding() < 0 || landlordEvaluationSaveDto.getGradeOfLandlordUnderstanding() > 5)
        {
            return false;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }
}