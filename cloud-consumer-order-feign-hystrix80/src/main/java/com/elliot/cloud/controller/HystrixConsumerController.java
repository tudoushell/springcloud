package com.elliot.cloud.controller;

import com.elliot.cloud.service.HystrixConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer/hystrix")
public class HystrixConsumerController {
  @Resource
  private HystrixConsumerService hystrixConsumerService;

  @GetMapping("/{id}")
  public String getHystrix(@PathVariable("id") Long id) {
    return hystrixConsumerService.paymentInfo(id);
  }

  @GetMapping("/timeout")
  public String timeout() {
    return hystrixConsumerService.timeout();
  }

}
