package com.elliot.seata.dao;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountDao {
  /**
   * 更新
   * @param userId
   * @param used
   */
  void update(@Param("userId") Long userId, @Param("used") BigDecimal used);
}
