package com.elliot.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.elliot.cloud.handler.CostumerExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sentinel")
public class SentinelController {

  @GetMapping("/test")
  public String test() {
    return "hello sentinel";
  }

  @GetMapping("/test2")
  public String test2() {
    return "hello";
  }

  @GetMapping("/testRt")
  public String testRt() {
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "testRt";
  }

  @GetMapping("/testE")
  public String testE() {
    int i = 10 / 0;
    return "测试异常比例";
  }

  @GetMapping("/testC")
  public String testCount() {
    int i = 10 / 0;
    return "测试异常数";
  }


  @GetMapping("/testHotKey")
  @SentinelResource(value = "testHotKey", blockHandler = "errorPage")
  public String testHotKey(@RequestParam(value = "a", required = false) String a,
                           @RequestParam(value = "b", required = false) String b) {
    return "测试热点规则";
  }
  
  public String errorPage(String a, String b, BlockException e) {
    return "热点规则错误";
  }

  /**
   * 定制全局异常
   * @return
   */
  @GetMapping("/testException")
  @SentinelResource(blockHandlerClass = CostumerExceptionHandler.class, blockHandler = "pageException")
  public String testGlobalException() {
    return "test Exception";
  }
}
