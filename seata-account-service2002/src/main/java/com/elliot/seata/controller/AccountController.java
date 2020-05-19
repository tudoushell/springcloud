package com.elliot.seata.controller;

import com.elliot.seata.domain.CommonResult;
import com.elliot.seata.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/account")
@Api(tags = "用户账户")
public class AccountController {

  @Resource
  private AccountService accountService;

  @ApiOperation("更新账户")
  @PutMapping("/{userId}")
  public CommonResult decreaseMoney(@PathVariable("userId")Long userId, @RequestParam("money") BigDecimal money) throws InterruptedException {
    TimeUnit.SECONDS.sleep(2);
    return accountService.updateAccount(userId, money);
  }

}
