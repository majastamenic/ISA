package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.VacationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationScheduleRepository extends JpaRepository<VacationSchedule, Long> {

    List<VacationSchedule> findAll();

    VacationSchedule save(VacationSchedule vacationSchedule);
}
