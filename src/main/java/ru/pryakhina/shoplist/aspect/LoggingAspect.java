package ru.pryakhina.shoplist.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/** Класс LoggingAspect для реализации логирования*/
@Component
@Aspect
public class LoggingAspect {

    /** Функция логирования - отслеживание запуска методов
     * в ru.pryakhina.shoplist.dao.
     * Получение имени запускаемого метода логирование начала и оканцания выполнения
     * @param proceedingJoinPoint
     * @return targetMethodResult*/
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
