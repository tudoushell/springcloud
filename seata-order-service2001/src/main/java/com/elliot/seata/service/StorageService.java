package com.elliot.seata.service;


import com.elliot.seata.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
  @PutMapping("/api/storage/decrease/{productId}")
  CommonResult decrease(@PathVariable(value = "productId") Long productId, @RequestParam(value = "count") Integer count);
}
