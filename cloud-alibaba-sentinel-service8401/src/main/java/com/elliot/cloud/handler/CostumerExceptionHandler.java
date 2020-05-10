package com.elliot.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 全局异常的方法必须是static
 */
public class CostumerExceptionHandler {

  public static String pageException(BlockException e) {
    return "global Exception";
  }
}
