package com.an.campus.config;

import com.an.campus.constants.StateEnum;
import com.an.campus.dto.QResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SysRuntimeExceptionHandler {

    @ExceptionHandler(TokenRuntimeException.class)
    public QResult<Object> tokenRuntimeException(TokenRuntimeException e) {
        e.printStackTrace();
        return new QResult<Object>( e.getMsg(), StateEnum.ERROR.getState());
    }

    @ExceptionHandler(Exception.class)
    public  QResult<Object>  handlerException(Exception e) {
        e.printStackTrace();
        return new QResult<Object>(e.getMessage(), StateEnum.ERROR.getState());

    }
}
