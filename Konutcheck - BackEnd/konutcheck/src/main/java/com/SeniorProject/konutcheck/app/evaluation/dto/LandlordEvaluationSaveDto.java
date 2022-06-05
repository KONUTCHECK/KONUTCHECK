package com.SeniorProject.konutcheck.app.evaluation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LandlordEvaluationSaveDto {
    private int gradeOfLandlordSatisfaction;
    private int gradeOfLandlordTreatment;
    private int gradeOfLandlordAccessibility;
    private int gradeOfLandlordUnderstanding;
}
