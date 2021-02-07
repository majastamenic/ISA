package com.isa.pharmacy.rabbitmq;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionsAndBenefitsRepository extends JpaRepository<ActionsAndBenefits,Long> {

    ActionsAndBenefits save(ActionsAndBenefits actionsAndBenefits);
}
