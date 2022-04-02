package com.SeniorProject.konutcheck.app.user.controller;

import com.SeniorProject.konutcheck.app.user.dto.Us_UserDto;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserSaveDto;
import com.SeniorProject.konutcheck.app.user.enums.UserTypeEnums;
import com.SeniorProject.konutcheck.app.user.service.Us_UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        List<Us_UserDto> usUserDtoList = usUserService.getAllUsers();
        return ResponseEntity.ok(usUserDtoList);
    }

    @GetMapping("/{userType}")
    public ResponseEntity getAllByUserType(@PathVariable UserTypeEnums userType){
        List<Us_UserDto> usUserDtoList = usUserService.getAllUsersByUserType(userType);
        return ResponseEntity.ok(usUserDtoList);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Us_UserDto usUserDto){
        Us_UserDto usUserDtoUpdate = usUserService.updateUser(usUserDto);
        return ResponseEntity.ok(usUserDtoUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        usUserService.deleteUser(id);
        return ResponseEntity.ok(Void.TYPE);
    }
}
