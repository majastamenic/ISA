package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.users.Admin;
import com.isa.pharmacy.domain.users.PharmacyAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByUser_email(String email);
}
