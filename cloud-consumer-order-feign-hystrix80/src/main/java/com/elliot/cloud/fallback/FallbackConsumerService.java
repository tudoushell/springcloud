package com.elliot.cloud.fallback;

import com.elliot.cloud.service.HystrixConsumerService;
import org.springframework.stereotype.Component;

/**
 * 通配服务降级
 */
@Component
public class FallbackConsumerService implements HystrixConsumerService {
  @Override
  public String paymentInfo(Long id) {
    return "fallback method paymentinfo" + id;
  }

  @Override
  public String timeout() {
    return "fallback timeout";
  }
}
