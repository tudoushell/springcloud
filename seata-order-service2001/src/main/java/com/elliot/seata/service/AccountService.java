package com.elliot.seata.service;

import com.elliot.seata.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service")
public interface AccountService {

  /**
   * 更新帐户余额
   *
   * @param userId
   * @param money
   * @return
   */
  @PutMapping("/api/account/{userId}")
  CommonResult decreaseMoney(@PathVariable("userId")Long userId, @RequestParam("money") BigDecimal money);
}
