package com.elliot.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 想要从配置中心server获取最新的yml，需要3个步骤
 * 1. 修改bootstrap.yml添加暴露监控端点
 * 2. 在控制层添加@RefreshScope注解
 * 3. 用post调用client接口，/actuator/refresh
 */
@RestController
@RefreshScope
public class ConfigController {

  @Value("${config.info}")
  private String config;

  @GetMapping("/getConfig")
  public String getConfig () {
    return config;
  }
}
