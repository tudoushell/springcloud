package com.elliot.seata.dao;


import com.elliot.seata.domain.Order;

public interface OrderDao {
  /**
   * 创建订单
   * @param order
   * @return
   */
  Order add(Order order);

  /**
   * 修改订单状态
   * @param userId
   * @param status
   */
  void update(Long userId, Integer status);
  
}
