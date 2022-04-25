package com.SeniorProject.konutcheck.app.evaluation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name= "LANDLORD_EVALUATION")
@Getter
@Setter
public class LandlordEvaluation {
    @Id
    @SequenceGenerator(name = "LandlordEvaluation", sequenceName = "LANDLORD_EVALUATION_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "LandlordEvaluation")
    private Long Id;

    @Column(name="LANDLORD_ID", nullable = false)
    private Long landlordId;

    @Column(name = "GRADE_OF_LANDLORD_SATISFACTION", nullable = false)
    private int gradeOfLandlordSatisfaction;

    @Column(name = "GRADE_OF_LANDLORD_TREATMENT", nullable = false)
    private int gradeOfLandlordTreatment;

    @Column(name = "GRADE_OF_LANDLORD_ACCESSIBILITY", nullable = false)
    private int gradeOfLandlordAccessibility;

    @Column(name = "GRADE_OF_LANDLORD_UNDERSTANDING", nullable = false)
    private int gradeOfLandlordUnderstanding;

    @Column(name = "LANDLORD_POINT", precision = 19, scale = 2, nullable = false)
    private BigDecimal landlordPoint;

}
