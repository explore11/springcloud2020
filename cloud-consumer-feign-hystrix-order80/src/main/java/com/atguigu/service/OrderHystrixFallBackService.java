package com.atguigu.service;

import org.springframework.stereotype.Component;

@Component
public class OrderHystrixFallBackService implements OrderService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "OrderHystrixFallBackService  paymentInfo_OK  falklback " + id;
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "OrderHystrixFallBackService paymentInfo_TimeOut falklback" + id;
    }
}
