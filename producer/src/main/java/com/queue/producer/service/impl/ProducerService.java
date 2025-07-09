package com.queue.producer.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.queue.producer.service.IProducerService;
import com.queue.producer.service.IQueueAdapter;

@Service
public class ProducerService implements IProducerService {

    private final IQueueAdapter queue;

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    public ProducerService(IQueueAdapter queue) {
        this.queue = queue;
    }

    public void produceMessage(String message) {
        logger.info("Producing message: {}", message);
        queue.produce(message);
    }

}
