package com.queue.producer.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.queue.producer.service.IQueueAdapter;

@Component
public class RabbitMQAdapter implements IQueueAdapter {

    private final RabbitTemplate rabbitTemplate;

    @Value("${EXCHANGE_NAME}")
    private String exchangeName;

    @Value("${ROUTING_KEY}")
    private String routingKey;

    public RabbitMQAdapter(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void produce(String message) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }

}
