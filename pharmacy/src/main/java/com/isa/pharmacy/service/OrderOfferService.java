package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.OrderOffer;
import com.isa.pharmacy.repository.OrderOfferRepository;
import com.isa.pharmacy.service.interfaces.IOrderOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderOfferService implements IOrderOfferService {

    @Autowired
    private OrderOfferRepository orderOfferRepository;

    @Override
    public void save(OrderOffer order) {
        orderOfferRepository.save(order);
    }
}
