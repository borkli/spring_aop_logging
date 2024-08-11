package com.aop.app.aspect;

import com.aop.app.exception.ApplicationException;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Log4j2
@Aspect
@Component
@Order(2)
public class ExceptionHandlingAspect {

    /**
     * Оборачивает выбрасываемое исключение в {@link ApplicationException} и логирует
     * <p>Используется в каждом классе поката <em>com.aop.app.service</em>
     * @param joinPoint выполняемый процесс
     * @return the result of proceeding
     * @throws ApplicationException ошибка приложения
     */
    @Around("within(com.aop.app.service.*)")
    public Object serviceException(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Throwable ex) {
            log.error("Exception: ", ex);
            throw new ApplicationException(ex);
        }
    }
}
