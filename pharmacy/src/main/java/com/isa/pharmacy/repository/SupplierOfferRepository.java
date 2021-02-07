package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.SupplierOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierOfferRepository extends JpaRepository<SupplierOffer, Long> {
}
