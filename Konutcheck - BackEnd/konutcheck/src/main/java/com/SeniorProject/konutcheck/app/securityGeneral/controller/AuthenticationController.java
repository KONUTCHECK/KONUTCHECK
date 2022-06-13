package com.SeniorProject.konutcheck.app.securityGeneral.controller;


import com.SeniorProject.konutcheck.app.securityGeneral.dto.SecurityLoginRequestDto;
import com.SeniorProject.konutcheck.app.securityGeneral.service.AuthenticationService;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserDto;
import com.SeniorProject.konutcheck.app.user.dto.Us_UserSaveDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Us_UserSaveDto usUserSaveDto){
        Us_UserDto usUserDto = authenticationService.register(usUserSaveDto);
        return ResponseEntity.ok(usUserDto);
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody SecurityLoginRequestDto securityLoginRequestDto){
       String token = authenticationService.login(securityLoginRequestDto);
       return  ResponseEntity.ok(token);
    }
}
