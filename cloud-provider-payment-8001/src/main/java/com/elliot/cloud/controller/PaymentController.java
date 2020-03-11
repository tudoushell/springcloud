package com.elliot.cloud.controller;

import com.elliot.cloud.entity.CommonResult;
import com.elliot.cloud.entity.Payment;
import com.elliot.cloud.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/payment")
@Slf4j
@Api(tags = "payment接口")
public class PaymentController {

  @Resource
  private PaymentService paymentService;

  @Resource
  private DiscoveryClient discoveryClient;

  @Value("${server.port}")
  private String serverPort;

  @GetMapping("/{id}")
  @ApiOperation("获取payment")
  public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
    Payment payment = paymentService.getPayment(id);
    if (payment != null) {
      return new CommonResult<>(200, "success servicePort: " + serverPort, payment);
    } else {
      return new CommonResult<>(500, "fail", payment);
    }
    
  }

  @PostMapping("/add")
  @ApiOperation("添加payment")
  public CommonResult add(@RequestBody Payment payment) {
    int result = paymentService.addPayment(payment);
    if (result != -1) {
      return new CommonResult(200, "add success", null);
    } else {
      return new CommonResult(500, "add fail", null);
    }
  }

  @GetMapping("/discovery")
  @ApiOperation("服务发现")
  public Object getDiscoveryClient() {
    List<String> services = discoveryClient.getServices();
    for (String service : services) {
      log.info("**service: " + service);
    }
    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
    for (ServiceInstance instance : instances) {
      log.info("serviceId: " + instance.getServiceId() + " host: " + instance.getHost() + " URL: " + instance.getUri() + instance.getPort());
    }
    return this.discoveryClient;
  }

}
