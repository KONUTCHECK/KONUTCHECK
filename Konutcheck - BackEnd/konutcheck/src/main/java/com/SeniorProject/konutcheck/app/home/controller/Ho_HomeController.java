package com.SeniorProject.konutcheck.app.home.controller;

import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeDto;
import com.SeniorProject.konutcheck.app.home.dto.Ho_HomeSaveDto;
import com.SeniorProject.konutcheck.app.home.service.Ho_HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homes")
@RequiredArgsConstructor
public class Ho_HomeController {
    private final Ho_HomeService hoHomeService;

    @PostMapping
    public ResponseEntity save(@RequestBody Ho_HomeSaveDto hoHomeSaveDto){
        Ho_HomeDto hoHomeDto = hoHomeService.saveHome(hoHomeSaveDto);
        return ResponseEntity.ok(hoHomeDto);
    }

}
