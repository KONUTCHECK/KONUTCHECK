package com.SeniorProject.konutcheck.app.evaluation.service;

import com.SeniorProject.konutcheck.app.evaluation.service.entityService.LandlordEvaluationEntityService;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.TenantEvaluationEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Ev_EvaluationService {
    private final LandlordEvaluationEntityService landlordEvaluationEntityService;
    private final TenantEvaluationEntityService tenantEvaluationEntityService;

    /*public LandlordEvaluationDto saveLandlordEvaluation(LandlordEvaluationSaveDto landlordEvaluationSaveDto) {
        LandlordEvaluation landlordEvaluation = EvaluationMapperConverter.INSTANCE.convertToLandlordEvaluationFromLandlordEvaluationSaveDto(landlordEvaluationSaveDto);
       // validationOfId(landlordEvaluationSaveDto);
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
    }*/

   /* private Boolean validationOfId(LandlordEvaluationSaveDto landlordEvaluationSaveDto){
        Long landlordId = landlordEvaluationSaveDto.getLandlordId();

        if(getTenantHomeId() == getLandlordHomeId(landlordId)){
            return true;
        }else{
            throw new ItemNotFoundExceptions(GeneralErrorMessage.HOME_NOT_FOUND);
        }
    }

    private Long getTenantHomeId(){
        Long tenantId = tenantEvaluationEntityService.getCurrentUser();
        Long tenantHomeId = Long.valueOf(0);
        if(tenantId == homesRelatedWithUsersDto.getUserId() && homesRelatedWithUsersDto.getUserType().equals("Tenant")){
            tenantHomeId = homesRelatedWithUsersDto.getHomeId();
        }
        return tenantHomeId;
    }

    private Long getLandlordHomeId(Long landlordId){
        Long landlordHomeId = Long.valueOf(0);
        if(landlordId == homesRelatedWithUsersDto.getUserId() && homesRelatedWithUsersDto.getUserType().equals("Landlord")){
            landlordHomeId = homesRelatedWithUsersDto.getHomeId();
        }
        return landlordHomeId;
    }*/
}