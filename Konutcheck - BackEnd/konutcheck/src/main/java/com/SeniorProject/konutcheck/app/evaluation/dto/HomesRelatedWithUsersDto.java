package com.SeniorProject.konutcheck.app.evaluation.dto;

import com.SeniorProject.konutcheck.app.user.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Getter
@Setter
public class HomesRelatedWithUsersDto {
    private Long id;
    private Long userId;
    private UserType userType;
    private Long homeId;
}

