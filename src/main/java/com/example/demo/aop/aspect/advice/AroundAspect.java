package com.example.demo.aop.aspect.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AroundAspect {
    @Around("execution(* *..calc..*ServiceImpl.*(..))")
    public Object before(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("Around [実行前]: " + jp.getSignature() + " (" + LocalDateTime.now() + ")");
        try {
            Object retValue = jp.proceed(); // Join Pointの実行 (戻り値はJoin Pointの戻り値となる)
            System.out.println("Around [正常終了]: " + jp.getSignature() + " (" + LocalDateTime.now() + ") (戻り値): " + retValue);
            return retValue;
        } catch (Throwable throwable) {
            System.out.println("Around [例外発生]: " + jp.getSignature() + " (" + LocalDateTime.now() + ")");
            throwable.printStackTrace();
            throw throwable;
        }
    }
}
