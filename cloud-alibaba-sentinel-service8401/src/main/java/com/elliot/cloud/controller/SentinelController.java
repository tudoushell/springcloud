package com.elliot.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {

  @GetMapping("/sentinel")
  public String test() {
    return "hello sentinel";
  }
}
