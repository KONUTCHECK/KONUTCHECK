package com.SeniorProject.konutcheck.app.home.entity;

import com.SeniorProject.konutcheck.app.user.enums.StatusType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TENANT_HOME")
@Getter
@Setter
public class TenantHome {

    @Id
    @SequenceGenerator(name = "TenantHome", sequenceName = "TENANT_HOME_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "TenantHome")
    private Long id;

    @Column(name = "TENANT_ID", nullable = false)
    private Long tenantId;

    @Column(name = "HOME_ID", nullable = false)
    private Long homeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_TYPE", nullable = false, length = 30)
    private StatusType statusType;
}
