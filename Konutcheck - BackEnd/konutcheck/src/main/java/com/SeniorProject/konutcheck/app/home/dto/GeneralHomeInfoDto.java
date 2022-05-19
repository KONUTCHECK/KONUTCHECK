package com.SeniorProject.konutcheck.app.home.dto;

import com.SeniorProject.konutcheck.app.home.enums.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class GeneralHomeInfoDto {

    private Long id;
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
    private LocalDate announcementDate;

}
