package com.example.auth_module.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static com.example.auth_module.constant.Constants.POINT_CUT;
import static com.example.auth_module.constant.Constants.RESULT;

@Component
@Aspect
public class UserActionListener {

    @AfterReturning(value = POINT_CUT, returning = RESULT)
    public void catchUserRegistrationLogic(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        String string = result.toString();
    }
}
