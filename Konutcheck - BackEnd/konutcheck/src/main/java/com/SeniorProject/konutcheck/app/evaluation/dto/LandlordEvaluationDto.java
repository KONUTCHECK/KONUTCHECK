package com.SeniorProject.konutcheck.app.evaluation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;
@Getter
@Setter
public class LandlordEvaluationDto {
    private Long Id;
    private Long evaluationOwnerTenantId;
    private Long landlordId;
    private int gradeOfLandlordSatisfaction;
    private int gradeOfLandlordTreatment;
    private int gradeOfLandlordAccessibility;
    private int gradeOfLandlordUnderstanding;
    private BigDecimal landlordPoint;
}
