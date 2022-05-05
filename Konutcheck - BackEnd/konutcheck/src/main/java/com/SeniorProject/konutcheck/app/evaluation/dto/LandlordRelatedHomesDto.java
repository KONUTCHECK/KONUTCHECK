package com.SeniorProject.konutcheck.app.evaluation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LandlordRelatedHomesDto {
    private Long id;
    private Long landlordId;
    private Long homeId;
}
