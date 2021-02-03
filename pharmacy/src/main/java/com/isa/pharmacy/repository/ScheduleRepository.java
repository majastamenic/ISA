package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAll();

    Schedule save(Schedule schedule);

    Schedule findScheduleById(Long id);
}
