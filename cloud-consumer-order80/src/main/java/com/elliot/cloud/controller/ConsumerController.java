package com.elliot.cloud.controller;

import com.elliot.cloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class ConsumerController {

//  private final String URL = "http://localhost:8001";
  private final String URL = "http://CLOUD-PAYMENT-SERVICE";

  @Resource
  private RestTemplate restTemplate;

  @Resource
  private LoadBalance loadBalance;

  @Resource
  private DiscoveryClient discoveryClient;

  @GetMapping("/payment/{id}")
  public String getPayment(@PathVariable("id") long id) {
    return restTemplate.getForObject(URL + "/api/payment/" + id, String.class);
  }

  /**
   * 调用时，需禁用restTemplate @LoadBalancd注解
   * @return
   */
  @GetMapping("/load-balance")
  public String getPaymentLB() {
    ServiceInstance instance = loadBalance.instance(discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE"));
    log.info("URL" + instance.getUri());
    return restTemplate.getForObject(instance.getUri() + "/api/payment/load-balance", String.class);
  }
}
