package com.SeniorProject.konutcheck.app.evaluation.controller;

import com.SeniorProject.konutcheck.app.evaluation.dto.*;
import com.SeniorProject.konutcheck.app.evaluation.service.LandlordEvaluationService;
import com.SeniorProject.konutcheck.app.evaluation.service.LandlordRelatedHomesService;
import com.SeniorProject.konutcheck.app.evaluation.service.TenantEvaluationService;
import com.SeniorProject.konutcheck.app.evaluation.service.TenantRelatedHomesService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
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

    @PostMapping("/tenant-homes")
    public ResponseEntity save(@RequestBody TenantRelatedHomesSaveDto tenantRelatedHomesSaveDto){
        TenantRelatedHomesDto tenantRelatedHomesDto = tenantRelatedHomesService.save(tenantRelatedHomesSaveDto);
        return ResponseEntity.ok(tenantRelatedHomesDto);
    }

    @PostMapping("/landlord-homes")
    public ResponseEntity save(@RequestBody LandlordRelatedHomesSaveDto landlordRelatedHomesSaveDto){
        LandlordRelatedHomesDto landlordRelatedHomesDto = landlordRelatedHomesService.save(landlordRelatedHomesSaveDto);
        return ResponseEntity.ok(landlordRelatedHomesDto);
    }

    @PostMapping("/landlord-evaluation")
    public ResponseEntity saveLandlordEvaluation(@RequestBody LandlordEvaluationSaveDto landlordEvaluationSaveDto){
        LandlordEvaluationDto landlordEvaluationDto = landlordEvaluationService.saveLandlordEvaluation(landlordEvaluationSaveDto);
        return ResponseEntity.ok(landlordEvaluationDto);
    }

    @PostMapping("/tenant-evaluation")
    public ResponseEntity saveTenantEvaluation(@RequestBody TenantEvaluationSaveDto tenantEvaluationSaveDto){
        TenantEvaluationDto tenantEvaluationDto = tenantEvaluationService.saveTenantEvaluation(tenantEvaluationSaveDto);
        return ResponseEntity.ok(tenantEvaluationDto);
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
}
