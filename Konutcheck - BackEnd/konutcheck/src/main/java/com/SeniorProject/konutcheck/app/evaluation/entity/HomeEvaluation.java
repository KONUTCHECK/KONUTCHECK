package com.SeniorProject.konutcheck.app.evaluation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "HOME_EVALUATION")
@Getter
@Setter
public class HomeEvaluation {
    @Id
    @SequenceGenerator(name = "HomeEvaluation", sequenceName = "HOME_EVALUATION_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "HomeEvaluation")
    private Long id;

    @Column(name = "HOME_ID", nullable = false)
    private Long homeId;

    @Column(name="EVALUATION_OWNER_TENANT_ID", nullable = false)
    private Long evaluationOwnerTenantId;

    @Column(name = "GRADE_OF_HOME_CLEANING", nullable = false)
    private int gradeOfHomeCleaning;

    @Column(name = "GRADE_OF_HOME_REALITY", nullable = false)
    private int gradeOfHomeReality;

    @Column(name = "GRADE_OF_HOME_MODIFICATION", nullable = false)
    private int gradeOfHomeModification;

    @Column(name = "GRADE_OF_NETWORK_INFRASTRUCTURE", nullable = false)
    private int gradeOfNetworkInfrastructure;

    @Column(name = "GRADE_OF_PHONE_INFRASTRUCTURE", nullable = false)
    private int gradeOfPhoneInfrastructure;

    @Column(name = "GRADE_OF_HOME_ENVIRONMENT", nullable = false)
    private int gradeOfHomeEnvironment;

    @Column(name = "GRADE_OF_HOME_NEIGHBORLINESS", nullable = false)
    private int gradeOfHomeNeighborliness;

    @Column(name = "GRADE_OF_HOME_CLOSENESS_TO_SOMEWHERE", nullable = false)
    private int gradeOfHomeClosenessToSomewhere;

    @Column(name = "HOME_POINT", precision = 19, scale = 2, nullable = false)
    private BigDecimal homePoint;
}
