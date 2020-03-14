package com.elliot.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class ConumserZKController {

  @Resource
  private RestTemplate restTemplate;

  private final static String URL = "http://cloud-provider-payment/api/payment";

  @GetMapping("/zk")
  public String getZkProvider() {
    return  restTemplate.getForObject(URL + "/zk", String.class);
  }
}
