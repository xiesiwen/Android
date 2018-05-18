package com.example.xiejingwen.m2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import android.util.Log;

/**
 * Created by lingyi.mly on 2016/5/27.
 */
@Aspect
public class TraceAspect {
    private String TAG = "aspect";
    private static final String POINT_METHOD = "execution(* com.example.xiejingwen.m2.ui.MainActivity.*(..))";
    private static final String POINT_CALLMETHOD = "call(* com.example.xiejingwen.m2.ui.MainActivity.*(..))";
    
    @Pointcut(POINT_METHOD)
    public void methodAnnotated() {}

    @Pointcut(POINT_CALLMETHOD)
    public void methodCallAnnotated() {}

    @Around("methodAnnotated()")
    public Object aronudWeaverPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e(TAG, "----------------------------->aroundWeaverPoint name is " + joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }

    @Before("methodCallAnnotated()")
    public void beforecall(JoinPoint joinPoint) {
        Log.e(TAG, "beforecall name is " + joinPoint.getSignature().getName());
    }
}
