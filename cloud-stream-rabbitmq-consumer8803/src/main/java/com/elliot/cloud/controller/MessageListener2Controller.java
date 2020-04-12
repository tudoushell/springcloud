package com.elliot.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 当有多个消费者时，生产者的消息会被每个消费全部获取到，
 * 例如：生产者发送2个，2个消费者都会得到2个消息
 * 为避免这个问题可使用分组(group)来解决，这样话2个消费者共用这2条消息
 *
 */
@Component
@Slf4j
@EnableBinding(Sink.class)
public class MessageListener2Controller {

  @Value("${server.port}")
  private String serverPort;

  @StreamListener(Sink.INPUT)
  public void getMessage(Message<String> message) {
    log.info("消费者2 serverPort [" + serverPort +  "]，" + message.getPayload());
  }
}
