package com.elliot.cloud.controller;

import com.elliot.cloud.service.HystrixConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

  @HystrixCommand(fallbackMethod = "getHystrixHandler", commandProperties = {
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
  })
  @GetMapping("/{id}")
  public String getHystrix(@PathVariable("id") Long id) {
    return hystrixConsumerService.paymentInfo(id);
  }

  @GetMapping("/timeout")
  public String timeout() {
    return hystrixConsumerService.timeout();
  }

  public String getHystrixHandler(@PathVariable("id") Long id) {
    return "消费者80，支付端服务出错";
  }

}
