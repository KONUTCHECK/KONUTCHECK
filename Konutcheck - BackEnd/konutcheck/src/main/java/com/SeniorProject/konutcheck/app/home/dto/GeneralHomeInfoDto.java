package com.SeniorProject.konutcheck.app.home.dto;

import com.SeniorProject.konutcheck.app.home.enums.HomeAspects;
import com.SeniorProject.konutcheck.app.home.enums.HomeTypes;
import com.SeniorProject.konutcheck.app.home.enums.WarningSystems;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class GeneralHomeInfoDto {

    private Long id;
    private BigDecimal amount;
    private BigDecimal deposit;
    private BigDecimal dues;
    private int numberOfRooms;
    private WarningSystems warningSystem;
    private int buildingAge;
    private HomeAspects homeAspect;
    private int floor;
    private BigDecimal homeSize;
    private HomeTypes homeType;
}
