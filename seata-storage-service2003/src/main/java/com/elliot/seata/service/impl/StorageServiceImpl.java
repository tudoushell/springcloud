package com.elliot.seata.service.impl;

import com.elliot.seata.dao.StorageDao;
import com.elliot.seata.domain.CommonResult;
import com.elliot.seata.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

  @Resource
  private StorageDao storageDao;

  @Override
  public CommonResult updateStorage(Long productId, Integer count) {
    log.info("开始更新库存");
    storageDao.updateStorage(productId, count);
    return new CommonResult(200, "库存更新成功");
  }
}
