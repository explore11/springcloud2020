package com.atguigu.controller;

import com.atguigu.entities.CommonResult;
import com.atguigu.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    //    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CONSUL-PROVIDER-SERVICE";

    @GetMapping("/consumer/payment/consul")
    public String getPaymentConsul() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul",String.class);
    }

}
