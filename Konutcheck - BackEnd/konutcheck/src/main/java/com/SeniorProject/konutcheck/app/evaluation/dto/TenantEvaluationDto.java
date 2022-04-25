package com.SeniorProject.konutcheck.app.evaluation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
public class TenantEvaluationDto {

    private Long Id;
    private Long evaluationOwnerLandlordId;
    private Long tenantId;
    private int gradeOfRentPayment;
    private int gradeOfBillPayment;
    private int gradeOfTenantSatisfaction;
    private int gradeOfTenantNeighborliness;
    private int getGradeOfTenantHomeTreat;
    private BigDecimal tenantPoint;
}
