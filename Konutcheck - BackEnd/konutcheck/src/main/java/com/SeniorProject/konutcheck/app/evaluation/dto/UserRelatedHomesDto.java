package com.SeniorProject.konutcheck.app.evaluation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRelatedHomesDto {
    private Long id;
    private Long homeId;
    private Long tenantId;
    private Long landlordId;
}
