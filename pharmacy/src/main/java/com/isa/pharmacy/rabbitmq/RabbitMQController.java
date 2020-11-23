package com.isa.pharmacy.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.isa.pharmacy.rabbitmq.*;

@RestController
@RequestMapping(value = "/rabbitmq/")
public class RabbitMQController {
	
	@Autowired
    RabbitMQService rabbitMQService;

    @GetMapping(value = "/actions")
    public String producer(@RequestParam("id") long id,@RequestParam("messageAboutAction") String messageAboutAction) {

    ActionsAndBenefits action=new ActionsAndBenefits();
    action.setId(id);
    action.setMessageAboutAction(messageAboutAction);
    rabbitMQService.send(action);

        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }
}
