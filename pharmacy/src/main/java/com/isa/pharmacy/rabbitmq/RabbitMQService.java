package com.isa.pharmacy.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    private final Logger logger = LoggerFactory.getLogger(RabbitMQService.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${pharmacy.rabbitmq.exchange}")
    private String exchange;

    @Value("${pharmacy.rabbitmq.routingkey}")
    private String routingkey;

    public void send(ActionsAndBenefits action) {
        rabbitTemplate.convertAndSend(exchange, routingkey, action);
        logger.info("Send msg = %s", action.getMessageAboutAction());
    }
}
