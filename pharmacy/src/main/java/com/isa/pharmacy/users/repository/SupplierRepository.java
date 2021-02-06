package com.isa.pharmacy.users.repository;

import com.isa.pharmacy.users.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Supplier findSupplierByUser_email(String email);
}
