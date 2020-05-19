package com.elliot.seata.service.impl;

import com.elliot.seata.dao.AccountDao;
import com.elliot.seata.domain.CommonResult;
import com.elliot.seata.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

  @Resource
  private AccountDao accountDao;

  @Override
  public CommonResult updateAccount(Long userId, BigDecimal used) {
    log.info("---> 更新账户余额");
    accountDao.update(userId, used);
    return new CommonResult(200, "账户更新成功");
  }
}
