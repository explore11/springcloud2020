package com.atguigu.controller;

import com.atguigu.entities.CommonResult;
import com.atguigu.entities.Payment;
import com.atguigu.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/timeOut")
    public String timeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/lb")
    public String getPort() {
        return serverPort;
    }

    @PostMapping("/create")
    public CommonResult creatPayment(@RequestBody Payment payment) {
        int num = paymentService.creatPayment(payment);
        log.info("****** 保存  creatPayment " + num);
        if (num > 0) {
            return new CommonResult(200, "保存成功, serverPort" + serverPort, num);
        } else {
            return new CommonResult(400, "保存失败", null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPayment(id);
        log.info("****** 查询  getPayment " + payment);

        if (payment != null) {
            return new CommonResult(200, "查询成功 serverPort" + serverPort, payment);
        } else {
            return new CommonResult(400, "查询失败,没有对应的ID" + id, null);
        }
    }

    @GetMapping("/getDiscovery")
    public Object getDiscovery() {

        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*******   element ******" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getInstanceId() + "\t" + instance.getHost()
                    + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }


    @GetMapping("/zipkin")
    public String paymentZipkin() {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }
}
