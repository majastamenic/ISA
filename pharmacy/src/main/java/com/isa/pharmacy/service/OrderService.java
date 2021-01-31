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

    public Order update(Order order){
        Order o = orderRepository.findOrderById(order.getId());
        o.setEndDate(order.getEndDate());
        o.setEndTime(order.getEndTime());
        o.setOffers(order.getOffers());
        o.setMedicineList(order.getMedicineList());
        o.setPharmacyAdmin(order.getPharmacyAdmin());
        orderRepository.save(o);
        return o;
    }

}
