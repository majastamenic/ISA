package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.PriceList;
import com.isa.pharmacy.domain.Profile.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
