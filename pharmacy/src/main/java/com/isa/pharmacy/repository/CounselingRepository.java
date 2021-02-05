package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.users.domain.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CounselingRepository extends JpaRepository<Counseling, Long> {
    List<Counseling> findAll();

    List<Counseling> findByPharmacist(Pharmacist pharmacist);

    Counseling save(Counseling counseling);

    Counseling findCounselingById(Long id);
}
