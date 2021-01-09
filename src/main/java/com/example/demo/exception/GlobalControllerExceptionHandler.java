package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
class GlobalControllerExceptionHandler {

    @ExceptionHandler(FormatException.class)
    public ResponseEntity<String> handleError(FormatException ex, WebRequest request) {
        String body = "Unknown exception with code - " + ex.getHttpCode().getCode() + ", and message - " + ex.getMessage();
        return new ResponseEntity<String>(body, HttpStatus.valueOf(ex.getHttpCode().getCode()));
    }
}