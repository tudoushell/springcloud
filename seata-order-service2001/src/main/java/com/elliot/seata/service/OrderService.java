package com.elliot.seata.service;


import com.elliot.seata.domain.Order;

public interface OrderService {
  /**
   * 创建订单
   *
   * @param order
   */
  void createOrder(Order order);
}
