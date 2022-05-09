package com.SeniorProject.konutcheck.app.evaluation.dto;

import com.SeniorProject.konutcheck.app.home.enums.HomeAspects;
import com.SeniorProject.konutcheck.app.home.enums.HomeTypes;
import com.SeniorProject.konutcheck.app.home.enums.WarningSystems;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class UserHomeDetails {
    private final Long id;
    private final Long userId;
    private final HomeTypes homeType;
    private final BigDecimal amount;
    private final BigDecimal deposit;
    private final BigDecimal dues;
    private final String numberOfRooms;
    private final WarningSystems warningSystem;
    private final String buildingAge;
    private final HomeAspects homeAspect;
    private final int floor;
    private final BigDecimal homeSize;
    private final LocalDate announcementDate;

}
