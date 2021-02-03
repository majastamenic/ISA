package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order save(Order offer);

    List<Order> findAll();

    Order findOrderById(Long id);

    void deleteById(Long id);
}
