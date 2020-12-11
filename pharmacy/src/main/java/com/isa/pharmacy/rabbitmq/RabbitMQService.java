package com.isa.pharmacy.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {
	
	  @Autowired
	    private AmqpTemplate rabbitTemplate;

	    @Value("${pharmacy.rabbitmq.exchange}")
	    private String exchange;

	    @Value("${pharmacy.rabbitmq.routingkey}")
	    private String routingkey;

	    public void send(ActionsAndBenefits action) {
	        rabbitTemplate.convertAndSend(exchange, routingkey, action);
	        System.out.println("Send msg = " + action);

	    }

}
