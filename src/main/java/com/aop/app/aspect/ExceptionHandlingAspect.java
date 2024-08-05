package com.aop.app.aspect;

import com.aop.app.exception.ApplicationException;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Log4j2
@Aspect
@Component
public class ExceptionHandlingAspect {

    @Around("within(com.aop.app.service.*)")
    public void serviceException(ProceedingJoinPoint joinPoint) {
        try {
            joinPoint.proceed();
        } catch (Throwable ex) {
            log.error("Exception: ", ex);
            throw new ApplicationException(ex);
        }
    }
}
