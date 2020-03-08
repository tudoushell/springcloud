package com.elliot.cloud.service;


import com.elliot.cloud.entity.Payment;

public interface PaymentService {
  
  int addPayment(Payment payment);

  Payment getPayment(Long id);
}
