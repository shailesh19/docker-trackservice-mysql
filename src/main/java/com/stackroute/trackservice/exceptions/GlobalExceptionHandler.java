package com.stackroute.trackservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(value = {TrackAlreadyExistsException.class, TrackNotFoundException.class})
    protected ResponseEntity<Object> handleConflict(Exception exep)
    {
        return new ResponseEntity<>(exep.getMessage(), HttpStatus.NOT_FOUND);
    }


}
