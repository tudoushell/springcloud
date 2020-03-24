package com.elliot.cloud.controller;

import com.elliot.cloud.service.HystrixPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/payment/hystrix")
public class HystrixPaymentController {
  @Resource
  private HystrixPaymentService hystrixPaymentService;

  /**
   *
   * 当程序运行超过3秒或者程序出错时服务降级fallback
   * @param id
   * @return
   */
  @HystrixCommand(fallbackMethod = "paymentInfoHandler", commandProperties = {
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
  })
  @GetMapping("/{id}")
  public String paymentInfo(@PathVariable("id") Long id) {
    int i = 10 / 0;
//    try {
//      TimeUnit.SECONDS.sleep(5);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
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
  
}
