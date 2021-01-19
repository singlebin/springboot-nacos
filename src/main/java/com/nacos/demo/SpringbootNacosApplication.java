package com.nacos.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@NacosPropertySource(dataId = "bamboo.test", autoRefreshed = true)
@EnableDiscoveryClient
public class SpringbootNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootNacosApplication.class, args);
    }


//    @NacosValue(value = "${service.name:1}", autoRefreshed = true)
//    private String serverName;
//
//    @GetMapping(value = "/test")
//    @ResponseBody
//    public String get() {
//        return serverName;
//    }


}
