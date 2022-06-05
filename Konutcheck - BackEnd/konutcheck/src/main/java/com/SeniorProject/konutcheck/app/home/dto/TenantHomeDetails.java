package com.SeniorProject.konutcheck.app.home.dto;

import com.SeniorProject.konutcheck.app.home.enums.Cities;
import com.SeniorProject.konutcheck.app.home.enums.Countries;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TenantHomeDetails {
    private final Long tenantId;
    private final Long tenantHomeId;
    private final String tenantName;
    private final String tenantSurname;
    private final Countries country;
    private final Cities city;
    private final String district;
    private final String neighborhood;
    private final String street;
    private final String buildingNo;
    private final Long apartmentNo;
}
