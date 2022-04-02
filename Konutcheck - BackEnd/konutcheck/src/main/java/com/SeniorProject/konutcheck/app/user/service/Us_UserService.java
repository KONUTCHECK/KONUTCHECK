package com.SeniorProject.konutcheck.app.user.service;

import com.SeniorProject.konutcheck.app.user.converter.Us_UserMapperConverter;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserDto;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserSaveDto;
import com.SeniorProject.konutcheck.app.user.entity.Us_User;
import com.SeniorProject.konutcheck.app.user.service.entityService.Us_UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Us_UserService {
    private final Us_UserEntityService usUserEntityService;

    public Us_UserDto saveUser(Us_UserSaveDto usUserSaveDto){
        Us_User usUser = Us_UserMapperConverter.INSTANCE.convertToUsUserFromUsUserSaveDto(usUserSaveDto);
        usUser = usUserEntityService.save(usUser);

        Us_UserDto usUserDto = Us_UserMapperConverter.INSTANCE.convertToUsUserDtoFromUsUser(usUser);
        return usUserDto;
    }

    public Us_UserDto updateUser(Us_UserDto usUserDto){
        Long id = usUserDto.getId();
        Boolean isExist = usUserEntityService.existById(id);

        Us_User usUser;
        if(isExist){
            usUser = Us_UserMapperConverter.INSTANCE.convertToUsUserFromUsUSerDto(usUserDto);
            usUser = usUserEntityService.save(usUser);
        }else{
            throw new RuntimeException("User not found");
        }

        Us_UserDto usUserDtoUpdate = Us_UserMapperConverter.INSTANCE.convertToUsUserDtoFromUsUser(usUser);
        return usUserDtoUpdate;
    }

    public void deleteUser(Long id){
        Us_User usUser = usUserEntityService.getIdWithControl(id);
        usUserEntityService.delete(usUser);
    }
}
