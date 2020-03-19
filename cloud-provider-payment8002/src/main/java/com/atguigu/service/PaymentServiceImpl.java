package com.atguigu.service;

import com.atguigu.dao.PaymentDao;
import com.atguigu.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int creatPayment(Payment payment) {
        return paymentDao.creatPayment(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        return paymentDao.getPayment(id);
    }
}
