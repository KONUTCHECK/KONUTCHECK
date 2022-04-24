package com.SeniorProject.konutcheck.app.evaluation.entity;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name= "TENANT_EVALUATION")
public class TenantEvaluation {
    @Id
    @SequenceGenerator(name = "TenantEvaluation", sequenceName = "TENANT_EVALUATION_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "TenantEvaluation")
    private Long Id;

    @Column(name="TENANT_ID", nullable = false)
    private Long tenantId;

    @Column(name = "GRADE_OF_RENT_PAYMENT", nullable = false)
    private int gradeOfRentPayment;

    @Column(name = "GRADE_OF_BILL_PAYMENT", nullable = false)
    private int gradeOfBillPayment;

    @Column(name = "GRADE_OF_TENANT_SATISFACTION", nullable = false)
    private int gradeOfTenantSatisfaction;

    @Column(name = "GRADE_OF_TENANT_NEIGHBORLINESS", nullable = false)
    private int gradeOfTenantNeighborliness;

    @Column(name = "GRADE_OF_TENANT_HOME_TREAT", nullable = false)
    private int getGradeOfTenantHomeTreat;

    @Column(name = "TENANT_POINT", precision = 19, scale = 2,nullable = false)
    private BigDecimal tenantPoint;

}
