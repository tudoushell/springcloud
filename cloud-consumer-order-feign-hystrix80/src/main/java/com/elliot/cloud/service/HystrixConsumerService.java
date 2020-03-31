package com.elliot.cloud.service;

import com.elliot.cloud.fallback.FallbackConsumerService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "HYSTRIX-PAYMENT", fallback = FallbackConsumerService.class)
public interface HystrixConsumerService {

  @GetMapping("/api/payment/hystrix/{id}")
  String paymentInfo(@PathVariable("id") Long id);

  @GetMapping("/api/payment/hystrix/timeout")
  String timeout();
}
