package com.elliot.seata.dao;

import org.apache.ibatis.annotations.Param;

public interface StorageDao {
  /**
   * 更新库存
   *
   * @param productId 产品ID
   * @param count    数量
   */
  void updateStorage(@Param("productId") Long productId, @Param("count") Integer count);
}
