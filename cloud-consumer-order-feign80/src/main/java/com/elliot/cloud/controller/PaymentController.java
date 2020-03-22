package com.elliot.cloud.controller;

import com.elliot.cloud.entity.CommonResult;
import com.elliot.cloud.entity.Payment;
import com.elliot.cloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/payment")
public class PaymentController {

  @Resource
  private PaymentFeignService paymentFeignService;

  @GetMapping("/{id}")
  public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
    return paymentFeignService.getPayment(id);
  }

}
