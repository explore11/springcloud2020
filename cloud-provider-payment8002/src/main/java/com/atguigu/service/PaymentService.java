package com.atguigu.service;

import com.atguigu.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int creatPayment(Payment payment);
    public Payment getPayment(@Param("id") Long id);
}
