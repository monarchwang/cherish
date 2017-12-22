package com.monarchwang.website.common;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 切面拦截打印http请求
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut("execution(public * com.monarchwang.website.controller.*Controller.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //打印url、method、ip、类方法、参数
        logger.info("HttpAspect ---- url: {}, method: {}, ip: {}, class_method: {}, args: {}", request.getRequestURL(), request.getMethod(), request.getRemoteAddr(), joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
                JSON.toJSONString(joinPoint.getArgs()));

    }

    @After("log()")
    public void doAfter() {

    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.debug("response={}", object != null ? object.toString() : "");
    }

}