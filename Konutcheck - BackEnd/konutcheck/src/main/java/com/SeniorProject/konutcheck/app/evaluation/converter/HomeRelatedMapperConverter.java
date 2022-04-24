package com.SeniorProject.konutcheck.app.evaluation.converter;

import com.SeniorProject.konutcheck.app.evaluation.dto.HomesRelatedWithUsersDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.HomesRelatedWithUsersSaveDto;
import com.SeniorProject.konutcheck.app.evaluation.entity.HomesRelatedWithUsers;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HomeRelatedMapperConverter {
    HomeRelatedMapperConverter INSTANCE = Mappers.getMapper(HomeRelatedMapperConverter.class);
   HomesRelatedWithUsers convertToHomesRelatedWithUsersFromHomesRelatedWithUsersSaveDto (HomesRelatedWithUsersSaveDto homesRelatedWithUsersSaveDto);
    HomesRelatedWithUsersDto convertToHomesRelatedWithUsersDtoFromHomesRelatedWithUsers(HomesRelatedWithUsers homesRelatedWithUsers);
}
