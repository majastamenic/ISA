package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Schedule;
import com.isa.pharmacy.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule save(Schedule schedule) { return scheduleRepository.save(schedule); }

    public List<Schedule> getAll(){ return scheduleRepository.findAll(); }

    public Schedule update(Schedule s) {
        Schedule schedule = scheduleRepository.findScheduleById(s.getId());
        schedule.setStartDate(s.getStartDate());
        schedule.setEndDate(s.getEndDate());
        schedule.setStartTime(s.getStartTime());
        schedule.setEndTime(s.getEndTime());
        scheduleRepository.save(schedule);
        return schedule;
    }
}
