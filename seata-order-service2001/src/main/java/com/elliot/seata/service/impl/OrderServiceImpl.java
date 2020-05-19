package com.elliot.seata.service.impl;

import com.elliot.seata.dao.OrderDao;
import com.elliot.seata.domain.Order;
import com.elliot.seata.service.AccountService;
import com.elliot.seata.service.OrderService;
import com.elliot.seata.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

  @Resource
  private OrderDao orderDao;

  @Resource
  private AccountService accountService;

  @Resource
  private StorageService storageService;

  @Override
  @GlobalTransactional(name = "order_tx", rollbackFor = Exception.class)
  public void createOrder(Order order) {
    log.info("---> 开始创建订单");
    orderDao.add(order);

    log.info("---> 调用库存微服务");
    storageService.decrease(order.getProductId(), order.getCount());

    log.info("---> 扣除钱");
    accountService.decreaseMoney(order.getUserId(), order.getMoney());

    log.info("---> 修改订单状态");
    orderDao.update(order.getUserId(), order.getStatus());
    
    log.info("---> 订单创建成功");
  }
}
