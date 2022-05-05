package com.SeniorProject.konutcheck.app.evaluation.controller;

import com.SeniorProject.konutcheck.app.evaluation.dto.*;
import com.SeniorProject.konutcheck.app.evaluation.service.LandlordEvaluationService;
import com.SeniorProject.konutcheck.app.evaluation.service.LandlordRelatedHomesService;
import com.SeniorProject.konutcheck.app.evaluation.service.TenantRelatedHomesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/evaluations")
@RequiredArgsConstructor
public class EvaluationController {
    private final LandlordEvaluationService landlordEvaluationService;
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

}
