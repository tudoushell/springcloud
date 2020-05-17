package com.elliot.seata.controller;

import com.elliot.seata.domain.CommonResult;
import com.elliot.seata.domain.Order;
import com.elliot.seata.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/order")
@Api(tags = "微服务订单接口")
public class OrderController {
  @Resource
  private OrderService orderService;

  @ApiOperation("订单创建")
  @PostMapping("")
  public CommonResult create(@RequestBody Order order) {
    orderService.createOrder(order);
    return new CommonResult(200, "订单创建成功");
  }
}
