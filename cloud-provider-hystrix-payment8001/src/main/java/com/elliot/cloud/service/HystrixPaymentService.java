package com.elliot.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixPaymentService {

  /**
   * 服务熔断
   * @param id
   * @return
   */
  @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
     @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
     @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
     @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
     @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //失败率达到多少后跳闸
  })
  public String paymentCircuitBreaker(Integer id) {
    if (id < 0) {
      throw new RuntimeException("***id 不能为负数");
    }
    String serialNumber = IdUtil.simpleUUID();
    return Thread.currentThread().getName() + " 调用成功 " + serialNumber;
  }


  public String paymentCircuitBreakerFallback(Integer id) {
    return "id 不能为负数";
  }


  public String paymentInfo(Long id) {
    return "当前线程："  + Thread.currentThread().getName() + " : " + id;
  }

  public String timeout() {
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "超时3秒";
  }
}
