package com.SeniorProject.konutcheck.app.evaluation.service;

import com.SeniorProject.konutcheck.app.evaluation.converter.HomeRelatedMapperConverter;
import com.SeniorProject.konutcheck.app.evaluation.dto.HomesRelatedWithUsersDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.HomesRelatedWithUsersSaveDto;
import com.SeniorProject.konutcheck.app.evaluation.entity.HomesRelatedWithUsers;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.HomeRelatedWithUsersEntityService;
import com.SeniorProject.konutcheck.app.general.exceptionEnums.GeneralErrorMessage;
import com.SeniorProject.konutcheck.app.general.exceptions.ItemNotFoundExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeRelatedService {
    private final HomeRelatedWithUsersEntityService homeRelatedWithUsersEntityService;

    public HomesRelatedWithUsersDto save (HomesRelatedWithUsersSaveDto homesRelatedWithUsersSaveDto) {
        HomesRelatedWithUsers homesRelatedWithUsers = HomeRelatedMapperConverter.INSTANCE.convertToHomesRelatedWithUsersFromHomesRelatedWithUsersSaveDto(homesRelatedWithUsersSaveDto);
        validationOfID(homesRelatedWithUsersSaveDto);
        homesRelatedWithUsers = homeRelatedWithUsersEntityService.save(homesRelatedWithUsers);
       HomesRelatedWithUsersDto homesRelatedWithUsersDto = HomeRelatedMapperConverter.INSTANCE.convertToHomesRelatedWithUsersDtoFromHomesRelatedWithUsers(homesRelatedWithUsers);
  return homesRelatedWithUsersDto;
    }
private boolean validationOfID (HomesRelatedWithUsersSaveDto homesRelatedWithUsersSaveDto) {
    Long userId = homesRelatedWithUsersSaveDto.getUserId();
    Long homeId = homesRelatedWithUsersSaveDto.getHomeId();
    boolean isExistUser = homeRelatedWithUsersEntityService.existById(userId);
    boolean isExistHome = homeRelatedWithUsersEntityService.existById(homeId);
if ( isExistUser  ) {
    if (isExistHome)
    {
        return true;
    }else {
        throw new ItemNotFoundExceptions(GeneralErrorMessage.HOME_NOT_FOUND);
    }
}else {
    throw new ItemNotFoundExceptions(GeneralErrorMessage.USER_NOT_FOUND);
}
}

}
