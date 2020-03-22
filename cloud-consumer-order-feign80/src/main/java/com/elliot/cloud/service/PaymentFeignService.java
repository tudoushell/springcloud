package com.elliot.cloud.service;

import com.elliot.cloud.entity.CommonResult;
import com.elliot.cloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//微服务名称，从Eureka中调用服务
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
  @GetMapping("/api/payment/{id}")
  CommonResult<Payment> getPayment(@PathVariable("id") Long id);

  @GetMapping("/api/payment/feign/timeout")
  String feignTimeout();
}
