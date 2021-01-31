package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.OrderOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderOfferRepository extends JpaRepository<OrderOffer,Long> {

    OrderOffer save(OrderOffer offer);

    List<OrderOffer> findAll();
}
