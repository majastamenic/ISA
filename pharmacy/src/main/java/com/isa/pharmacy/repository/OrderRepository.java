package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order save(Order offer);

    List<Order> findAll();
}
