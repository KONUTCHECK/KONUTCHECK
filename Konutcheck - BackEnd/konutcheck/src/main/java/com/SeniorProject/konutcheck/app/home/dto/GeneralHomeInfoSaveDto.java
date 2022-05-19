package com.SeniorProject.konutcheck.app.home.dto;

import com.SeniorProject.konutcheck.app.home.enums.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Getter
@Setter
public class GeneralHomeInfoSaveDto {

    private BigDecimal amount;
    private BigDecimal deposit;
    private BigDecimal dues;
    private String numberOfRooms;
    private WarningSystems warningSystem;
    private String buildingAge;
    private HomeAspects homeAspect;
    private int floor;
    private BigDecimal homeSize;
    private HomeTypes homeType;
    private Countries country;
    private Cities city;
    private String district;
    private String neighborhood;
    private String street;
    private String buildingNo;
    private Long apartmentNo;
}
