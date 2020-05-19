package com.elliot.seata.service;

import com.elliot.seata.domain.CommonResult;

import java.math.BigDecimal;

public interface AccountService {
  /**
   * 更新用户账户
   *
   * @param userId
   * @param used
   * @return
   */
  CommonResult updateAccount(Long userId, BigDecimal used);
}
