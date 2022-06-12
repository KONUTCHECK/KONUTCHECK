package com.SeniorProject.konutcheck.app.home.controller;

import com.SeniorProject.konutcheck.app.home.dto.*;
import com.SeniorProject.konutcheck.app.home.entity.TenantHome;
import com.SeniorProject.konutcheck.app.home.enums.Cities;
import com.SeniorProject.konutcheck.app.home.enums.HomeTypes;
import com.SeniorProject.konutcheck.app.home.service.Ho_HomeService;
import com.SeniorProject.konutcheck.app.home.service.TenantHomeService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
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
    private final TenantHomeService tenantHomeService;


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

    @GetMapping("/id/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        GeneralHomeInfoDto generalHomeInfoDto = hoHomeService.findById(id);
        return ResponseEntity.ok(generalHomeInfoDto);
    }

    @GetMapping("/")
    public ResponseEntity getAllByHomeType(@RequestParam HomeTypes homeType){
        List<GeneralHomeInfoDto> homeDetailsList = hoHomeService.getAllHomesByHomeType(homeType);
        return ResponseEntity.ok(homeDetailsList);
    }

    @GetMapping("/landlord-homes")
    public ResponseEntity gelAllHomesByHomeOwner(){
        List<GeneralHomeInfoDto> generalHomeInfoDtoList = hoHomeService.gelAllHomesByHomeOwner();
        return ResponseEntity.ok(generalHomeInfoDtoList);
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


    /*---------------------------------------------------------------------------------------------------------*/

    @PatchMapping("/save-tenant-home/{homeId}")
    public ResponseEntity saveTenantHome(@PathVariable Long homeId){
        TenantHomeDto tenantHomeDto = tenantHomeService.saveTenantHome(homeId);
        return ResponseEntity.ok(tenantHomeDto);
    }

    @GetMapping("/list-passive-homes")
    public ResponseEntity getTenantHomeList(){
        List<TenantHomeDetails> tenantHomeDetails = tenantHomeService.getTenantHomeList();
        return ResponseEntity.ok(tenantHomeDetails);
    }

    @GetMapping("/landlord-tenants")
    public ResponseEntity getLandlordTenant(){
        List<TenantHomeDetails> tenantHomeDetails = tenantHomeService.getLandlordTenants();
        return ResponseEntity.ok(tenantHomeDetails);
    }

    @GetMapping("/tenant-homes-details")
    public ResponseEntity getTenantAllHomesDetails(){
        List<Ho_HomeDetails> homeDetailsList = tenantHomeService.getTenantAllHomesDetails();
        return ResponseEntity.ok(homeDetailsList);
    }

    @PatchMapping("/set-status-active/{id}")
    public ResponseEntity setStatusTypeActive(@PathVariable Long id){
        TenantHome tenantHome = tenantHomeService.saveTenantHomeStatusActive(id);
        return ResponseEntity.ok(tenantHome);
    }

}
