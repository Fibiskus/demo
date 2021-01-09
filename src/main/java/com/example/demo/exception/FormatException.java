package com.example.demo.exception;

public class FormatException extends RuntimeException {
    private HTTP httpCode;
    public FormatException(String msg, HTTP httpCode) {
        super(msg);
        this.httpCode = httpCode;
    }

    public HTTP getHttpCode() {
        return httpCode;
    }
}