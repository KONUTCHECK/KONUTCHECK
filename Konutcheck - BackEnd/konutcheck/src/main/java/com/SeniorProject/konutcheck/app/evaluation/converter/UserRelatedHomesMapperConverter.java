package com.SeniorProject.konutcheck.app.evaluation.converter;

import com.SeniorProject.konutcheck.app.evaluation.dto.*;
import com.SeniorProject.konutcheck.app.evaluation.entity.LandlordRelatedHomes;
import com.SeniorProject.konutcheck.app.evaluation.entity.TenantRelatedHomes;
import com.SeniorProject.konutcheck.app.evaluation.entity.UserRelatedHomes;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRelatedHomesMapperConverter {
    UserRelatedHomesMapperConverter INSTANCE = Mappers.getMapper(UserRelatedHomesMapperConverter.class);
    UserRelatedHomes convertToUserRelatedHomesFromUserRelatedHomesSaveDto(UserRelatedHomesSaveDto userRelatedHomesSaveDto);
    UserRelatedHomesDto convertToUserRelatedHomesDtoFromUserRelatedHomes(UserRelatedHomes userRelatedHomes);

    TenantRelatedHomes convertToTenantRelatedHomesFromTenantRelatedHomesSaveDto(TenantRelatedHomesSaveDto tenantRelatedHomesSaveDto);
    TenantRelatedHomesDto convertToTenantRelatedHomesDtoFromTenantRelatedHomes(TenantRelatedHomes tenantRelatedHomes);
    LandlordRelatedHomes convertToLandlordRelatedHomesFromLandlordRelatedHomesSaveDto(LandlordRelatedHomesSaveDto landlordRelatedHomesSaveDto);
    LandlordRelatedHomesDto convertToLandlordRelatedHomesDtoFromLandlordRelatedHomes(LandlordRelatedHomes landlordRelatedHomes);
}
