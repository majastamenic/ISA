package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.OrderOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderOfferRepository extends JpaRepository<OrderOffer, Long> {
    OrderOffer save(OrderOffer orderOffer);
}
