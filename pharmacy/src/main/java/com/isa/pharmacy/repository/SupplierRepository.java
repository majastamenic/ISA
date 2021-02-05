package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.users.PharmacyAdmin;
import com.isa.pharmacy.domain.users.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Supplier findSupplierByUser_email(String email);
}
