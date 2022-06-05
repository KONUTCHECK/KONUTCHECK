package com.SeniorProject.konutcheck.app.home.dto;

import com.SeniorProject.konutcheck.app.user.enums.StatusType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantHomeDto {
    private Long id;
    private Long tenantId;
    private Long homeId;
    private StatusType statusType;
}
