//package com.nacos.demo.annotation;
//
//import com.alibaba.fastjson.JSON;
//import com.google.gson.Gson;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;
//
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Method;
//
///**
// * @description:
// * @Author: wub
// * @date 2019/11/20 11:56
// */
//@Slf4j
////@Aspect
////@Component
//public class WebLogAspect {
//
//    /** 换行符 */
//    private static final String LINE_SEPARATOR = System.lineSeparator();
//
//    /** 以自定义 @WebLog 注解为切点 */
//    @Pointcut("@annotation(com.nacos.demo.annotation.WebLog)")
//    public void webLog(){}
//
//    /**
//     * 环绕
//     * @return
//     */
//    @Around("webLog()")
//    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        long t1 = System.currentTimeMillis();
//        Object request = proceedingJoinPoint.proceed();
//        //打印出参
//        log.info("Request parms is : {}", new Gson().toJson(request ));
//        //执行耗时
//        log.info("Time-Consuming is : {} ms", System.currentTimeMillis() -t1);
//        return request;
//    }
//    @Before("webLog()")
//    public void deBefore(JoinPoint joinPoint)throws Exception{
//        //开始打印日志
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = requestAttributes.getRequest();
//
//        //获取 @WebLog 注解的描述信息
//        String methodDescription  = getAspectLogDescription(joinPoint);
//        // 打印请求相关参数
//        log.info("========================================== Start ==========================================");
//        // 打印请求 url
//        log.info("URL            : {}", request.getRequestURL().toString());
//        // 打印描述信息
//        log.info("Description    : {}", methodDescription);
//        // 打印 Http method
//        log.info("HTTP Method    : {}", request.getMethod());
//        // 打印调用 controller 的全路径以及执行方法
//        log.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
//        // 打印请求的 IP
//        log.info("IP             : {}", request.getRemoteAddr());
//        // 打印请求入参
//        log.info("Request Args   : {}", new Gson().toJson(joinPoint.getArgs()));
//    }
//
//    /**
//     * 在切点之后织入
//     * @throws Throwable
//     */
//    @After("webLog()")
//    public void doAfter() throws Throwable {
//        // 接口结束后换行，方便分割查看
//        log.info("=========================================== End ===========================================" + LINE_SEPARATOR);
//    }
//
//    /**
//     * 获取切面注解的描述
//     *
//     * @param joinPoint 切点
//     * @return 描述信息
//     * @throws Exception
//     */
//    public String getAspectLogDescription(JoinPoint joinPoint) throws Exception {
//        String targetName = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        Object[] arguments = joinPoint.getArgs();
//        Class targetClass = Class.forName(targetName);
//        Method[] methods = targetClass.getMethods();
//        StringBuilder description = new StringBuilder("");
//        for (Method method : methods) {
//            if (method.getName().equals(methodName)) {
//                Class[] clazzs = method.getParameterTypes();
//                if (clazzs.length == arguments.length) {
//                    description.append(method.getAnnotation(WebLog.class).description());
//                    break;
//                }
//            }
//        }
//        return description.toString();
//    }
//
//
//}
