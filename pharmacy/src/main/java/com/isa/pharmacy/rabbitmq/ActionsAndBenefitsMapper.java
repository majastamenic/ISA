package com.isa.pharmacy.rabbitmq;


public class ActionsAndBenefitsMapper {

    public static ActionsAndBenefits mapActionDtoToAction(ActionsAndBenefitsDto actionDto) {
        ActionsAndBenefits action = new ActionsAndBenefits();
        action.setMessageAboutAction(actionDto.getMessage());
        action.setStartDate(actionDto.getStartDate());
        action.setEndDate(actionDto.getEndDate());
        return action;
    }

}
