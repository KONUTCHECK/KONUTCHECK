package com.SeniorProject.konutcheck.app.home.entity;

import com.SeniorProject.konutcheck.app.home.enums.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "GENERAL_HOME_INFO")
@Getter
@Setter
public class GeneralHomeInfo {

    @Id
    @SequenceGenerator(name = "generalHomeInfo", sequenceName = "GENERAL_HOME_INFO_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "generalHomeInfo")
    private Long id;

    @Column(name = "AMOUNT", precision = 19, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "DEPOSIT", precision = 19, scale = 2, nullable = false)
    private BigDecimal deposit;

    @Column(name = "DUES", precision = 19, scale = 2, nullable = false)
    private BigDecimal dues;

    @Column(name = "NUMBER_OF_ROOMS", nullable = false, length = 8)
    private String numberOfRooms;

    @Enumerated(EnumType.STRING)
    @Column(name = "WARNING_SYSTEM", length = 30, nullable = false)
    private WarningSystems warningSystem;

    @Column(name = "BUILDING_AGE", nullable = false, length = 10)
    private String buildingAge;

    @Enumerated(EnumType.STRING)
    @Column(name = "HOME_ASPECT", length = 30, nullable = false)
    private HomeAspects homeAspect;

    @Column(name = "FLOOR", nullable = false)
    private int floor;

    @Column(name = "HOME_SIZE", precision = 19, scale = 2, nullable = false)
    private BigDecimal homeSize;

    @Enumerated(EnumType.STRING)
    @Column(name = "HOME_TYPE", length = 30, nullable = false)
    private HomeTypes homeType;

    @Enumerated(EnumType.STRING)
    @Column(name = "COUNTRY", length = 30, nullable = false)
    private Countries country;

    @Enumerated(EnumType.STRING)
    @Column(name = "CITY", length = 30, nullable = false)
    private Cities city;

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

    @Column(name = "ANNOUNCEMENT_DATE", nullable = false)
    @JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate announcementDate;

    @Column(name = "HOME_OWNER", nullable = false)
    private Long homeOwner;

}
