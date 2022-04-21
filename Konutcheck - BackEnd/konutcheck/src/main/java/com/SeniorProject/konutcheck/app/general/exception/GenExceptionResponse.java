package com.SeniorProject.konutcheck.app.general.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenExceptionResponse {
    private Date errorDate;
    private String message;
    private String detailMessage;

}
