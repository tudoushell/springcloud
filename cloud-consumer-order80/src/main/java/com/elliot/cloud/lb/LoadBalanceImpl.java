package com.elliot.cloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现负载均衡算法
 *
 * 负载均衡算法：
 * rest接口第几次请求数%服务器集群总数量=实际调用服务位置下际
 *
 *
 */
@Slf4j
@Component
public class LoadBalanceImpl implements LoadBalance {

  AtomicInteger atomicInteger = new AtomicInteger(0);
  
  public final int getAndIncrement(){
    int current;
    int next;
    do {
      current = atomicInteger.get();
      next = current >= Integer.MAX_VALUE ? 0 : current + 1;
    } while (!atomicInteger.compareAndSet(current, next));
    log.info("当前值为：" + next);
    return next;
  }


  @Override
  public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
    int index = getAndIncrement() % serviceInstances.size();
    return serviceInstances.get(index);
  }
}
