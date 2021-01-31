package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/define")
    public Order save(@RequestBody Order order){ return orderService.save(order); }

    @GetMapping
    public List<Order> getAll() { return orderService.getAll(); }
}
