package com.atguigu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope    //动态刷新配置  添加对外暴露的接口 添加注解后 需要post请求一下  curl -X POST "http://localhost:3355/actuator/refresh"
public class ConfigController {
    @Value("${s1pring.application.name}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
