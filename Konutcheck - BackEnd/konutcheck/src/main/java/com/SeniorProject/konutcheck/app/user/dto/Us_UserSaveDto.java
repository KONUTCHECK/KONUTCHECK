package com.SeniorProject.konutcheck.app.user.dto;

import com.SeniorProject.konutcheck.app.user.enums.EducationalStatus;
import com.SeniorProject.konutcheck.app.user.enums.Genders;
import com.SeniorProject.konutcheck.app.user.enums.MaritialStatus;
import com.SeniorProject.konutcheck.app.user.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Us_UserSaveDto {
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
}
