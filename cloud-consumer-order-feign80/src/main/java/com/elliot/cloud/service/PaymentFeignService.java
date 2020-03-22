package com.elliot.cloud.service;

import com.elliot.cloud.entity.CommonResult;
import com.elliot.cloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentFeignService {
  @GetMapping("/api/payment/{id}")
  CommonResult<Payment> getPayment(@PathVariable("id") Long id);
}
