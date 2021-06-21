package com.example.demo.aop.aspect.pointcut;

import com.example.demo.aop.some.SomeService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class TargetPointcutAspect {

    @Before("target(com.example.demo.aop.some.SomeService)")
    public void target(JoinPoint jp) {
        System.out.println("Target Pointcut(1): " + jp.getSignature() + " (" + LocalDateTime.now() + ")");
    }

    @Before("target(service)")
    public void target2(JoinPoint jp, SomeService service) {
        System.out.println("Target Pointcut(2): " + jp.getSignature() + " (" + LocalDateTime.now() + ")");
    }
}
