package com.javaexpressintellij.javaexpressclone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandling {
    //BadRequest
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleException(ProductNotFoundException ex) {

        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());

        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),"Client Error",details);

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }


    //internal server error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception ex) {

        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());

        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),"Server Error",details);

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
