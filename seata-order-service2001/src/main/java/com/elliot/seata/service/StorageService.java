package com.elliot.seata.service;


import com.elliot.seata.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageService {

  /**
   * 库存减少
   *
   * @param productId
   * @param count
   * @return
   */
  @PostMapping("/api/storage/decrease")
  CommonResult decrease(@RequestParam(value = "productId") Long productId, @RequestParam(value = "count") Integer count);
}
