package com.bedu.queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.bedu.domain.ProductOrder;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private Queue queue;
    private static Logger logger = LogManager.getLogger(RabbitMQSender.class.toString());
    public void send(ProductOrder productOrder) {
        rabbitTemplate.convertAndSend(queue.getName(), productOrder);
        logger.info("Sending Message to the Queue : " + productOrder.toString());
    }
}
