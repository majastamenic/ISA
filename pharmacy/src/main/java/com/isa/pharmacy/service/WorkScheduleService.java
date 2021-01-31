package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.WorkSchedule;
import com.isa.pharmacy.repository.WorkScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkScheduleService {
    @Autowired
    private WorkScheduleRepository workScheduleRepository;

    public WorkSchedule save(WorkSchedule ws) { return workScheduleRepository.save(ws);}

    public List<WorkSchedule> getAll(){ return workScheduleRepository.findAll(); }
}
