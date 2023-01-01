package com.zy.usercenteradmin.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@EnableAspectJAutoProxy
@Aspect
@Component
public class LogHandler {
    @Pointcut("execution(* com.zy.usercenteradmin.controller.*.*(..))")
    public void pointcut() {

    }

    @Before(value = "pointcut()")
    public void before(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String captchaKey = request.getHeader("cookie");
        System.out.println(captchaKey);
        Object target = joinPoint.getTarget();
        System.out.println(target);
        System.out.println("haha");
    }
}
