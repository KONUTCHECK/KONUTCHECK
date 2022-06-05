package com.SeniorProject.konutcheck.app.home.converter;

import com.SeniorProject.konutcheck.app.home.dto.GeneralHomeInfoDto;
import com.SeniorProject.konutcheck.app.home.dto.GeneralHomeInfoSaveDto;
import com.SeniorProject.konutcheck.app.home.dto.TenantHomeDto;
import com.SeniorProject.konutcheck.app.home.entity.GeneralHomeInfo;
import com.SeniorProject.konutcheck.app.home.entity.TenantHome;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GeneralHomeInfoMapperConverter {

    GeneralHomeInfoMapperConverter INSTANCE = Mappers.getMapper(GeneralHomeInfoMapperConverter.class);
    GeneralHomeInfo convertToGeneralHomeInfoFromGeneralHomeInfoSaveDto(GeneralHomeInfoSaveDto generalHomeInfoSaveDto);
    GeneralHomeInfoDto convertToGeneralHomeInfoDtoFromGeneralHomeInfo(GeneralHomeInfo generalHomeInfo);
    GeneralHomeInfo convertToGeneralHomeInfoFromGeneralHomeInfoDto(GeneralHomeInfoDto generalHomeInfoDto);
    List<GeneralHomeInfoDto> convertToGeneralHomeInfoDtoListFromGeneralHomeInfoList(List<GeneralHomeInfo> generalHomeInfos);
    TenantHomeDto convertToTenantHomeDtoFromTenantHome(TenantHome tenantHome);

}
