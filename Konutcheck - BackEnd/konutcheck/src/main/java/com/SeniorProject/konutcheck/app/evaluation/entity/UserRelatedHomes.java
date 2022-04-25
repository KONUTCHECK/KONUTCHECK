package com.SeniorProject.konutcheck.app.evaluation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USER_RELATED_HOMES")
@Getter
@Setter
public class UserRelatedHomes {
    @Id
    @SequenceGenerator(name = "UserRelatedHomes", sequenceName = "USER_RELATED_HOMES_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "UserRelatedHomes")
    private Long id;

    @Column(name = "HOME_ID", nullable = false)
    private Long homeId;

    @Column(name = "TENANT_ID")
    private Long tenantId;

    @Column(name = "LANDLORD_ID", nullable = false)
    private Long landlordId;
}
