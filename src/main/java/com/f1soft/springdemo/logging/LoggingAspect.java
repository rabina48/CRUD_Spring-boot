package com.f1soft.springdemo.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author Rabina
 */


@Component
@Aspect

public class LoggingAspect {

    @Before("execution(* com.f1soft.springdemo.services.UserServicesImpl.getAllUser(..))")
    public void getNameAdvice(){
        System.out.println("Executing Advice on getName()");
    }


    @Around("execution(* com.f1soft.springdemo.services.UserServicesImpl.getAllUser(..))")
    public Object getUser(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("User getName()");
        System.out.println("BEFORE User getName()is running");//Before calling the method it execute upto here

        final Object proceed = proceedingJoinPoint.proceed();// it will call the addUser method

        System.out.println("AFTER User getName()is running");// after executing the addUser method this part will execute

       return proceed;
    }


    @AfterReturning(
            pointcut = "execution(* com.f1soft.springdemo.services.UserServicesImpl.getAllUser(..))",
            returning = "data")
    public void getUserAfterReturning(JoinPoint JoinPoint, Object data) throws Throwable {

        System.out.println("User getName()");
        System.out.println("BEFORE User getName()is running");

        JoinPoint.getSignature().getName();

        System.out.println("AFTER User getName()is running");
    }



    @AfterThrowing(
            pointcut = "execution(* com.f1soft.springdemo.services.UserServicesImpl.addUser(..))",
            throwing = "exception")
    public void getUserAfterReturning(JoinPoint JoinPoint, Throwable exception) throws Throwable {

        System.out.println("User getName()");
        System.out.println("BEFORE User getName()is running");



        System.out.println("AFTER User getName()is running" +JoinPoint.getSignature().getName());
    }

}
