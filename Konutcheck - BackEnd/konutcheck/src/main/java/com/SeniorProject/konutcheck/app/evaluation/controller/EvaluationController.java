package com.SeniorProject.konutcheck.app.evaluation.controller;

import com.SeniorProject.konutcheck.app.evaluation.dto.*;
import com.SeniorProject.konutcheck.app.evaluation.service.*;
import com.SeniorProject.konutcheck.app.home.dto.TenantHomeDto;
import com.SeniorProject.konutcheck.app.home.service.TenantHomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/evaluations")
@RequiredArgsConstructor
public class EvaluationController {
    private final LandlordEvaluationService landlordEvaluationService;
    private final TenantEvaluationService tenantEvaluationService;
    private final TenantRelatedHomesService tenantRelatedHomesService;
    private final LandlordRelatedHomesService landlordRelatedHomesService;
    private final HomeEvaluationService homeEvaluationService;

    @PostMapping("/add-tenant-homes")
    public ResponseEntity save(@RequestBody TenantRelatedHomesSaveDto tenantRelatedHomesSaveDto){
        TenantRelatedHomesDto tenantRelatedHomesDto = tenantRelatedHomesService.save(tenantRelatedHomesSaveDto);
        return ResponseEntity.ok(tenantRelatedHomesDto);
    }

    @PostMapping("/add-landlord-homes")
    public ResponseEntity save(@RequestBody LandlordRelatedHomesSaveDto landlordRelatedHomesSaveDto){
        LandlordRelatedHomesDto landlordRelatedHomesDto = landlordRelatedHomesService.save(landlordRelatedHomesSaveDto);
        return ResponseEntity.ok(landlordRelatedHomesDto);
    }

    @PostMapping("/landlord-evaluation")
    public ResponseEntity saveLandlordEvaluation(@RequestBody LandlordEvaluationSaveDto landlordEvaluationSaveDto){
        LandlordEvaluationDto landlordEvaluationDto = landlordEvaluationService.saveLandlordEvaluation(landlordEvaluationSaveDto);
        return ResponseEntity.ok(landlordEvaluationDto);
    }

    @PostMapping("/tenant-evaluation/{tenantId}")
    public ResponseEntity saveTenantEvaluation(@RequestBody TenantEvaluationSaveDto tenantEvaluationSaveDto, @PathVariable Long tenantId){
        TenantEvaluationDto tenantEvaluationDto = tenantEvaluationService.saveTenantEvaluation(tenantEvaluationSaveDto, tenantId);
        return ResponseEntity.ok(tenantEvaluationDto);
    }

    @PostMapping("/home-evaluation")
    public ResponseEntity saveHomeEvaluation(@RequestBody HomeEvaluationSaveDto homeEvaluationSaveDto){
        HomeEvaluationDto homeEvaluationDto = homeEvaluationService.saveHomeEvaluation(homeEvaluationSaveDto);
        return ResponseEntity.ok(homeEvaluationDto);
    }

    @GetMapping("/landlord-total-point/{id}")
    public ResponseEntity getTotalPointOfLandlord(@PathVariable Long id){
        List<GetTotalPoint> getTotalPointList = landlordEvaluationService.getTotalPointOfLandlord(id);
        return ResponseEntity.ok(getTotalPointList);
    }

    @GetMapping("/tenant-total-point/{id}")
    public ResponseEntity getTotalPointOfTenant(@PathVariable Long id){
        List<GetTotalPoint> getTotalPointList = tenantEvaluationService.getTotalPointOfTenant(id);
        return ResponseEntity.ok(getTotalPointList);
    }

    @GetMapping("/home-total-point/{id}")
    public ResponseEntity getTotalPointOfHome(@PathVariable Long id){
        List<GetTotalPoint> getTotalPointList = homeEvaluationService.getTotalPointOfHome(id);
        return ResponseEntity.ok(getTotalPointList);
    }

    @GetMapping("/get-tenant-homes/{id}")
    public ResponseEntity getTenantHomeDetailsByTenantId(@PathVariable Long id){
        List<UserHomeDetails> userHomeDetailsList = tenantRelatedHomesService.getTenantHomeDetails(id);
        return ResponseEntity.ok(userHomeDetailsList);
    }

    @GetMapping("/get-landlord-homes/{id}")
    public ResponseEntity getLandlordHomeDetailsByLandlordId(@PathVariable Long id){
        List<UserHomeDetails> userHomeDetailsList = landlordRelatedHomesService.getLandlordHomeDetails(id);
        return ResponseEntity.ok(userHomeDetailsList);
    }



}
