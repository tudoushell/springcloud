package com.elliot.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClient8899 {
  public static void main(String[] args) {
    SpringApplication.run(ConfigClient8899.class, args);
  }
}
