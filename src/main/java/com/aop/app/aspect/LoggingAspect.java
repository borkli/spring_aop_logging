package com.aop.app.aspect;

import com.aop.app.exception.ApplicationException;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
    public void beforeLog(JoinPoint joinpoint) {
        log.info(
            "Entering {} with args {}",
            joinpoint.getSignature().toShortString(),  //todo
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

//    @AfterThrowing("allServices()")
//    public void afterThrowingLog(ApplicationException ex) {
//        log.error("Exception: ", ex);
//    }
}
