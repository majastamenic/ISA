package com.isa.pharmacy.users.repository;

import com.isa.pharmacy.users.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByUser_email(String email);
}
