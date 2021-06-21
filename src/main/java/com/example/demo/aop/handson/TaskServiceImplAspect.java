package com.example.demo.aop.handson;

import org.aspectj.lang.JoinPoint;

import java.time.LocalDateTime;

// 1 アノテーションを追加
public class TaskServiceImplAspect {

    // 2 アノテーションとpointcut式を追加
    public void before(JoinPoint jp) {
        System.out.println("Before: " + jp.getSignature() + " 実行日時: (" + LocalDateTime.now() + ")");
    }

    // 4 アノテーションとpointcut式を追加
    public void after(JoinPoint jp) {
        System.out.println("After: " + jp.getSignature() + " 実行日時: (" + LocalDateTime.now() + ")");
    }

    // 6 アノテーションとpointcut式を追加
    public void afterThrowing(JoinPoint jp, Exception e) {
        System.out.println("AfterThrowing: " + jp.getSignature());
        e.printStackTrace();
    }
}
