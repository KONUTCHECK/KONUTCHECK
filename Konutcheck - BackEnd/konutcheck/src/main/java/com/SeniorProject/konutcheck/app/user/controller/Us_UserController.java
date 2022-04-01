package com.SeniorProject.konutcheck.app.user.controller;

import com.SeniorProject.konutcheck.app.user.dto.Us_UserDto;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserSaveDto;
import com.SeniorProject.konutcheck.app.user.service.Us_UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class Us_UserController {
    private final Us_UserService usUserService;

    @PostMapping
    public ResponseEntity save(@RequestBody Us_UserSaveDto usUserSaveDto){
       Us_UserDto usUserDto = usUserService.saveUser(usUserSaveDto);
       return ResponseEntity.ok(usUserDto);
    }
}
