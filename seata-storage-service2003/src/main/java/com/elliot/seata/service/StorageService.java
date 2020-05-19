package com.elliot.seata.service;

import com.elliot.seata.domain.CommonResult;

public interface StorageService {
  /**
   * 更新库存
   *
   * @param productId 产品ID
   * @param count     购买的数量
   * @return
   */
  CommonResult updateStorage(Long productId, Integer count);
}
