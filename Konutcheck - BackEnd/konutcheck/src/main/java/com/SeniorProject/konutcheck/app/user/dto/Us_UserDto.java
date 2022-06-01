package com.SeniorProject.konutcheck.app.user.dto;

import com.SeniorProject.konutcheck.app.user.enums.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Us_UserDto {
    private Long Id;
    private String name;
    private String surname;
    private Long age;
    private UserType userType;
    private Genders gender;
    private EducationalStatus educationalStatus;
    private String job;
    private MaritialStatus maritialStatus;
    private String email;
    private String userPhoneNumber1;
    private String userPhoneNumber2;
    private String password;
    private StatusType statusType;
}
