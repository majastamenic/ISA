package com.isa.pharmacy.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionsAndBenefitsService {
    @Autowired
    private ActionsAndBenefitsRepository actionsAndBenefitsRepository;

    public ActionsAndBenefits save(ActionsAndBenefits actionsAndBenefits){
        return actionsAndBenefitsRepository.save(actionsAndBenefits);
    }
}
