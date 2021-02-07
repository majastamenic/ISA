package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    Complaint findComplaintById(Long id);
}
