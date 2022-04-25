package com.SeniorProject.konutcheck.app.evaluation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantEvaluationSaveDto {
    private Long tenantId;
    private int gradeOfRentPayment;
    private int gradeOfBillPayment;
    private int gradeOfTenantSatisfaction;
    private int gradeOfTenantNeighborliness;
    private int getGradeOfTenantHomeTreat;
}
