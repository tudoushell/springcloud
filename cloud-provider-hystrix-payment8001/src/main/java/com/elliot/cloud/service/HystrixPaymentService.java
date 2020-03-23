package com.elliot.cloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixPaymentService {

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
