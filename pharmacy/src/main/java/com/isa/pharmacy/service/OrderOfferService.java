package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.OrderOffer;
import com.isa.pharmacy.repository.OrderOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderOfferService {
    @Autowired
    private OrderOfferRepository orderOfferRepository;

    public OrderOffer save(OrderOffer orderOffer){ return orderOfferRepository.save(orderOffer); }

    public List<OrderOffer> findAll(){ return orderOfferRepository.findAll();}


}
