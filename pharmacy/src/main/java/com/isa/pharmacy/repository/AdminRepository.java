package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Profile.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}