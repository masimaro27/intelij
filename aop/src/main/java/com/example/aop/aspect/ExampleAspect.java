package com.example.aop.aspect;


import com.example.aop.annotation.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExampleAspect {

    @Around("@annotation(let)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, LogExecutionTime let) throws Throwable {
        long start = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++ ) {
            log.info(String.format("parameter-%d : [%s], ",i ,args[i]));
        }

        Object proceed = joinPoint.proceed();

        log.info("[{}] - return: {}",joinPoint.getSignature().toShortString(), proceed.toString());
        long executionTime = System.currentTimeMillis() - start;
        log.info((joinPoint.getSignature() + " executed in " + executionTime + "ms"));

        return proceed;
    }


    /**
     * 전체 REQUEST
     * 비동기 AOP LOGGING
     */



}