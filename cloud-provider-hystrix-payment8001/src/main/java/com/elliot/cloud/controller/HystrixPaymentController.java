package com.elliot.cloud.controller;

import com.elliot.cloud.service.HystrixPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/payment/hystrix")
/**
 * 用于配置全局服务降级
 */
@DefaultProperties(defaultFallback = "globalErrorMsg")
public class HystrixPaymentController {
  @Resource
  private HystrixPaymentService hystrixPaymentService;

  /**
   * 服务熔断测试
   * @param id
   * @return
   */
  @GetMapping("/circuit-break/{id}")
  public String circuitBreaker(@PathVariable("id") Integer id) {
    return hystrixPaymentService.paymentCircuitBreaker(id);
  }

  /**
   *
   * 当程序运行超过3秒或者程序出错时服务降级fallback
   * @param id
   * @return
   */
//  @HystrixCommand(fallbackMethod = "paymentInfoHandler", commandProperties = {
//          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//  })
  @HystrixCommand
  @GetMapping("/{id}")
  public String paymentInfo(@PathVariable("id") Long id) {
    int i = 10 / 0;
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return hystrixPaymentService.paymentInfo(id);
  }

  @GetMapping("/timeout")
  public String timeout() {
    return hystrixPaymentService.timeout();
  }

  /**
   * 服务降级方法
   * @return
   */
  public String paymentInfoHandler(Long id) {
    return Thread.currentThread().getName() + " 服务超时或出错，请稍后重试 " + id;
  }

  public String globalErrorMsg() {
    return "服务器繁忙或出错";
  }
  
}
