package com.SeniorProject.konutcheck.app.evaluation.converter;

import com.SeniorProject.konutcheck.app.evaluation.dto.LandlordEvaluationDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.LandlordEvaluationSaveDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.TenantEvaluationDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.TenantEvaluationSaveDto;
import com.SeniorProject.konutcheck.app.evaluation.entity.LandlordEvaluation;
import com.SeniorProject.konutcheck.app.evaluation.entity.TenantEvaluation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EvaluationMapperConverter {
    EvaluationMapperConverter INSTANCE = Mappers.getMapper(EvaluationMapperConverter.class);
    LandlordEvaluation convertToLandlordEvaluationFromLandlordEvaluationSaveDto(LandlordEvaluationSaveDto landlordEvaluationSaveDto);
    LandlordEvaluationDto covertToLandlordEvaluationDtoFromLandlordEvaluation(LandlordEvaluation landlordEvaluation);

    TenantEvaluation convertToTenantEvaluationFromTenantEvaluationSaveDto(TenantEvaluationSaveDto tenantEvaluationSaveDto);
    TenantEvaluationDto convertToTenantEvaluationDtoFromTenantEvaluation(TenantEvaluation tenantEvaluation);
}
