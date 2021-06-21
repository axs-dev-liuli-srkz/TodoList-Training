package com.example.demo.aop.aspect.pointcut;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class WithinPointcutAspect {
    @Before("within(com.example.demo.aop..*)")
    public void within(JoinPoint jp) {
        System.out.println("Within Pointcut: " + jp.getSignature() + " (" + LocalDateTime.now() + ")");
    }
}
