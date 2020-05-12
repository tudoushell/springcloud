package com.elliot.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.elliot.cloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {

  private static final String SERVER_URL = "http://cloud-nacos-payment-provider";

  @Resource
  private RestTemplate restTemplate;

  @Resource
  private PaymentService paymentService;

  /**
   *  fallback 只负责业务异常
   *  blockHandler 只负责sentinel控制台配置违规
   *  当同时配置fallback和blockHandler时，blockHandler生效
   * @param id
   * @return
   */
  @GetMapping("/getInfo")
//  @SentinelResource(value = "getInfo", fallback = "errorPage")
//  @SentinelResource(value = "getInfo", blockHandler = "errorSentinelPage")
  @SentinelResource(value = "getInfo", fallback = "errorPage", blockHandler = "errorSentinelPage")
  public String getInfo(Integer id) {
    if (id == 4) {
      throw new RuntimeException("参数不存在!");
    } else if (id == 5) {
      throw new NullPointerException("空指针异常");
    }
    return restTemplate.getForObject(SERVER_URL + "/api/payment", String.class);
  }

  @GetMapping("/feign/getInfo")
  public String testFeign() {
    return paymentService.getPayment();
  }

  public String errorPage(Integer id) {
    return "异常id为：" + id;
  }

  public String errorSentinelPage(Integer id, BlockException e) {
    return e.getMessage() + "Sentinel控制异常成功";
  }
}
