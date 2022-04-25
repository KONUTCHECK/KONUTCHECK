package com.SeniorProject.konutcheck.app.evaluation.service;

import com.SeniorProject.konutcheck.app.evaluation.converter.EvaluationMapperConverter;
import com.SeniorProject.konutcheck.app.evaluation.dto.HomesRelatedWithUsersDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.LandlordEvaluationDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.LandlordEvaluationSaveDto;
import com.SeniorProject.konutcheck.app.evaluation.entity.HomesRelatedWithUsers;
import com.SeniorProject.konutcheck.app.evaluation.entity.LandlordEvaluation;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.HomeRelatedWithUsersEntityService;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.LandlordEvaluationEntityService;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.TenantEvaluationEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor

public class Ev_EvaluationService {
    private final LandlordEvaluationEntityService landlordEvaluationEntityService;
    private final TenantEvaluationEntityService tenantEvaluationEntityService;
    private final HomesRelatedWithUsersDto homesRelatedWithUsersDto;
    private final LandlordEvaluationDto landlordEvaluationDto;
    private final HomeRelatedWithUsersEntityService homeRelatedWithUsersEntityService;

    public LandlordEvaluationDto saveLandlordEvaluation(LandlordEvaluationSaveDto landlordEvaluationSaveDto) {
        LandlordEvaluation landlordEvaluation = EvaluationMapperConverter.INSTANCE.convertToLandlordEvaluationFromLandlordEvaluationSaveDto(landlordEvaluationSaveDto);
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
}
/* private Boolean validationOfLandlordId (LandlordEvaluationSaveDto landlordEvaluationSaveDto) {
    Long id = landlordEvaluationSaveDto.getLandlordId();
    Long getTenantId = tenantEvaluationEntityService.getCurrentUser();
    if ( getTenantId == homesRelatedWithUsersDto.getUserId())
    {
        if (homesRelatedWithUsersDto.getUserType().equals( "Tenant"))
        {
            if ( id== homesRelatedWithUsersDto.getUserId()) {
                if ( homesRelatedWithUsersDto.getUserType().equals("Landlord")){

                }
            }
        }
    }
 }
 private Long getTenantHomeId (Long Id){
    Id = homesRelatedWithUsersDto.getUserId();
    boolean isExist = homeRelatedWithUsersEntityService.existById(Id);
     if (isExist && homesRelatedWithUsersDto.getUserType().equals("Tenant"))
     {
         Long homeId=
     }
 }
}
*/