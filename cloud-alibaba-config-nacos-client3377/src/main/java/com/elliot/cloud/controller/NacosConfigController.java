package com.elliot.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  //nacos 支持动态刷新
public class NacosConfigController {
  
  @Value("${config.info}")
  private String configInfo;

  @GetMapping("/nacos/config")
  public String getConfigInfo() {
    return configInfo;
  }
}
