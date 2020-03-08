package com.elliot.cloud.dao;


import com.elliot.cloud.entity.Payment;

public interface PaymentDao {
  
  int addPayment(Payment payment);

  Payment getPayment(Long id);
}
