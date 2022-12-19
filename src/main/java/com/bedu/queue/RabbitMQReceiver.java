package com.bedu.queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.bedu.domain.ProductOrder;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "rabbitmq.queue", id = "listener")
public class RabbitMQReceiver {
    private static Logger logger = LogManager.getLogger(RabbitMQReceiver.class.toString());
    @RabbitHandler
    public void receiver(ProductOrder productOrder) {
        logger.info("ProductOrder listener invoked - Consuming Message with ProductOrder Identifier : " + productOrder.getOrderIdentifier());
    }
}