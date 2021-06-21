package com.example.demo.aop.aspect.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AfterThrowingAspect {
    @AfterThrowing(value = "execution(* *..calc..*ServiceImpl.*(..))", throwing = "e")
    public void afterThrowing(JoinPoint jp, IllegalArgumentException e) {
        System.out.println("AfterThrowing: " + jp.getSignature() + " (" + LocalDateTime.now() + ")");
        e.printStackTrace();
    }
}
