package com.bedu.controller;

import com.bedu.queue.RabbitMQSender;
import com.bedu.domain.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RabbitMQDemoController {
    @Autowired
    RabbitMQSender rabbitMQSender;
    @PostMapping(value = "/rabbitmq/sender")
    public String producer(@RequestBody ProductOrder productOrder) {
        rabbitMQSender.send(productOrder);
        return "Message sent to the RabbitMQ Queue Successfully";
    }
}
