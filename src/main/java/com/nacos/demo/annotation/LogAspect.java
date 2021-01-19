//package com.nacos.demo.annotation;
//
//import com.xxl.job.core.util.DateUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//
///**
// * @description:
// * @Author: wub
// * @date 2019/11/20 15:11
// */
//@Aspect
//@Component
//@Slf4j
//public class LogAspect {
//
//    @Pointcut("execution(* com.nacos.demo.controller ..*.*(..)))")
//    public void logAroud(){
//    }
//
//    @Around("logAroud()")
//    public void logController(ProceedingJoinPoint proceedingJoinPoint){
//        //时间
//        long start = System.currentTimeMillis();
//        //接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        // 记录下请求内容
//        log.info("请求开始----"+ start);
//        log.info("URL : " + request.getRequestURL());
//        log.info("HTTP_METHOD : " + request.getMethod());
//        log.info("IP : " + request.getRemoteAddr());
//        log.info("CLASS_METHOD : " + proceedingJoinPoint.getSignature().getDeclaringTypeName() + "_" + proceedingJoinPoint.getSignature().getName());
//        log.info("ARGS : " + Arrays.toString(proceedingJoinPoint.getArgs()));
//        try {
//            proceedingJoinPoint.proceed();
//            long end = System.currentTimeMillis();
//            log.info("请求结束----"+(end-start)+"毫秒");
//        } catch (Throwable throwable) {
//            log.info("URL : " + request.getRequestURL());
//            log.info("IP : " + request.getRemoteAddr());
//            log.info("CLASS_METHOD : " + proceedingJoinPoint.getSignature().getDeclaringTypeName() + "_" + proceedingJoinPoint.getSignature().getName());
//        }
//    }
//}
