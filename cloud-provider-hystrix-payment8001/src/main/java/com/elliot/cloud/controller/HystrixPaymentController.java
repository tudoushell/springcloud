package com.elliot.cloud.controller;

import com.elliot.cloud.service.HystrixPaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/payment/hystrix")
public class HystrixPaymentController {
  @Resource
  private HystrixPaymentService hystrixPaymentService;

  @GetMapping("/{id}")
  public String paymentInfo(@PathVariable("id") Long id) {
    return hystrixPaymentService.paymentInfo(id);
  }

  @GetMapping("/timeout")
  public String timeout() {
    return hystrixPaymentService.timeout();
  }
  
}
