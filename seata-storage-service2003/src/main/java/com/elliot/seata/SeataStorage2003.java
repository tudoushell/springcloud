package com.elliot.seata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.elliot.seata.dao")
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SeataStorage2003 {
  public static void main(String[] args) {
    SpringApplication.run(SeataStorage2003.class, args);
  }
}
