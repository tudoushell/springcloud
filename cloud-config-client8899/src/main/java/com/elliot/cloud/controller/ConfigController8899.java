package com.elliot.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController8899 {

  @Value("${config.info}")
  private String config;

  @Value("${server.port}")
  private String port;

  @GetMapping("/getConfig")
  public String getConfig() {
    return  config + " " + port;
  }
  
}
