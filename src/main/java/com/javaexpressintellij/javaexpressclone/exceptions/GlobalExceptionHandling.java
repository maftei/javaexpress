package com.javaexpressintellij.javaexpressclone.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {
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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {

        List<String> details = new ArrayList<>();

        for (ObjectError error: ex.getBindingResult().getAllErrors()){
            details.add(error.getDefaultMessage());

        }

        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),"Validation Error",details);

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }

}
