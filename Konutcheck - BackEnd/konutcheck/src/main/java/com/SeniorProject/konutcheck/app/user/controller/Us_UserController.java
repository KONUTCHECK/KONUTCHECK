package com.SeniorProject.konutcheck.app.user.controller;

import com.SeniorProject.konutcheck.app.user.dto.Us_UserDto;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserSaveDto;
import com.SeniorProject.konutcheck.app.user.service.Us_UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    public ResponseEntity update(@RequestBody Us_UserDto usUserDto){
        Us_UserDto usUserDtoUpdate = usUserService.updateUser(usUserDto);
        return ResponseEntity.ok(usUserDtoUpdate);
    }
}
