package com.f1soft.springdemo.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author Rabina
 */
@Aspect
@Component
public class ExecutionTimeTrack {

Logger logger = LoggerFactory.getLogger(ExecutionTimeTrack.class);


    @Around("@annotation(com.f1soft.springdemo.logging.TrackExecutionTime)")
    public Object  tracktime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();

        logger.info("Method name "+proceedingJoinPoint.getSignature()+"time taken to execute : "+(endTime-startTime));
        return object;
    }
}
