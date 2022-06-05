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
import com.SeniorProject.konutcheck.app.general.exceptions.ItemNotFoundExceptions;
import com.SeniorProject.konutcheck.app.securityGeneral.service.AuthenticationService;
import com.SeniorProject.konutcheck.app.user.service.entityService.Us_UserEntityService;
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

    public List<GetTotalPoint> getTotalPointOfLandlord(Long id){
        List<GetTotalPoint> getTotalPointList = landlordEvaluationEntityService.getTotalPoint(id);
        return getTotalPointList;
    }

    public LandlordEvaluationDto saveLandlordEvaluation(LandlordEvaluationSaveDto landlordEvaluationSaveDto) {
        validationOfIsEvaluationOwnerIdExist();
        LandlordEvaluation landlordEvaluation = EvaluationMapperConverter.INSTANCE.convertToLandlordEvaluationFromLandlordEvaluationSaveDto(landlordEvaluationSaveDto);
        Long currentUserId = authenticationService.getCurrentUserId();
        landlordEvaluation.setEvaluationOwnerTenantId(currentUserId);
        landlordEvaluation.setLandlordId(getLandlordId());
        landlordEvaluation.setLandlordPoint(calculateLandlordSinglePoint(landlordEvaluationSaveDto));
        landlordEvaluation = landlordEvaluationEntityService.save(landlordEvaluation);
        LandlordEvaluationDto landlordEvaluationDto = EvaluationMapperConverter.INSTANCE.convertToLandlordEvaluationDtoFromLandlordEvaluation(landlordEvaluation);
        return landlordEvaluationDto;
    }

    private BigDecimal calculateLandlordSinglePoint(LandlordEvaluationSaveDto landlordEvaluationSaveDto) {
        validationGradeOfLandlordSatisfaction(landlordEvaluationSaveDto);
        int gradeOfLandlordSatisfaction = landlordEvaluationSaveDto.getGradeOfLandlordSatisfaction();

        validationGradeOfLandlordTreatment(landlordEvaluationSaveDto);
        int gradeOfLandlordTreatment = landlordEvaluationSaveDto.getGradeOfLandlordTreatment();

        validationGradeOfLandlordAccessibility(landlordEvaluationSaveDto);
        int gradeOfLandlordAccessibility = landlordEvaluationSaveDto.getGradeOfLandlordAccessibility();

        validationGradeOfLandlordUnderstanding(landlordEvaluationSaveDto);
        int gradeOfLandlordUnderstanding = landlordEvaluationSaveDto.getGradeOfLandlordUnderstanding();

        int sum = gradeOfLandlordSatisfaction + gradeOfLandlordTreatment + gradeOfLandlordAccessibility + gradeOfLandlordUnderstanding;
        BigDecimal singlePoint = BigDecimal.valueOf(sum / 4);
        return singlePoint;
    }

    private Long getLandlordId(){
        GetHomeIdDto landlordId = landlordEvaluationEntityService.getLandlordId();
        Boolean isLandlordExist = landlordEvaluationEntityService.existById(landlordId.getHomeId());

        if(isLandlordExist){
            return landlordId.getHomeId();
        }else{
            throw new ItemNotFoundExceptions(GeneralErrorMessage.ID_NOT_FOUND);
        }
    }

    private Boolean validationOfIsEvaluationOwnerIdExist(){
        Long id = landlordEvaluationEntityService.getCurrentUser();
        Boolean isExist = landlordEvaluationEntityService.isExistEvaluationOwnerTenantId(id);

        if(!isExist){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.EVALUATION_WAS_MADE);
        }
    }

    private Boolean validationGradeOfLandlordSatisfaction(LandlordEvaluationSaveDto landlordEvaluationSaveDto){
        if(landlordEvaluationSaveDto.getGradeOfLandlordSatisfaction() > 0 && landlordEvaluationSaveDto.getGradeOfLandlordSatisfaction() < 6){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }

    private Boolean validationGradeOfLandlordAccessibility(LandlordEvaluationSaveDto landlordEvaluationSaveDto){
        if(landlordEvaluationSaveDto.getGradeOfLandlordAccessibility() > 0 && landlordEvaluationSaveDto.getGradeOfLandlordAccessibility() < 6){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }

    private Boolean validationGradeOfLandlordTreatment(LandlordEvaluationSaveDto landlordEvaluationSaveDto){
        if(landlordEvaluationSaveDto.getGradeOfLandlordTreatment() > 0 && landlordEvaluationSaveDto.getGradeOfLandlordTreatment() < 6){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }

    private Boolean validationGradeOfLandlordUnderstanding(LandlordEvaluationSaveDto landlordEvaluationSaveDto){
        if(landlordEvaluationSaveDto.getGradeOfLandlordUnderstanding() > 0 && landlordEvaluationSaveDto.getGradeOfLandlordUnderstanding() < 6){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.INVALID_GRADE);
        }
    }
}