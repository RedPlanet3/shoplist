package ru.pryakhina.shoplist.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Around("execution(* ru.pryakhina.shoplist.dao.*.*(..))")
    public Object aroundAllRepositoryMethodAdvice(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        MethodSignature methodSignature =
                (MethodSignature)proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println("Begin of " + methodName);

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println("End of " + methodName);
        return targetMethodResult;
    }
}
