package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Counseling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CounselingRepository extends JpaRepository<Counseling, Long> {
    List<Counseling> findAll();

    Counseling save(Counseling counseling);

    Counseling findCounselingById(Long id);
}
