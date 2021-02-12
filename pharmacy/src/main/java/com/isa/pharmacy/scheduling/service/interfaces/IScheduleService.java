package com.isa.pharmacy.scheduling.service.interfaces;

import com.isa.pharmacy.scheduling.domain.Schedule;

import java.util.List;

public interface IScheduleService {
     Schedule save(Schedule schedule);

     List<Schedule> getAll();

     Schedule update(Schedule s);
}
