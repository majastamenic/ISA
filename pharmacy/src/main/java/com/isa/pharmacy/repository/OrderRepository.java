package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order save(Order offer);

    List<Order> findAll();

    Order findOrderById(Long id);

    @Query(value = "select distinct o from app_order o where o.id not in (select so.order.id from SupplierOffer so where so.supplier.user.email like (:email)) ")
    List<Order> findOrderWithoutSupplierOffer(String email);
}
