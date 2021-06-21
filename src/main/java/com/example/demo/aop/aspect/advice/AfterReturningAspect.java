package com.example.demo.aop.aspect.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AfterReturningAspect {

    @AfterReturning(value = "execution(* *..calc..*ServiceImpl.*(..))", returning = "retValue")
    public void afterThrowing(JoinPoint jp, int retValue) {
        System.out.println("AfterReturning: " + jp.getSignature() + " (" + LocalDateTime.now() + ")  (戻り値): " + retValue);
    }
}
