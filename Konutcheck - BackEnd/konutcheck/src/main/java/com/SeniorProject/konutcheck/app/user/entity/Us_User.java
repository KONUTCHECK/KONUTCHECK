package com.SeniorProject.konutcheck.app.user.entity;

import com.SeniorProject.konutcheck.app.user.enums.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "US_USER")
@Getter
@Setter
public class Us_User {

    @Id
    @SequenceGenerator(name = "Us_User", sequenceName = "US_USER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "Us_User")
    private Long Id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surname;

    @Column(name = "AGE", nullable = false)
    private Long age;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE", length = 30, nullable = false)
    private UserType userType;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER", length = 30, nullable = false)
    private Genders gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "EDUCATIONAL_STATUS", length = 30, nullable = false)
    private EducationalStatus educationalStatus;

    @Column(name = "JOB", length = 50, nullable = false)
    private String job;

    @Enumerated(EnumType.STRING)
    @Column(name = "MARITIAL_STATUS", length = 30, nullable = false)
    private MaritialStatus maritialStatus;

    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @Column(name = "USER_PHONE_NUMBER1", length = 11, nullable = false)
    private String userPhoneNumber1;

    @Column(name = "USER_PHONE_NUMBER2", length = 11, nullable = false)
    private String userPhoneNumber2;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_TYPE", nullable = false, length = 30)
    private StatusType statusType;
}





/*
@Entity
@Table(name = "USER")
@Getter
@Setter
public class User {

    @Id
    @SequenceGenerator(name = "User", sequenceName = "USER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "User")
    private Long id;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "SURNAME", length = 100)
    private String surname;

    @Column(name = "AGE")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "MARITIAL_STATUS", length = 30)
    private MaritialStatusEnums maritialStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE", length = 30)
    private UserTypeEnums userType;

    @Column(name = "EMAIL", length = 100)
    private String mail;

    @Column(name = "PHONE_NUMBER_1")
    private Long phoneNumber1;

    @Column(name = "PHONE_NUMBER_2")
    private Long phoneNumber2;

    @Column(name = "PASSWORD")
    private String password;
}*/
