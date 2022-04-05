package com.SeniorProject.konutcheck.app.home.entity;

import com.SeniorProject.konutcheck.app.home.enums.HomeAspects;
import com.SeniorProject.konutcheck.app.home.enums.HomeTypes;
import com.SeniorProject.konutcheck.app.home.enums.WarningSystems;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

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

}
