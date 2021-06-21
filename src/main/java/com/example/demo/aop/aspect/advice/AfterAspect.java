package com.example.demo.aop.aspect.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AfterAspect {
    @After("execution(* *..calc..*ServiceImpl.*(..))")
    public void after(JoinPoint jp) {
        System.out.println("After: " + jp.getSignature() + " (" + LocalDateTime.now() + ")");
    }
}
