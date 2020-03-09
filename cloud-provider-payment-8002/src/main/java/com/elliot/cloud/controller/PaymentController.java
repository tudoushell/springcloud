package com.elliot.cloud.controller;

import com.elliot.cloud.service.PaymentService;
import com.elliot.cloud.entity.CommonResult;
import com.elliot.cloud.entity.Payment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/payment")
@Slf4j
@Api(tags = "payment接口")
public class PaymentController {

  @Resource
  private PaymentService paymentService;

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

}
