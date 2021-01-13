package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
class GlobalControllerExceptionHandler {

    @ExceptionHandler(FormatException.class)
    public ResponseEntity<String> handleError(final FormatException ex, final WebRequest request) {
        final String body = "Unknown exception with code - " + ex.getHttpCode().getCode() + ", and message - " + ex.getMessage();
        return new ResponseEntity<String>(body, HttpStatus.valueOf(ex.getHttpCode().getCode()));
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class )
    public ResponseEntity<Object> handleServiceException(final MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FormatException(ex.getMessage(), HTTP.HTTP_400));
    }
}