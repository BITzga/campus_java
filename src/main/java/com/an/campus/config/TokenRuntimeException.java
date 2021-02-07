package com.an.campus.config;

public class TokenRuntimeException extends RuntimeException{
    private Integer code = 401;
    private String msg;

    public TokenRuntimeException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
