package com.elliot.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerHystrix80 {
  public static void main(String[] args) {
    SpringApplication.run(ConsumerHystrix80.class, args);
  }
}
