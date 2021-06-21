package com.example.demo.aop.aspect.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class BeforeAspect {

    @Before("execution(* *..calc..*ServiceImpl.*(..))")
    public void before(JoinPoint jp) {
        System.out.println("Before: " + jp.getSignature() + " (" + LocalDateTime.now() + ")");
    }
}
