package com.nacos.demo.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @Author: wub
 * @date 2019/11/13 16:51
 */
@RestController
@RefreshScope
@NacosPropertySource(dataId = "bamboo.test", autoRefreshed = true)
public class TestController {
//    @Value("${info.test}")
//    private String test;
//
//    @GetMapping("/test1")
//    public String test1(){
//        return test;
//    }



    @NacosInjected
    private ConfigService configService;


    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public boolean get() {
        return useLocalCache;
    }

    @NacosValue(value = "${service.name:1}", autoRefreshed = true)
    private String serverName;

    @GetMapping(value = "/test")
    @ResponseBody
    public String getName() {
        return serverName;
    }

    @GetMapping(value = "/publish")
    @ResponseBody
    public ResponseEntity<String> publish(@RequestParam String dataId,
                                          @RequestParam(defaultValue = "DEFAULT_GROUP") String group,
                                          @RequestParam String content) throws NacosException {
        boolean result = configService.publishConfig(dataId, group, content);
        if (result) {
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Fail", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
