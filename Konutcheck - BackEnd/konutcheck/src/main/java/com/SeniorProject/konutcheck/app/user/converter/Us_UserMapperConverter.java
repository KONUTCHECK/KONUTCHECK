package com.SeniorProject.konutcheck.app.user.converter;

import com.SeniorProject.konutcheck.app.user.dto.Us_UserDto;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserGetInfoDto;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserSaveDto;
import com.SeniorProject.konutcheck.app.user.entity.Us_User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface Us_UserMapperConverter {

    Us_UserMapperConverter INSTANCE = Mappers.getMapper(Us_UserMapperConverter.class);
    Us_User convertToUsUserFromUsUserSaveDto(Us_UserSaveDto usUserSaveDto);
    Us_UserDto convertToUsUserDtoFromUsUser(Us_User usUser);
    Us_UserGetInfoDto convertToUsUserGetInfoDtoFromUsUser(Us_User usUser);
    Us_User convertToUsUserFromUsUSerDto(Us_UserDto usUserDto);
    List<Us_UserDto> convertToUsUserDtoListFromUsUserList(List<Us_User> usUserList);
    List<Us_UserGetInfoDto> convertToUsUserGetInfoDtoListFromUsUserList(List<Us_User> usUserList);
}
