package com.SeniorProject.konutcheck.app.evaluation.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class HomeEvaluationSaveDto {
    private int gradeOfHomeCleaning;
    private int gradeOfHomeReality;
    private int gradeOfHomeModification;
    private int gradeOfNetworkInfrastructure;
    private int gradeOfPhoneInfrastructure;
    private int gradeOfHomeEnvironment;
    private int gradeOfHomeNeighborliness;
    private int gradeOfHomeClosenessToSomewhere;
}
