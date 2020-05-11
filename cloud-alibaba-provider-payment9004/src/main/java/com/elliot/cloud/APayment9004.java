package com.elliot.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class APayment9004 {
  public static void main(String[] args) {
    SpringApplication.run(APayment9004.class, args);
  }
}
