package com.atguigu.controller;

import com.atguigu.entities.CommonResult;
import com.atguigu.entities.Payment;
import com.atguigu.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/creat")   //TODO  暂时不加@RequestParam
    public CommonResult creatPayment(Payment payment) {
        int num = paymentService.creatPayment(payment);
        log.info("****** 保存  creatPayment " + num);
        if (num > 0) {
            return new CommonResult(200, "保存成功", num);
        } else {
            return new CommonResult(400, "保存失败", null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPayment(id);
        log.info("****** 查询  getPayment " + payment);

        if (payment != null) {
            return new CommonResult(200,  "查询成功", payment);
        } else {
            return new CommonResult(400, "查询失败,没有对应的ID"+id, null);
        }
    }


}
