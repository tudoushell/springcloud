package com.elliot.myrule;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义Ribbon负载均衡规则
 */
@Configuration
public class RibbonRule {

  @Bean
  public RandomRule randomRule() {
    return new RandomRule();
  }
}
