package com.atguigu.dao;

import com.atguigu.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int creatPayment(Payment payment);
    public Payment getPayment(@Param("id") Long id);
}
