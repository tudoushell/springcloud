package com.elliot.cloud.controller;

import com.elliot.cloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/message")
public class StreamProviderController {

  @Resource
  private IMessageProvider iMessageProvider;

  @GetMapping("/send")
  public String sendMessage() {
    return iMessageProvider.send();
  }
}
