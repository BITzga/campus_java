package com.an.campus.config;

import com.an.campus.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        if(token==null||"".equals(token)){
            System.out.println("未登录");
            throw new TokenRuntimeException("未登录");
        }
        Claims claim = jwtUtils.verify(token);
        if(claim==null){
            System.out.println("解析错误");
            throw new TokenRuntimeException("解析错误");
        }
        Date expiration = claim.getExpiration();
        if(jwtUtils.isTokenExpired(expiration)){
            System.out.println("过期");
            throw new TokenRuntimeException("过期");

        }
        return true;

    }
}
