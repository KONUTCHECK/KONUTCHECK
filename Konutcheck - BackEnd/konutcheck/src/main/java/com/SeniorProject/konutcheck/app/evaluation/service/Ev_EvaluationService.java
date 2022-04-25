package com.SeniorProject.konutcheck.app.evaluation.service;

import com.SeniorProject.konutcheck.app.evaluation.converter.EvaluationMapperConverter;
import com.SeniorProject.konutcheck.app.evaluation.dto.GetHomeIdDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.LandlordEvaluationDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.LandlordEvaluationSaveDto;
import com.SeniorProject.konutcheck.app.evaluation.entity.LandlordEvaluation;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.LandlordEvaluationEntityService;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.TenantEvaluationEntityService;
import com.SeniorProject.konutcheck.app.general.exceptionEnums.GeneralErrorMessage;
import com.SeniorProject.konutcheck.app.general.exceptions.InvalidInformationExceptions;
import com.SeniorProject.konutcheck.app.securityGeneral.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class Ev_EvaluationService {
    private final LandlordEvaluationEntityService landlordEvaluationEntityService;
    private final TenantEvaluationEntityService tenantEvaluationEntityService;
    private final AuthenticationService authenticationService;

    public LandlordEvaluationDto saveLandlordEvaluation(LandlordEvaluationSaveDto landlordEvaluationSaveDto) {
        LandlordEvaluation landlordEvaluation = EvaluationMapperConverter.INSTANCE.convertToLandlordEvaluationFromLandlordEvaluationSaveDto(landlordEvaluationSaveDto);
        validationOfId(landlordEvaluationSaveDto);
        landlordEvaluation.setEvaluationOwnerTenantId(authenticationService.getCurrentUserId());
        landlordEvaluation.setLandlordPoint(calculationLandlordPoint(landlordEvaluationSaveDto));
        landlordEvaluation = landlordEvaluationEntityService.save(landlordEvaluation);
        LandlordEvaluationDto landlordEvaluationDto = EvaluationMapperConverter.INSTANCE.covertToLandlordEvaluationDtoFromLandlordEvaluation(landlordEvaluation);
        return landlordEvaluationDto;
    }

    private BigDecimal calculationLandlordPoint(LandlordEvaluationSaveDto landlordEvaluationSaveDto) {
        int gradeOfLandlordSatisfaction = landlordEvaluationSaveDto.getGradeOfLandlordSatisfaction();
        int gradeOfLandlordTreatment = landlordEvaluationSaveDto.getGradeOfLandlordTreatment();
        int gradeOfLandlordAccessibility = landlordEvaluationSaveDto.getGradeOfLandlordAccessibility();
        int gradeOfLandlordUnderstanding = landlordEvaluationSaveDto.getGradeOfLandlordUnderstanding();
        int sum = gradeOfLandlordSatisfaction + gradeOfLandlordTreatment + gradeOfLandlordAccessibility + gradeOfLandlordUnderstanding;
        BigDecimal avg = BigDecimal.valueOf(sum / 4);
        return avg;
    }

   private Boolean validationOfId(LandlordEvaluationSaveDto landlordEvaluationSaveDto){
        GetHomeIdDto landlordHomeId = landlordEvaluationEntityService.getHomeIdWithLandlordId(landlordEvaluationSaveDto.getLandlordId());
        GetHomeIdDto tenantHomeId = landlordEvaluationEntityService.getHomeIdWithTenantId(landlordEvaluationEntityService.getCurrentUser());

        if(landlordHomeId.getHomeId() == tenantHomeId.getHomeId()){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.ID_NOT_MATCH);
        }
    }
}