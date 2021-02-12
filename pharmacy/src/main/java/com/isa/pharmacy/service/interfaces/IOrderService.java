package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.domain.SupplierOffer;

import java.util.List;

public interface IOrderService {
     List<Order> getAll();

     void save(Order order);

     void deleteOrder(Long id);

     Order getById(Long id);

     List<Order> getByOffers(List<SupplierOffer> supplierOffers);

     List<Order> findOrderWithoutSupplierOffer(String email);
}
