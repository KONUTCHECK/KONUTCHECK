package com.SeniorProject.konutcheck.app.home.controller;

import com.SeniorProject.konutcheck.app.home.dto.*;
import com.SeniorProject.konutcheck.app.home.enums.Cities;
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

    @PostMapping("/home-infos")
    public ResponseEntity saveInfo(@RequestBody GeneralHomeInfoSaveDto generalHomeInfoSaveDto){
        GeneralHomeInfoDto generalHomeInfoDtoSave = hoHomeService.saveHomeInfos(generalHomeInfoSaveDto);
        return ResponseEntity.ok(generalHomeInfoDtoSave);
    }

    @GetMapping
    public ResponseEntity getAll(){
        List<GeneralHomeInfoDto> homeDetailsList = hoHomeService.getAllHomes();
        return ResponseEntity.ok(homeDetailsList);
    }

    @GetMapping("/{homeType}")
    public ResponseEntity getAllByHomeType(@PathVariable HomeTypes homeType){
        List<GeneralHomeInfoDto> homeDetailsList = hoHomeService.getAllHomesByHomeType(homeType);
        return ResponseEntity.ok(homeDetailsList);
    }

    @GetMapping("/between-dates/")
    public ResponseEntity getAllBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2){
        List<GeneralHomeInfoDto> homeDetailsList = hoHomeService.getAllHomesBetweenDate(date1, date2);
        return ResponseEntity.ok(homeDetailsList);
    }

    @GetMapping("/between-amounts/")
    public ResponseEntity getAllBetweenAmount(@RequestParam BigDecimal firstAmount, @RequestParam BigDecimal secondAmount){
        List<GeneralHomeInfoDto> homeDetailsList = hoHomeService.getAllHomesBetweenAmount(firstAmount, secondAmount);
        return ResponseEntity.ok(homeDetailsList);
    }

    @GetMapping("/cities/")
    public ResponseEntity getAllHomesByCity(
            @RequestParam Cities city){
        List<GeneralHomeInfoDto> homeDetailsList = hoHomeService.getAllHomesByCity(city);
        return ResponseEntity.ok(homeDetailsList);
    }

    @GetMapping("/cities-and-district/")
    public ResponseEntity getAllHomesByCityAndDistrict(
            @RequestParam Cities city,
            @RequestParam String district
    ){
        List<GeneralHomeInfoDto> homeDetailsList = hoHomeService.getAllHomesByCityAndDistrict(city, district);
        return ResponseEntity.ok(homeDetailsList);
    }

    @GetMapping("/cities-and-district-and-neighborhood/")
    public ResponseEntity getAllHomesByCityAndDistrictAndNeighborhood(
            @RequestParam Cities city,
            @RequestParam String district,
            @RequestParam String neighborhood
    ){
        List<GeneralHomeInfoDto> homeDetailsList = hoHomeService.getAllHomesByCityAndDistrictAndNeighborhood(city, district, neighborhood);
        return ResponseEntity.ok(homeDetailsList);
    }

    @GetMapping("/cities-and-district-and-neighborhood-and-street/")
    public ResponseEntity getAllHomesByCityAndDistrictAndNeighborhoodAndStreet(
            @RequestParam Cities city,
            @RequestParam String district,
            @RequestParam String neighborhood,
            @RequestParam String street
    ){
        List<GeneralHomeInfoDto> homeDetailsList = hoHomeService.getAllHomesByCityAndDistrictAndNeighborhoodAndStreet(city, district, neighborhood, street);
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
