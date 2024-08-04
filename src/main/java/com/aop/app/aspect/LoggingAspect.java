package com.aop.app.aspect;

import com.aop.app.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("within(com.aop.app.service.*)")
    public void allServices() { }

    @Before("allServices()")
    public void beforeLog(JoinPoint joinpoint) {
        log.info(
            "Entering {} with args {}",
            joinpoint.getSignature().getName(),  //todo
            joinpoint.getArgs()
        );
    }

    @AfterReturning("allServices()")
    public void afterReturningLog(JoinPoint joinPoint, Object result) {
        log.info(
            "Exiting {} with result {}",
            joinPoint.getSignature().getName(), result
        );
    }

    @AfterThrowing("allServices()")
    public void afterThrowingLog(ApplicationException ex) {
        log.error("Exception: ", ex);
    }
}
