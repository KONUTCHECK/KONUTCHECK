package com.SeniorProject.konutcheck.app.evaluation.dto;

import com.SeniorProject.konutcheck.app.user.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomesRelatedWithUsersDto {
    private Long id;
    private Long userId;
    private UserType userType;
    private Long homeId;
}
