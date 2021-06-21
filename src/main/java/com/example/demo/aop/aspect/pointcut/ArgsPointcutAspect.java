package com.example.demo.aop.aspect.pointcut;

import com.example.demo.aop.some.Some;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class ArgsPointcutAspect {

    @Before("target(com.example.demo.aop.some.SomeService) && args(some)")
    public void args(JoinPoint jp, Some some) {
        System.out.println("Args Pointcut(1): " + jp.getSignature() + " (" + LocalDateTime.now() + ") (some.id): " + some.getId());
    }

    @Before("target(com.example.demo.aop.some.SomeService) && args(int)")
    public void args2(JoinPoint jp) {
        System.out.println("Args Pointcut(2): " + jp.getSignature() + " (" + LocalDateTime.now() + ")");
    }
}
