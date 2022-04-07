package com.SeniorProject.konutcheck.app.home.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class Ho_HomeDto {
    private Long Id;
    private LocalDate announcementDate;
    private Long generalHomeInfoId;
}
