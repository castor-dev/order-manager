package com.carloscastor.ordermanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class OrderMapperExceptionHandler {

    @ExceptionHandler(OMNotFoundException.class)
    public ResponseEntity resourceNotFoundException(OMNotFoundException exception, WebRequest request){
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OMBadRequestException.class)
    public ResponseEntity invalidOperationException(OMBadRequestException exception){
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
