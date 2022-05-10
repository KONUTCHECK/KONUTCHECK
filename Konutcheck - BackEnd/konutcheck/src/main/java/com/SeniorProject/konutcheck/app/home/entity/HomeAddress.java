package com.SeniorProject.konutcheck.app.home.entity;

import com.SeniorProject.konutcheck.app.home.enums.Countries;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "HOME_ADDRESS")
@Getter
@Setter
public class HomeAddress {
    @Id
    @SequenceGenerator(name = "HomeAddress", sequenceName = "HOME_ADDRESS_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "HomeAddress")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "COUNTRY", length = 30, nullable = false)
    private Countries country;

    @Column(name = "CITY", length = 30, nullable = false)
    private String city;

    @Column(name = "DISTRICT", length = 50, nullable = false)
    private String district;

    @Column(name = "NEIGHBORHOOD", length = 50, nullable = false)
    private String neighborhood;

    @Column(name = "STREET", length = 50, nullable = false)
    private String street;

    @Column(name = "BUILDING_NO", length = 10)
    private String buildingNo;

    @Column(name = "APARTMENT_NO")
    private Long apartmentNo;
}
