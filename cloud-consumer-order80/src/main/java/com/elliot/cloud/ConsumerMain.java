package com.elliot.cloud;

import com.elliot.myrule.RibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//配置Ribbon的负载规则
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = {RibbonRule.class})
public class ConsumerMain {
  public static void main(String[] args) {
    SpringApplication.run(ConsumerMain.class, args);
  }
}
