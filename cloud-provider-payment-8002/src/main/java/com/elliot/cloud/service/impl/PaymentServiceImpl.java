package com.elliot.cloud.service.impl;

import com.elliot.cloud.dao.PaymentDao;
import com.elliot.cloud.service.PaymentService;
import com.elliot.cloud.entity.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

  @Resource
  private PaymentDao paymentDao;

  @Override
  public int addPayment(Payment payment) {
    return paymentDao.addPayment(payment);
  }

  @Override
  public Payment getPayment(Long id) {
    return paymentDao.getPayment(id);
  }

}
