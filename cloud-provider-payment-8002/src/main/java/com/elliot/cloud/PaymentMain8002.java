package com.elliot.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: zhou
 * @date: 2020/3/6
 */
@MapperScan("com.elliot.cloud.dao")
@EnableEurekaClient
@SpringBootApplication
public class PaymentMain8002 {
  public static void main(String[] args) {
    SpringApplication.run(PaymentMain8002.class, args);
  }
}
