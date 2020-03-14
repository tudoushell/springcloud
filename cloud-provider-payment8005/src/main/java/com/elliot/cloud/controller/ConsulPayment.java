package com.elliot.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/payment")
public class ConsulPayment {

  @Value("${server.port}")
  private String port;

  @GetMapping("/consul")
  public String  paymentConsul() {
    return "springcloud with consul: " + port + " " + UUID.randomUUID();
  }
}
