package com.elliot.cloud.service;

import com.elliot.cloud.fallback.PaymentServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
@Component
@FeignClient(value = "cloud-nacos-payment-provider", fallback = PaymentServiceFallback.class)
public interface PaymentService {
  @GetMapping("/api/payment")
  String getPayment();
}
