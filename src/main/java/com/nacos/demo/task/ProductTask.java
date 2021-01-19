//package com.nacos.demo.task;
//
//import com.xxl.job.core.biz.model.ReturnT;
//import com.xxl.job.core.handler.IJobHandler;
//import com.xxl.job.core.handler.annotation.JobHandler;
//import org.springframework.stereotype.Component;
//
///**
// * @description: xxl-job 分布式调度中心
// * @Author: wub
// * @date 2019/11/19 10:56
// */
//@JobHandler(value="demoJobHandler")
//@Component
//public class ProductTask extends IJobHandler {
//    @Override
//    public ReturnT<String> execute(String s) throws Exception {
//        System.out.println("xxl-job is start .......");
//        return SUCCESS;
//    }
//}
