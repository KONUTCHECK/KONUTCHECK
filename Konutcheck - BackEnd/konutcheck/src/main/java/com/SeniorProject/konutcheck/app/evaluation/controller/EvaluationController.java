package com.SeniorProject.konutcheck.app.evaluation.controller;

import com.SeniorProject.konutcheck.app.evaluation.dto.HomesRelatedWithUsersDto;
import com.SeniorProject.konutcheck.app.evaluation.dto.HomesRelatedWithUsersSaveDto;
import com.SeniorProject.konutcheck.app.evaluation.service.HomeRelatedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/evaluations")
@RequiredArgsConstructor
public class EvaluationController {
    private final HomeRelatedService homeRelatedService ;

    @PostMapping
    public ResponseEntity save (HomesRelatedWithUsersSaveDto homesRelatedWithUsersSaveDto) {
        HomesRelatedWithUsersDto homesRelatedWithUsersDto = homeRelatedService.save(homesRelatedWithUsersSaveDto);
        return ResponseEntity.ok(homesRelatedWithUsersDto);

    }
}
