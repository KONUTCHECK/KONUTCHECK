package com.SeniorProject.konutcheck.app.general.exceptions;

import com.SeniorProject.konutcheck.app.general.exceptionEnums.BaseErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BusinessExceptions extends  RuntimeException{
    private BaseErrorMessage baseErrorMessage;
}