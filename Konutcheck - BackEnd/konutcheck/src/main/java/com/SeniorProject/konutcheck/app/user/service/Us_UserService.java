package com.SeniorProject.konutcheck.app.user.service;

import com.SeniorProject.konutcheck.app.general.exceptionEnums.GeneralErrorMessage;
import com.SeniorProject.konutcheck.app.general.exceptions.DuplicateException;
import com.SeniorProject.konutcheck.app.general.exceptions.InvalidInformationExceptions;
import com.SeniorProject.konutcheck.app.general.exceptions.ItemNotFoundExceptions;
import com.SeniorProject.konutcheck.app.user.converter.Us_UserMapperConverter;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserDto;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserSaveDto;
import com.SeniorProject.konutcheck.app.user.entity.Us_User;
import com.SeniorProject.konutcheck.app.user.enums.UserType;
import com.SeniorProject.konutcheck.app.user.service.entityService.Us_UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Us_UserService {
    private final Us_UserEntityService usUserEntityService;

    public Us_UserDto saveUser(Us_UserSaveDto usUserSaveDto){
        isEmailExist(usUserSaveDto.getEmail());
        validationOfAge(usUserSaveDto.getAge());
        Us_User usUser = Us_UserMapperConverter.INSTANCE.convertToUsUserFromUsUserSaveDto(usUserSaveDto);
        usUser = usUserEntityService.save(usUser);

        Us_UserDto usUserDto = Us_UserMapperConverter.INSTANCE.convertToUsUserDtoFromUsUser(usUser);
        return usUserDto;
    }

    public List<Us_UserDto> getAllUsers(){
        List<Us_User> usUserList = usUserEntityService.findAll();
        List<Us_UserDto> usUserDtoList = Us_UserMapperConverter.INSTANCE.convertToUsUserDtoListFromUsUserList(usUserList);
        return usUserDtoList;
    }

    public List<Us_UserDto> getAllUsersByUserType(UserType userType){
        List<Us_User> usUserList = usUserEntityService.getAllByUserType(userType);
        List<Us_UserDto> usUserDtoList = Us_UserMapperConverter.INSTANCE.convertToUsUserDtoListFromUsUserList(usUserList);
        return usUserDtoList;
    }

    public Us_UserDto updateUser(Us_UserDto usUserDto){
        Long id = usUserDto.getId();
        Boolean isExist = usUserEntityService.existById(id);

        Us_User usUser;
        if(isExist){
            validationOfAge(usUserDto.getAge());
            usUser = Us_UserMapperConverter.INSTANCE.convertToUsUserFromUsUSerDto(usUserDto);
            usUser = usUserEntityService.save(usUser);
        }else{
            throw new ItemNotFoundExceptions(GeneralErrorMessage.USER_NOT_FOUND);
        }

        Us_UserDto usUserDtoUpdate = Us_UserMapperConverter.INSTANCE.convertToUsUserDtoFromUsUser(usUser);
        return usUserDtoUpdate;
    }

    public void deleteUser(Long id){
        Us_User usUser = usUserEntityService.getIdWithControl(id);
        usUserEntityService.delete(usUser);
    }

    private Boolean isEmailExist(String email){
        Boolean isExist = usUserEntityService.existByEmail(email);
        if(!isExist){
            return true;
        }else{
            throw new DuplicateException(GeneralErrorMessage.ALREADY_USED);
        }
    }

    private Boolean validationOfAge(Long age){
        if(age > 0){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.AGE_CANNOT_BE_ZERO);
        }
    }
}
