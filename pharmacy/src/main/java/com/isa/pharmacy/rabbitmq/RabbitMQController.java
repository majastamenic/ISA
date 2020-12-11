package com.isa.pharmacy.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/actions")
@CrossOrigin(value = "http://localhost:4200")
public class RabbitMQController {
	
	@Autowired
    RabbitMQService rabbitMQService;

    @PostMapping
    public ResponseEntity<String> producer(@RequestBody ActionsAndBenefitsDto actionDto) {

	    ActionsAndBenefits action=new ActionsAndBenefits();
	    action = ActionsAndBenefitsMapper.mapActionDtoToAction(actionDto);
	    
	    rabbitMQService.send(action);

     	return ResponseEntity.ok("Message sent to the RabbitMQ JavaInUse Successfully");
    }
}
