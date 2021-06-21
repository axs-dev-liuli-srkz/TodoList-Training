package com.example.demo.aop.aspect.pointcut;

import com.example.demo.aop.address.MyAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AnnotationPointcutAspect {
    @Before("@annotation(myAnnotation)")
    public void within(JoinPoint jp, MyAnnotation myAnnotation) {
        System.out.println("@annotation Pointcut: " + jp.getSignature() + " (" + LocalDateTime.now() + ")");
        System.out.println("MyAnnotation value: " + myAnnotation.value()); // アノテーションの値を取得
    }
}
