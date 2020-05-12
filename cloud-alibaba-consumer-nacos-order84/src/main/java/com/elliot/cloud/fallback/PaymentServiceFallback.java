package com.elliot.cloud.fallback;

import com.elliot.cloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * 服务降级
 */
@Component
public class PaymentServiceFallback implements PaymentService {
  @Override
  public String getPayment() {
    return "服务异常";
  }
}
