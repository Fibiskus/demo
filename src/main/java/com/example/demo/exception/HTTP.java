package com.example.demo.exception;

public enum HTTP {
    HTTP_200(200), HTTP_300(300), HTTP_400(400), HTTP_500(500);

    private final int code;

    HTTP(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}