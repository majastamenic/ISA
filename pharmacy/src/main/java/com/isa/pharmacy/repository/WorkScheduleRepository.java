package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Dermatologist;
import com.isa.pharmacy.domain.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Long> {
    List<WorkSchedule> findAll();

    WorkSchedule save(WorkSchedule ws);
}