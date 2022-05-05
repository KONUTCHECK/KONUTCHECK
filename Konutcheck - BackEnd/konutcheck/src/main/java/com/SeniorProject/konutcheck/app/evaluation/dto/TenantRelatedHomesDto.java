package com.SeniorProject.konutcheck.app.evaluation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantRelatedHomesDto {
    private Long id;
    private Long tenantId;
    private Long landlordId;
    private Long homeId;
}
