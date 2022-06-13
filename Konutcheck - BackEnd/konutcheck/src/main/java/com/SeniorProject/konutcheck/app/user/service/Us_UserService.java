package com.SeniorProject.konutcheck.app.user.service;

import com.SeniorProject.konutcheck.app.evaluation.entity.LandlordEvaluation;
import com.SeniorProject.konutcheck.app.evaluation.entity.TenantEvaluation;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.LandlordEvaluationEntityService;
import com.SeniorProject.konutcheck.app.evaluation.service.entityService.TenantEvaluationEntityService;
import com.SeniorProject.konutcheck.app.general.exceptionEnums.GeneralErrorMessage;
import com.SeniorProject.konutcheck.app.general.exceptions.DuplicateException;
import com.SeniorProject.konutcheck.app.general.exceptions.InvalidInformationExceptions;
import com.SeniorProject.konutcheck.app.general.exceptions.ItemNotFoundExceptions;
import com.SeniorProject.konutcheck.app.securityGeneral.service.AuthenticationService;
import com.SeniorProject.konutcheck.app.user.converter.Us_UserMapperConverter;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserDto;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserGetInfoDto;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserSaveDto;
import com.SeniorProject.konutcheck.app.user.entity.Us_User;
import com.SeniorProject.konutcheck.app.user.enums.StatusType;
import com.SeniorProject.konutcheck.app.user.enums.UserType;
import com.SeniorProject.konutcheck.app.user.service.entityService.Us_UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Us_UserService {
    private final Us_UserEntityService usUserEntityService;
    private final PasswordEncoder passwordEncoder;

    public Us_UserDto saveUser(Us_UserSaveDto usUserSaveDto){
        isEmailExist(usUserSaveDto.getEmail());
        validationOfAge(usUserSaveDto.getAge());
        Us_User usUser = Us_UserMapperConverter.INSTANCE.convertToUsUserFromUsUserSaveDto(usUserSaveDto);
        String encodedPassword = passwordEncoder.encode(usUserSaveDto.getPassword());
        usUser.setPassword(encodedPassword);
        usUser.setStatusType(StatusType.Aktif);
        usUser = usUserEntityService.save(usUser);

        Us_UserDto usUserDto = Us_UserMapperConverter.INSTANCE.convertToUsUserDtoFromUsUser(usUser);
        return usUserDto;
    }

    public List<Us_UserGetInfoDto> getAllUsers(){
        List<Us_User> usUserList = usUserEntityService.findAllActiveUser();
        List<Us_UserGetInfoDto> usUserDtoList = Us_UserMapperConverter.INSTANCE.convertToUsUserGetInfoDtoListFromUsUserList(usUserList);
        return usUserDtoList;
    }

    public Us_UserGetInfoDto getUserById(){
        Long id = usUserEntityService.getCurrentUser();
        Us_User usUserList = usUserEntityService.getIdWithControl(id);
        Us_UserGetInfoDto usUserDtoList = Us_UserMapperConverter.INSTANCE.convertToUsUserGetInfoDtoFromUsUser(usUserList);
        return usUserDtoList;
    }

    public List<Us_UserDto> getAllUsersByUserType(UserType userType){
        List<Us_User> usUserList = usUserEntityService.getAllByUserTypeWithActiveUser(userType);
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
            usUser.setStatusType(StatusType.Aktif);
            usUser = usUserEntityService.save(usUser);
        }else{
            throw new ItemNotFoundExceptions(GeneralErrorMessage.USER_NOT_FOUND);
        }

        Us_UserDto usUserDtoUpdate = Us_UserMapperConverter.INSTANCE.convertToUsUserDtoFromUsUser(usUser);
        return usUserDtoUpdate;
    }

    public void cancelUser() {
        Long userId = usUserEntityService.getCurrentUser();
        Us_User usUser = usUserEntityService.getIdWithControl(userId);
        usUser.setStatusType(StatusType.Pasif);

        usUserEntityService.save(usUser);
    }

    public void changingUserTypeToActive() {
        Long userId = usUserEntityService.getCurrentUser();
        Us_User usUser = usUserEntityService.getIdWithControl(userId);
        validationOfIsUserPassive(usUser);
        usUser.setStatusType(StatusType.Aktif);

        usUserEntityService.save(usUser);
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

    private Boolean validationOfIsUserPassive(Us_User usUser){
        if(usUser.getStatusType().equals(StatusType.Pasif)){
            return true;
        }else{
            throw new InvalidInformationExceptions(GeneralErrorMessage.USER_IS_ACTIVE);
        }
    }

}
