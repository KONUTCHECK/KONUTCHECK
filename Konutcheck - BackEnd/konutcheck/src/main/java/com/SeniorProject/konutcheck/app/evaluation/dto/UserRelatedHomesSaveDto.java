package com.SeniorProject.konutcheck.app.evaluation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRelatedHomesSaveDto {
    private Long homeId;
    private Long tenantId;
    private Long landlordId;
}
