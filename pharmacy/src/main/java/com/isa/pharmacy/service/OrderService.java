package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order){ return orderRepository.save(order); }

    public void delete(Order order){
        orderRepository.delete(order);
    }

    public List<Order> getAll(){
        return orderRepository.findAll();
    }
}
