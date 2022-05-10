package com.SeniorProject.konutcheck.app.home.controller;

import com.SeniorProject.konutcheck.app.home.dto.*;
import com.SeniorProject.konutcheck.app.home.enums.HomeTypes;
import com.SeniorProject.konutcheck.app.home.service.Ho_HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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

    @PostMapping("/home-infos")
    public ResponseEntity saveInfo(@RequestBody GeneralHomeInfoSaveDto generalHomeInfoSaveDto){
        GeneralHomeInfoDto generalHomeInfoDtoSave = hoHomeService.saveHomeInfos(generalHomeInfoSaveDto);
        return ResponseEntity.ok(generalHomeInfoDtoSave);
    }

    @PostMapping("/home-address")
    public ResponseEntity saveHomeAddress(@RequestBody HomeAddressSaveDto homeAddressSaveDto){
        HomeAddressDto homeAddressDto = hoHomeService.saveHomeAddress(homeAddressSaveDto);
        return ResponseEntity.ok(homeAddressDto);
    }

    @GetMapping
    public ResponseEntity getAll(){
        List<Ho_HomeDetails> homeDetailsList = hoHomeService.getAllHomes();
        return ResponseEntity.ok(homeDetailsList);
    }

    @GetMapping("/{homeType}")
    public ResponseEntity getAllByHomeType(@PathVariable HomeTypes homeType){
        List<Ho_HomeDetails> homeDetailsList = hoHomeService.getAllHomesByHomeType(homeType);
        return ResponseEntity.ok(homeDetailsList);
    }

    @GetMapping("/between-dates/")
    public ResponseEntity getAllBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2){
        List<Ho_HomeDetails> homeDetailsList = hoHomeService.getAllHomesBetweenDate(date1, date2);
        return ResponseEntity.ok(homeDetailsList);
    }

    @GetMapping("/between-amounts/")
    public ResponseEntity getAllBetweenAmount(@RequestParam BigDecimal firstAmount, @RequestParam BigDecimal secondAmount){
        List<Ho_HomeDetails> homeDetailsList = hoHomeService.getAllHomesBetweenAmount(firstAmount, secondAmount);
        return ResponseEntity.ok(homeDetailsList);
    }

    @PutMapping("/update-home-infos")
    public ResponseEntity update(@RequestBody GeneralHomeInfoDto generalHomeInfoDto){
        GeneralHomeInfoDto generalHomeInfoDtoUpdate = hoHomeService.updateHomeInfos(generalHomeInfoDto);
        return ResponseEntity.ok(generalHomeInfoDtoUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        hoHomeService.deleteHome(id);
        return ResponseEntity.ok(Void.TYPE);
    }

}
