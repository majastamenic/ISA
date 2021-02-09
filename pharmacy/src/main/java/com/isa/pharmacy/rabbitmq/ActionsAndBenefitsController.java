package com.isa.pharmacy.rabbitmq;

import com.isa.pharmacy.service.EmailService;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;

@RestController
@RequestMapping(value = "/actions")
@CrossOrigin(value = "http://localhost:4200")
public class ActionsAndBenefitsController {

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    ActionsAndBenefitsService actionsAndBenefitsService;

    /*
    @PostMapping("/rabbitMq")
    public ResponseEntity<String> producer(@RequestBody ActionsAndBenefitsDto actionDto) {

        ActionsAndBenefits action = ActionsAndBenefitsMapper.mapActionDtoToAction(actionDto);

        rabbitMQService.send(action);

        return ResponseEntity.ok("Message sent to the RabbitMQ JavaInUse Successfully");
    }
    */
    @PostMapping("/{email}")
    public void save(@RequestBody ActionsAndBenefitsDto actionsAndBenefitsDto, @PathVariable String email){
        actionsAndBenefitsService.send(ActionsAndBenefitsMapper.mapActionDtoToAction(actionsAndBenefitsDto), email);
    }
}
