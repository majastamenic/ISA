package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.InvalidActionException;
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

    public void delete(Long id){
        Order order = orderRepository.findOrderById(id);
        if (!order.getOffers().isEmpty()){
            throw new InvalidActionException("You can't delete this order because it has offers");
        }
        orderRepository.deleteById(id);
    }

    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){return orderRepository.findOrderById(id);}

    public Order update(Order order){
        Order o = orderRepository.findOrderById(order.getId());
        if(o.getOffers() !=null) {
            System.out.println("Yu can't update this order because it has offers");
            return null;
        }else {
            o.setEndDate(order.getEndDate());
            o.setEndTime(order.getEndTime());
            o.setOffers(order.getOffers());
            o.setMedicineList(order.getMedicineList());
            o.setPharmacyAdmin(order.getPharmacyAdmin());
            o.setWinnerId(order.getWinnerId());
            orderRepository.save(o);
            return o;
        }
    }

}
