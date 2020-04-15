package com.elliot.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/nacos/consumer")
public class ConsumerController {

  @Resource
  private RestTemplate restTemplate;

  @Value("${service-url.nacos-payment-url}")
  private String url;

  @GetMapping("")
  public String getPaymentInfo() {
    return restTemplate.getForObject(url + "/api/payment/nacos", String.class);
  }

}
