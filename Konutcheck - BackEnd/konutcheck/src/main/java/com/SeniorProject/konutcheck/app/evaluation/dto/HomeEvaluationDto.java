package com.SeniorProject.konutcheck.app.evaluation.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class HomeEvaluationDto {
    private Long id;
    private Long homeId;
    private Long evaluationOwnerTenantId;
    private int gradeOfHomeCleaning;
    private int gradeOfHomeReality;
    private int gradeOfHomeModification;
    private int gradeOfNetworkInfrastructure;
    private int gradeOfPhoneInfrastructure;
    private int gradeOfHomeEnvironment;
    private int gradeOfHomeNeighborliness;
    private int gradeOfHomeClosenessToSomewhere;
    private BigDecimal homePoint;
}
