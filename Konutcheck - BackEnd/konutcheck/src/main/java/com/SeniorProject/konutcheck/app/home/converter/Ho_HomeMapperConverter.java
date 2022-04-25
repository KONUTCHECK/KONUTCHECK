package com.SeniorProject.konutcheck.app.home.converter;

import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDto;
import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeSaveDto;
import com.SeniorProject.konutcheck.app.home.entity.Ho_Home;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface Ho_HomeMapperConverter {
    Ho_HomeMapperConverter INSTANCE = Mappers.getMapper(Ho_HomeMapperConverter.class);
    Ho_Home convertToHoHomeFromHoHomeSaveDto(Ho_HomeSaveDto hoHomeSaveDto);
    Ho_HomeDto convertToHoHomeDtoFromHoHome(Ho_Home hoHome);
}
