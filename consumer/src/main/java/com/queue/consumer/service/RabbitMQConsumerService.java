package com.queue.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumerService.class);

    @RabbitListener(queues = { "${QUEUE_NAME}" })
    public void consumeMessage(String message) {
        logger.info("Processing new message: {}", message);
        try {
            Thread.sleep(10000);
            logger.info("Message processed: {}", message);
        } catch (InterruptedException e) {
            logger.error("Error occurred while processing message: {}", message, e);
        } // Simulate processing time
    }

}
