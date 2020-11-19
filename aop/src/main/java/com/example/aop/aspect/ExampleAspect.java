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
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @Before (이전) : 어드바이스 타겟 메소드가 호출되기 전에 어드바이스 기능을 수행
 * @After (이후) : 타겟 메소드의 결과에 관계없이(즉 성공, 예외 관계없이) 타겟 메소드가 완료 되면 어드바이스 기능을 수행
 * @AfterReturning (정상적 반환 이후)타겟 메소드가 성공적으로 결과값을 반환 후에 어드바이스 기능을 수행
 * @AfterThrowing (예외 발생 이후) : 타겟 메소드가 수행 중 예외를 던지게 되면 어드바이스 기능을 수행
 * @Around (메소드 실행 전후) : 어드바이스가 타겟 메소드를 감싸서 타겟 메소드 호출전과 후에 어드바이스 기능을 수행
 *
 *
 *
 * Pointcut Expression
 * 1. within
 *      within(some.package.SomeService)
 *          - SomeService 인터페이스 내 모든 메서드 호출
 *      within(some.package.*)
 *          - some.package 패키지 내 모든 메서드 호출
 *      within(some.package..*)
 *          - some.package 패키지 및 하위 패키지 내 모든 메서드 호출
 * 2. execution
 *      - 기본 형식 :
 *          "*" 는 모든 값을 의미
 *          ".." 는 0개 이상 의미
 *      execution([수식어] [리턴타입] [클래스이름] [이름]([파라미터])
 *      - 예제
 *          execution(* some.package.*.*())
 *              - some.package 패키지 내
 *              - 파라미터가 없는 모든 메서드 호출
 *          execution(* some.package..*.*(..))
 *              - some.package 패키지와 하위 패키지에 있는
 *              - 파라미터가 0개 이상인 모든 메서드 호출
 *          execution(String some.package.SomeService.someMethod(..))
 *              - 리턴 타입이 String,
 *              - some.package.SomeService 인터페이스 내
 *              - 파라미터가 0개 이상인 someMethod 메서드 호출
 *          execution(* some*(*))
 *              - 메서드 이름이 some으로 시작되고,
 *              - 파라미터가 1개인 메서드 호출
 *          execution(* some*(*, *))
 *              - 메서드 이름이 some으로 시작되고,
 *              - 파라미터가 2개인 메서드 호출
 *          execution(* some*(String, ..))
 *              - 메서드 이름이 some으로 시작되고,
 *              - 첫번째 파라미터 타입이 String,
 *              - 파라미터가 1개 이상인 메서드 호출
 * 3. bean
 *
 */
@Aspect
@Component
@Slf4j
@ConditionalOnProperty(
        value = "file-processing.logging.enabled",
        havingValue = "true",
        matchIfMissing = true)
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
     *
     */

    /**
     * 전체 REQUEST
     * 비동기 AOP LOGGING
     */



}