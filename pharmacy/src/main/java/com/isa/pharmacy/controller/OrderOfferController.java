package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.domain.OrderOffer;
import com.isa.pharmacy.service.OrderOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OrderOfferController {

    @Autowired
    private OrderOfferService orderOfferService;

    @PostMapping("/define")
    public OrderOffer save(@RequestBody OrderOffer order){ return orderOfferService.save(order); }

    @GetMapping
    public List<OrderOffer> findAll() { return orderOfferService.findAll(); }
}
