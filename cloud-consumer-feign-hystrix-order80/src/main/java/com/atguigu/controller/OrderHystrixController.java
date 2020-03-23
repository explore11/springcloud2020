package com.atguigu.controller;

import com.atguigu.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "GlobalMethod")
public class OrderHystrixController {
    @Resource
    private OrderService orderService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return orderService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeOut/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
//            //3秒钟以内就是正常的业务逻辑
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return orderService.paymentInfo_TimeOut(id);
    }


    public String paymentInfoTimeOutHandler(Integer id) {
        return "消费者80  系统异常，请稍后重试";
    }
    //全局默认方法
    public String GlobalMethod() {
        return "GlobalMethod  消费者80  系统异常，请稍后重试";
    }

}
