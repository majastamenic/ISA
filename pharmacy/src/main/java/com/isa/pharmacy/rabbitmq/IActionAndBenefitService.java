package com.isa.pharmacy.rabbitmq;

public interface IActionAndBenefitService {
    void send(ActionsAndBenefits actionsAndBenefits, String phAdminEmail);
}
