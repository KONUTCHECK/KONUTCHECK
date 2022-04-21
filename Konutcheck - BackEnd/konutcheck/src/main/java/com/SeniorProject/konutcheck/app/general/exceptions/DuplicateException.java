package com.SeniorProject.konutcheck.app.general.exceptions;

import com.SeniorProject.konutcheck.app.general.exceptionEnums.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateException extends BusinessExceptions{
    public DuplicateException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
