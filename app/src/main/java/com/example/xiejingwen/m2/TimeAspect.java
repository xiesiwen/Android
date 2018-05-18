package com.example.xiejingwen.m2;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by xiejingwen on 2018/4/20.
 */

@Aspect
public class TimeAspect {

    @Pointcut("execution(@com.example.xiejingwen.m2.TimeLog * *(..))")
    public void methodAnnotated(){

    }

    @Pointcut("execution(@com.example.xiejingwen.m2.TimeLog *.new(..))")
    public void constructorAnnotated(){

    }

    @Around("methodAnnotated() || constructorAnnotated() && @annotation(timeLog)")//在连接点进行方法替换
    public Object aroundJoinPoint(ProceedingJoinPoint joinPoint, TimeLog timeLog) throws Throwable {
        String string = timeLog.value();
        int a = timeLog.a();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        long startTime = System.nanoTime();
        Object result = joinPoint.proceed();//执行原方法
        StringBuilder keyBuilder = new StringBuilder();
        keyBuilder.append(methodName + ":");
        for (Object obj : joinPoint.getArgs()) {
            if (obj instanceof String) keyBuilder.append((String) obj);
            else if (obj instanceof Class) keyBuilder.append(((Class) obj).getSimpleName());
        }
        String key = keyBuilder.toString();
        return result;
    }

    @Before("methodAnnotated() || constructorAnnotated() && @annotation(timeLog1)")//在连接点进行方法替换
    public void beforePoint(ProceedingJoinPoint joinPoint, TimeLog timeLog1) throws Throwable {
        Log.e("xsw", "before point time is " + timeLog1.a());
    }
}
