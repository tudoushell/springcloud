package com.elliot.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

//  private final String URL = "http://localhost:8001";
  private final String URL = "http://CLOUD-PAYMENT-SERVICE";

  @Resource
  private RestTemplate restTemplate;

  @GetMapping("/payment/{id}")
  public String getPayment(@PathVariable("id") long id) {
    return restTemplate.getForObject(URL + "/api/payment/" + id, String.class);
  }
}
