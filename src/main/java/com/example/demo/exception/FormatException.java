package com.example.demo.exception;

public class FormatException extends RuntimeException {
    private final HTTP httpCode;

    public FormatException(final String msg, final HTTP httpCode) {
        super(msg);
        this.httpCode = httpCode;
    }

    public HTTP getHttpCode() {
        return httpCode;
    }
}