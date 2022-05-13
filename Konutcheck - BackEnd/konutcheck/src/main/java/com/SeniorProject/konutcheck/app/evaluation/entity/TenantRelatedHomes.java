package com.SeniorProject.konutcheck.app.evaluation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TENANT_RELATED_HOMES")
@Getter
@Setter
public class TenantRelatedHomes {

    @Id
    @SequenceGenerator(name = "TenantRelatedHomes", sequenceName = "TENANT_RELATED_HOMES_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "TenantRelatedHomes")
    private Long id;

    @Column(name = "TENANT_ID", nullable = false)
    private Long tenantId;

    @Column(name = "LANDLORD_ID", nullable = false)
    private Long landlordId;

    @Column(name = "HOME_ID", nullable = false)
    private Long homeId;
}
