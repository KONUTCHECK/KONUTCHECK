package com.SeniorProject.konutcheck.app.home.controller;

import com.SeniorProject.konutcheck.app.home.dto.*;
import com.SeniorProject.konutcheck.app.home.service.GeneralHomeInfoService;
import com.SeniorProject.konutcheck.app.home.service.Ho_HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homes")
@RequiredArgsConstructor
public class Ho_HomeController {
    private final Ho_HomeService hoHomeService;
    private final GeneralHomeInfoService generalHomeInfoService;

    @PostMapping
    public ResponseEntity save(@RequestBody Ho_HomeSaveDto hoHomeSaveDto){
        Ho_HomeDto hoHomeDto = hoHomeService.saveHome(hoHomeSaveDto);
        return ResponseEntity.ok(hoHomeDto);
    }

    @PostMapping("/home-infos")
    public ResponseEntity saveInfo(@RequestBody GeneralHomeInfoSaveDto generalHomeInfoSaveDto){
        GeneralHomeInfoDto generalHomeInfoDtoSave = generalHomeInfoService.saveHomeInfos(generalHomeInfoSaveDto);
        return ResponseEntity.ok(generalHomeInfoDtoSave);
    }

    @GetMapping
    public ResponseEntity getAll(){
        List<Ho_HomeDetails> homeDetailsList = hoHomeService.getAllHomes();
        return ResponseEntity.ok(homeDetailsList);
    }

    @PutMapping("/update-home-infos")
    public ResponseEntity update(@RequestBody GeneralHomeInfoDto generalHomeInfoDto){
        GeneralHomeInfoDto generalHomeInfoDtoUpdate = generalHomeInfoService.updateHomeInfos(generalHomeInfoDto);
        return ResponseEntity.ok(generalHomeInfoDtoUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        hoHomeService.deleteHome(id);
        return ResponseEntity.ok(Void.TYPE);
    }

}
