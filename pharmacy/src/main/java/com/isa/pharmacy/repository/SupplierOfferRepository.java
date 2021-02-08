package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.domain.SupplierOffer;
import com.isa.pharmacy.users.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierOfferRepository extends JpaRepository<SupplierOffer, Long> {
    SupplierOffer save(SupplierOffer supplierOffer);
    SupplierOffer findSupplierOfferByOrder(Order order);
    List<SupplierOffer> findSupplierOfferBySupplier(Supplier supplier);
}
