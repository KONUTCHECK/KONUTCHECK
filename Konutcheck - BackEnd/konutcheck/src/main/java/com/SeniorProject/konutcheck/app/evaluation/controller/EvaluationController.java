package com.SeniorProject.konutcheck.app.evaluation.controller;

import com.SeniorProject.konutcheck.app.evaluation.dto.*;
import com.SeniorProject.konutcheck.app.evaluation.service.Ev_EvaluationService;
import com.SeniorProject.konutcheck.app.evaluation.service.UserRelatedHomesService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/evaluations")
@RequiredArgsConstructor
public class EvaluationController {
    private final Ev_EvaluationService evaluationService;
    private final UserRelatedHomesService userRelatedHomesService;

    @PostMapping
    public ResponseEntity save(@RequestBody UserRelatedHomesSaveDto userRelatedHomesSaveDto){
        UserRelatedHomesDto userRelatedHomesDto = userRelatedHomesService.save(userRelatedHomesSaveDto);
        return ResponseEntity.ok(userRelatedHomesDto);
    }

    @PostMapping("/landlord-evaluation")
    public ResponseEntity saveLandlordEvaluation(@RequestBody LandlordEvaluationSaveDto landlordEvaluationSaveDto){
        LandlordEvaluationDto landlordEvaluationDto = evaluationService.saveLandlordEvaluation(landlordEvaluationSaveDto);
        return ResponseEntity.ok(landlordEvaluationDto);
    }

}
