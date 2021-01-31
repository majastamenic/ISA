package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository<Offer> extends JpaRepository<Order, Long> {

    Order save(Order offer);
    
}
