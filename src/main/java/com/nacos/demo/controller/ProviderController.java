package com.nacos.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.demo.annotation.WebLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wub
 */
@RestController
public class ProviderController {

    Logger logger= LoggerFactory.getLogger(ProviderController.class);

    @Autowired
    DiscoveryClient discoveryClient;



    @GetMapping("/hi")
    @SentinelResource("hi")
    @WebLog(description = "测试接口")
    public String hi(@RequestParam(value = "name",defaultValue = "forezp",required = false)String name){

        return "hi "+name;
    }


    @GetMapping("/services")
    public String getServices(){
        List<String> serviceNames=discoveryClient.getServices();

        StringBuilder stringBuilder=new StringBuilder();
        for (String s: serviceNames){
            stringBuilder.append(s).append("\n");
            List<ServiceInstance> serviceInstances=discoveryClient.getInstances(s);
            if(serviceInstances!=null&&serviceInstances.size()>0){
                for (ServiceInstance serviceInstance: serviceInstances){
                    logger.info("Finished message serviceName : {}, ip : {}, port : {}", s , serviceInstance.getHost(), serviceInstance.getPort());
                }
            }
        }
        return stringBuilder.toString();
    }


}
