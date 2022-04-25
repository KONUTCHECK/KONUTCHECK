package com.SeniorProject.konutcheck.app.evaluation.service;

import com.SeniorProject.konutcheck.app.evaluation.converter.UserRelatedHomesMapperConverter;
import com.SeniorProject.konutcheck.app.evaluation.dto.UserRelatedHomesDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.UserRelatedHomesSaveDto;
import com.SeniorProject.konutcheck.app.evaluation.entity.UserRelatedHomes;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.UserRelatedHomesEntityService;
import com.SeniorProject.konutcheck.app.general.exceptionEnums.GeneralErrorMessage;
import com.SeniorProject.konutcheck.app.general.exceptions.InvalidInformationExceptions;
import com.SeniorProject.konutcheck.app.general.exceptions.ItemNotFoundExceptions;
import com.SeniorProject.konutcheck.app.home.entity.Ho_Home;
import com.SeniorProject.konutcheck.app.home.service.entityService.Ho_HomeEntityService;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserDto;
import com.SeniorProject.konutcheck.app.user.service.entityService.Us_UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRelatedHomesService {
    private final UserRelatedHomesEntityService userRelatedHomesEntityService;
    private final Ho_HomeEntityService ho_homeEntityService;
    private final Us_UserEntityService usUserEntityService;
    private Us_UserDto usUserDto;

    public UserRelatedHomesDto save(UserRelatedHomesSaveDto userRelatedHomesSaveDto){
        UserRelatedHomes userRelatedHomes = UserRelatedHomesMapperConverter.INSTANCE.convertToUserRelatedHomesFromUserRelatedHomesSaveDto(userRelatedHomesSaveDto);
        validationOfHomeId(userRelatedHomesSaveDto);
        validationOfLandlordId(userRelatedHomesSaveDto);
        validationOfTenantId(userRelatedHomesSaveDto);
        userRelatedHomes = userRelatedHomesEntityService.save(userRelatedHomes);
        UserRelatedHomesDto userRelatedHomesDto = UserRelatedHomesMapperConverter.INSTANCE.convertToUserRelatedHomesDtoFromUserRelatedHomes(userRelatedHomes);
        return userRelatedHomesDto;
    }

    private Boolean validationOfHomeId(UserRelatedHomesSaveDto userRelatedHomesSaveDto){
        Long homeId = userRelatedHomesSaveDto.getHomeId();
        Boolean isHomeIdExist = ho_homeEntityService.existById(homeId);

        if(isHomeIdExist){
           return true;
        }else{
            throw new ItemNotFoundExceptions(GeneralErrorMessage.HOME_NOT_FOUND);
        }
    }

    private Boolean validationOfTenantId(UserRelatedHomesSaveDto userRelatedHomesSaveDto){
        Long tenantId = userRelatedHomesSaveDto.getTenantId();
        Boolean isTenantIdExist = usUserEntityService.existById(tenantId);
        if(isTenantIdExist){
            return true;
        }else{
            throw new ItemNotFoundExceptions(GeneralErrorMessage.USER_NOT_FOUND);
        }
    }

    private Boolean validationOfLandlordId(UserRelatedHomesSaveDto userRelatedHomesSaveDto){
        Long landlordId = userRelatedHomesSaveDto.getLandlordId();
        Boolean isLandlordIdExist = usUserEntityService.existById(landlordId);
        if(isLandlordIdExist){
            return true;
        }else{
            throw new ItemNotFoundExceptions(GeneralErrorMessage.USER_NOT_FOUND);
        }
    }
}
