package com.nacos.demo.annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @Author: wub
 * @date 2019/11/20 11:48
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface WebLog {
    /**
     * 日志描述信息
     * @return
     */
    String description() default "";

}
