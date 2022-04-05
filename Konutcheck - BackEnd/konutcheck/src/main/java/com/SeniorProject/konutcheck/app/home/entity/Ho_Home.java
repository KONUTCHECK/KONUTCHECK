package com.SeniorProject.konutcheck.app.home.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="HO_HOME")
@Getter
@Setter
public class Ho_Home {
    @Id
    @SequenceGenerator(name = "Ho_Home", sequenceName = "HO_HOME_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "Ho_Home")
    private Long Id;

    @Column(name = "ANNOUNCEMENT_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date announcementDate;

    @Column(name="GENERAL_HOME_INFO_ID", nullable = false)
    private Long generalHomeInfoId;




}
