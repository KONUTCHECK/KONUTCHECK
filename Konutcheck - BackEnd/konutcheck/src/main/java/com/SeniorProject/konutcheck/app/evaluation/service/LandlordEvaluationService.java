package com.SeniorProject.konutcheck.app.evaluation.service;

import com.SeniorProject.konutcheck.app.evaluation.converter.EvaluationMapperConverter;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto;
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

@Service
@RequiredArgsConstructor
public class LandlordEvaluationService {
    private final LandlordEvaluationEntityService landlordEvaluationEntityService;
    private final AuthenticationService authenticationService;
    private ArrayList<BigDecimal> landlordPoints = new ArrayList<>();

    private final TenantRelatedHomesEntityService tenantRelatedHomesEntityService;
    private final LandlordRelatedHomesEntityService landlordRelatedHomesEntityService;

    public LandlordEvaluationDto saveLandlordEvaluation(LandlordEvaluationSaveDto landlordEvaluationSaveDto) {
        LandlordEvaluation landlordEvaluation = EvaluationMapperConverter.INSTANCE.convertToLandlordEvaluationFromLandlordEvaluationSaveDto(landlordEvaluationSaveDto);
        Long currentUserId = authenticationService.getCurrentUserId();
        validationOfHomeId(landlordEvaluationSaveDto);
        landlordEvaluation.setEvaluationOwnerTenantId(currentUserId);
        landlordEvaluation.setLandlordPoint(calculationLandlordSinglePoint(landlordEvaluationSaveDto));
        landlordEvaluation = landlordEvaluationEntityService.save(landlordEvaluation);
        LandlordEvaluationDto landlordEvaluationDto = EvaluationMapperConverter.INSTANCE.covertToLandlordEvaluationDtoFromLandlordEvaluation(landlordEvaluation);
        return landlordEvaluationDto;
    }

    private BigDecimal calculationLandlordSinglePoint(LandlordEvaluationSaveDto landlordEvaluationSaveDto) {
        //validationOfGrades(landlordEvaluationSaveDto);
        int gradeOfLandlordSatisfaction = landlordEvaluationSaveDto.getGradeOfLandlordSatisfaction();
        int gradeOfLandlordTreatment = landlordEvaluationSaveDto.getGradeOfLandlordTreatment();
        int gradeOfLandlordAccessibility = landlordEvaluationSaveDto.getGradeOfLandlordAccessibility();
        int gradeOfLandlordUnderstanding = landlordEvaluationSaveDto.getGradeOfLandlordUnderstanding();
        int sum = gradeOfLandlordSatisfaction + gradeOfLandlordTreatment + gradeOfLandlordAccessibility + gradeOfLandlordUnderstanding;
        BigDecimal singleEvaluation = BigDecimal.valueOf(sum / 4);
        landlordPoints.add(singleEvaluation);
        return singleEvaluation;
    }

    private BigDecimal calculateLandlordTotalPoint(){
        int count = 0;
        BigDecimal sum = BigDecimal.ZERO;

        for(BigDecimal point : landlordPoints){
            sum.add(point);
            count++;
        }

        BigDecimal landlordTotalPoint = sum.divide(BigDecimal.valueOf(count));
        return landlordTotalPoint;
    }

    /*private Boolean validationOfHomeId(LandlordEvaluationSaveDto landlordEvaluationSaveDto){
        GetHomeIdDto landlordHomeId = landlordEvaluationEntityService.getHomeIdWithLandlordId(landlordEvaluationSaveDto.getLandlordId());
        GetHomeIdDto tenantHomeId = landlordEvaluationEntityService.getHomeIdWithTenantId(landlordEvaluationEntityService.getCurrentUser());

        if(landlordHomeId.getHomeId() == tenantHomeId.getHomeId()){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.ID_NOT_MATCH);
        }
    }*/

    private Boolean validationOfHomeId(LandlordEvaluationSaveDto landlordEvaluationSaveDto){
        GetHomeIdDto homeId = tenantRelatedHomesEntityService.getHomeIdByLandlordId(landlordEvaluationSaveDto.getLandlordId());
        //GetHomeIdDto landlordHomeId = landlordEvaluationEntityService.getHomeIdWithLandlordId(landlordEvaluationSaveDto.getLandlordId());
        //GetHomeIdDto tenantHomeId = landlordEvaluationEntityService.getHomeIdWithTenantId(landlordEvaluationEntityService.getCurrentUser());
        Boolean isHomeIdExist = landlordRelatedHomesEntityService.isHomeIdExist(homeId.getHomeId());

       /* if(landlordHomeId.getHomeId() == tenantHomeId.getHomeId()){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.ID_NOT_MATCH);
        }*/

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