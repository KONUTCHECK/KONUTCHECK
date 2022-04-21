package com.SeniorProject.konutcheck.app.general.exception;

import com.SeniorProject.konutcheck.app.general.exceptions.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class GenCustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final  ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest){
        Date errorDate = new Date();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);

        GenExceptionResponse genExceptionResponse =  new GenExceptionResponse(errorDate, message, description);

        return new ResponseEntity<>(genExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleDoesNotExistExceptions(DoesNotExistExceptions ex){
        Date errorDate = new Date();
        String message = ex.getBaseErrorMessage().getMessage();
        String detailMessage = ex.getBaseErrorMessage().getDetailMessage();

        GenExceptionResponse genExceptionResponse = new GenExceptionResponse(errorDate, message, detailMessage);

        return new ResponseEntity<>(genExceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleDuplicateExceptions(DuplicateException ex){
        Date errorDate = new Date();
        String message = ex.getBaseErrorMessage().getMessage();
        String detailMessage = ex.getBaseErrorMessage().getDetailMessage();

        GenExceptionResponse genExceptionResponse = new GenExceptionResponse(errorDate, message, detailMessage);

        return new ResponseEntity<>(genExceptionResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleInvalidInformationExceptions(InvalidInformationExceptions ex){
        Date errorDate = new Date();
        String message = ex.getBaseErrorMessage().getMessage();
        String detailMessage = ex.getBaseErrorMessage().getDetailMessage();

        GenExceptionResponse genExceptionResponse = new GenExceptionResponse(errorDate, message, detailMessage);

        return new ResponseEntity<>(genExceptionResponse, HttpStatus.CONFLICT);
    }
    @ExceptionHandler
    public final ResponseEntity<Object> handleAllItemNotFoundException(ItemNotFoundExceptions ex){

        Date errorDate = new Date();
        String message = ex.getBaseErrorMessage().getMessage();
        String detailMessage = ex.getBaseErrorMessage().getDetailMessage();

        GenExceptionResponse genExceptionResponse = new GenExceptionResponse(errorDate, message, detailMessage);

        return new ResponseEntity<>(genExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleEntityNotFoundExceptions(EntityNotFoundExceptions ex){
        GenExceptionResponse genExceptionResponse = new GenExceptionResponse();

        Date errorDate = new Date();

        if (ex.getGenericErrorMessage() != null){
            genExceptionResponse.setMessage(ex.getGenericErrorMessage());
            genExceptionResponse.setErrorDate(errorDate);
        }else{
            genExceptionResponse.setErrorDate(errorDate);
            genExceptionResponse.setMessage(ex.getBaseErrorMessage().getMessage());
            genExceptionResponse.setDetailMessage(ex.getBaseErrorMessage().getDetailMessage());
        }

        return new ResponseEntity<>(genExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Date errorDate = new Date();
        String message =  new StringBuilder(ex.getBindingResult().getFieldError().getField()).append(" field not valid.").toString();
        String detailMessage = ex.getBindingResult().getFieldError().getDefaultMessage();

        GenExceptionResponse genExceptionResponse = new GenExceptionResponse(errorDate, message, detailMessage);

        return new ResponseEntity<>(genExceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
