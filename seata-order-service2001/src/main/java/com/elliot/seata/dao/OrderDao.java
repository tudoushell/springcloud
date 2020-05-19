package com.elliot.seata.dao;


import com.elliot.seata.domain.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderDao {
  /**
   * 创建订单
   * @param order
   * @return
   */
  void add(Order order);

  /**
   * 修改订单状态
   * @param userId
   * @param status
   */
  void update(@Param("userId") Long userId, @Param("status") Integer status);
  
}
