package com.SeniorProject.konutcheck.app.home.dto;

import com.SeniorProject.konutcheck.app.home.enums.Cities;
import com.SeniorProject.konutcheck.app.home.enums.Countries;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeAddressSaveDto {
    private Countries country;
    private Cities city;
    private String district;
    private String neighborhood;
    private String street;
    private String buildingNo;
    private Long apartmentNo;
}
