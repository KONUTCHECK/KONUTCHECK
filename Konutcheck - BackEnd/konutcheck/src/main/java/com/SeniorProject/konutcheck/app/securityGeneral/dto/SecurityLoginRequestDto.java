package com.SeniorProject.konutcheck.app.securityGeneral.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityLoginRequestDto {
    private String email;
    private String password;
}
