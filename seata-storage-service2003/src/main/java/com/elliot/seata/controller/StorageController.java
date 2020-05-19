package com.elliot.seata.controller;

import com.elliot.seata.domain.CommonResult;
import com.elliot.seata.service.StorageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/storage")
public class StorageController {
  
  @Resource
  private StorageService storageService;

  @PutMapping("/decrease/{productId}")
  public CommonResult decreaseStorage(@PathVariable("productId") Long productId, @RequestParam(value = "count") Integer count) {
    return storageService.updateStorage(productId, count);
  }
}
