package com.aop.app.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Log4j2
@Aspect
@Component
@Order(1)
public class LoggingAspect {

    @Pointcut("within(com.aop.app.service.*)")
    public void allServices() { }

    @Before("allServices()")
    public void beforeLog(JoinPoint joinPoint) {
        log.info(
            "Entering {} with args {}",
            joinPoint.getSignature().toShortString(),
            joinPoint.getArgs()
        );
    }

    @AfterReturning(value = "allServices()", returning = "result")
    public void afterReturningLog(JoinPoint joinPoint, Object result) {
        log.info(
            "Exiting {} with result {}",
            joinPoint.getSignature().toShortString(), result
        );
    }

//    @AfterThrowing("allServices()")
//    public void afterThrowingLog(ApplicationException ex) {
//        log.error("Exception: ", ex);
//    }
}
