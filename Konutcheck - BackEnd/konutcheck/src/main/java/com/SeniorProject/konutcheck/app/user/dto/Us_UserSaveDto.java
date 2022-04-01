package com.SeniorProject.konutcheck.app.user.dto;

import com.SeniorProject.konutcheck.app.user.enums.MaritialStatusEnums;
import com.SeniorProject.konutcheck.app.user.enums.UserTypeEnums;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Us_UserSaveDto {
    private String name;
    private String surname;
    private Long age;
    private UserTypeEnums userType;
    private MaritialStatusEnums maritialStatus;
    private String email;
    private String userPhoneNumber1;
    private String userPhoneNumber2;
    private String password;
}
