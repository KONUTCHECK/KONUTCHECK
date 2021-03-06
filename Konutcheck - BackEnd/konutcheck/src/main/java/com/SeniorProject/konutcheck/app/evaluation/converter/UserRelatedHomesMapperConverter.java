package com.SeniorProject.konutcheck.app.evaluation.converter;

import com.SeniorProject.konutcheck.app.evaluation.dto.*;
import com.SeniorProject.konutcheck.app.evaluation.entity.LandlordRelatedHomes;
import com.SeniorProject.konutcheck.app.evaluation.entity.TenantRelatedHomes;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRelatedHomesMapperConverter {
    UserRelatedHomesMapperConverter INSTANCE = Mappers.getMapper(UserRelatedHomesMapperConverter.class);
    TenantRelatedHomes convertToTenantRelatedHomesFromTenantRelatedHomesSaveDto(TenantRelatedHomesSaveDto tenantRelatedHomesSaveDto);
    TenantRelatedHomesDto convertToTenantRelatedHomesDtoFromTenantRelatedHomes(TenantRelatedHomes tenantRelatedHomes);
    LandlordRelatedHomes convertToLandlordRelatedHomesFromLandlordRelatedHomesSaveDto(LandlordRelatedHomesSaveDto landlordRelatedHomesSaveDto);
    LandlordRelatedHomesDto convertToLandlordRelatedHomesDtoFromLandlordRelatedHomes(LandlordRelatedHomes landlordRelatedHomes);
    List<TenantRelatedHomesDto> convertToTenantRelatedHomeDtoListFromTenantRelatedHomeList(List<TenantRelatedHomes> tenantRelatedHomesList);
}
