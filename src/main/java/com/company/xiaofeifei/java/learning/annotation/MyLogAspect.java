package com.company.xiaofeifei.java.learning.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @description: todo
 * @author: zouzhiyong@xiaomi.com
 * @date: 2022/01/12
 **/
@Component
@Aspect
@Slf4j
public class MyLogAspect {

    @Pointcut("@annotation(com.company.xiaofeifei.java.learning.annotation.MyLog)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MyLog myLog = ((MethodSignature) point.getSignature()).getMethod().getAnnotation(MyLog.class);
        log.info("yes into MyLog");
        log.info(myLog.value());
        return point.proceed();
    }

    @Before("logPointCut()")
    public void before(JoinPoint joinPoint) {
        log.info("before around");
        MyLog myLog = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(MyLog.class);
        log.info(myLog.value());
    }

    @After("logPointCut()")
    public void after(JoinPoint joinPoint) {
        log.info("after around");
    }
}
