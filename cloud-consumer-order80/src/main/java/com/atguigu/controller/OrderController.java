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

    public static final String PAYMENT_URL = "http://localhost:8001";

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("******* 入参 "+id);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> createPayment(@RequestBody Payment payment){
        log.info("******* 入参 "+payment);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
}
