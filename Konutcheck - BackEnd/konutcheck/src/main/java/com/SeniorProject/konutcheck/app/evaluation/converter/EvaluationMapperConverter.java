package com.SeniorProject.konutcheck.app.evaluation.converter;

import com.SeniorProject.konutcheck.app.evaluation.dto.*;
import com.SeniorProject.konutcheck.app.evaluation.entity.HomeEvaluation;
import com.SeniorProject.konutcheck.app.evaluation.entity.LandlordEvaluation;
import com.SeniorProject.konutcheck.app.evaluation.entity.TenantEvaluation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EvaluationMapperConverter {
    EvaluationMapperConverter INSTANCE = Mappers.getMapper(EvaluationMapperConverter.class);
    LandlordEvaluation convertToLandlordEvaluationFromLandlordEvaluationSaveDto(LandlordEvaluationSaveDto landlordEvaluationSaveDto);
    LandlordEvaluationDto convertToLandlordEvaluationDtoFromLandlordEvaluation(LandlordEvaluation landlordEvaluation);
    HomeEvaluation convertToHomeEvaluationFromHomeEvaluationSaveDto(HomeEvaluationSaveDto homeEvaluationSaveDto);
    HomeEvaluationDto convertToHomeEvaluationDtoFromHomeEvaluation(HomeEvaluation homeEvaluation);

    TenantEvaluation convertToTenantEvaluationFromTenantEvaluationSaveDto(TenantEvaluationSaveDto tenantEvaluationSaveDto);
    TenantEvaluationDto convertToTenantEvaluationDtoFromTenantEvaluation(TenantEvaluation tenantEvaluation);
}
