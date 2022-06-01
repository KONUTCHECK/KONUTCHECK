package com.SeniorProject.konutcheck.app.user.controller;

import com.SeniorProject.konutcheck.app.user.dto.Us_UserDto;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserGetInfoDto;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserSaveDto;
import com.SeniorProject.konutcheck.app.user.enums.UserType;
import com.SeniorProject.konutcheck.app.user.service.Us_UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class Us_UserController {
    private final Us_UserService usUserService;

    @PostMapping
    public ResponseEntity save(@RequestBody Us_UserSaveDto usUserSaveDto){
       Us_UserDto usUserDtoSave = usUserService.saveUser(usUserSaveDto);
       return ResponseEntity.ok(usUserDtoSave);
    }

    @GetMapping
    public ResponseEntity getAll(){
        List<Us_UserGetInfoDto> usUserDtoList = usUserService.getAllUsers();
        return ResponseEntity.ok(usUserDtoList);
    }

    @GetMapping("/user-info")
    public ResponseEntity getUserById(){
        Us_UserGetInfoDto usUserDtoList = usUserService.getUserById();
        return ResponseEntity.ok(usUserDtoList);
    }

    @GetMapping("/{userType}")
    public ResponseEntity getAllByUserType(@PathVariable UserType userType){
        List<Us_UserDto> usUserDtoList = usUserService.getAllUsersByUserType(userType);
        return ResponseEntity.ok(usUserDtoList);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Us_UserDto usUserDto){
        Us_UserDto usUserDtoUpdate = usUserService.updateUser(usUserDto);
        return ResponseEntity.ok(usUserDtoUpdate);
    }

    @PatchMapping("/cancel/")
    public ResponseEntity cancelUser(){
        usUserService.cancelUser();
        return ResponseEntity.ok(Void.TYPE);
    }

    @PatchMapping("/get-user-back/")
    public ResponseEntity changeStatusTypeWithActive(){
        usUserService.changingUserTypeToActive();
        return ResponseEntity.ok(Void.TYPE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        usUserService.deleteUser(id);
        return ResponseEntity.ok(Void.TYPE);
    }
}
