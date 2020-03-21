package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {
    //TODO 因zookeeper环境问题 未能实现正常操作 暂时弃用
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
