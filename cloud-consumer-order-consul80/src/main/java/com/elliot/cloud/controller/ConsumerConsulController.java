package com.elliot.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/payment")
public class ConsumerConsulController {

  @Resource
  private RestTemplate restTemplate;

  private final String URL = "http://consul-provider-payment/api/payment";

  @GetMapping("/consul")
  public String getProviderConsul() {
    return restTemplate.getForObject(URL + "/consul", String.class);
  }
}
