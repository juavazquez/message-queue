package com.queue.producer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.queue.producer.service.IProducerService;

@RestController
public class ProducerController {

    private final IProducerService producerService;

    public ProducerController(IProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/produce")
    public ResponseEntity<String> produceMessage(@RequestBody String message) {
        producerService.produceMessage(message);
        return ResponseEntity.ok("Message produced successfully");
    }

}
