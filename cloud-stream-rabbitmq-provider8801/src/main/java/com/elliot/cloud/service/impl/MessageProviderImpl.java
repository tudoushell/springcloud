package com.elliot.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.elliot.cloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {
  
  @Resource
  private MessageChannel output;

  @Override
  public String send() {
    String uuid = IdUtil.simpleUUID();
    output.send(MessageBuilder.withPayload(uuid).build());
    log.info("消息发送成功！");
    return uuid;
  }
}
