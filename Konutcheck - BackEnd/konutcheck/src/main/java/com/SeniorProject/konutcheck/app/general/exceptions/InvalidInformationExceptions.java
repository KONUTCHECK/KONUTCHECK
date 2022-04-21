package com.SeniorProject.konutcheck.app.general.exceptions;

import com.SeniorProject.konutcheck.app.general.exceptionEnums.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InvalidInformationExceptions extends BusinessExceptions{
    public InvalidInformationExceptions(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
