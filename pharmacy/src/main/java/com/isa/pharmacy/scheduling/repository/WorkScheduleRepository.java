package com.isa.pharmacy.scheduling.repository;

import com.isa.pharmacy.scheduling.domain.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Long> {
    List<WorkSchedule> findAll();

    WorkSchedule findWorkScheduleById(Long id);

    WorkSchedule save(WorkSchedule ws);

}
