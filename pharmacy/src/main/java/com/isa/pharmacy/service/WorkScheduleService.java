package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.WorkSchedule;
import com.isa.pharmacy.repository.WorkScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class WorkScheduleService {
    @Autowired
    private WorkScheduleRepository workScheduleRepository;

    public WorkSchedule save(WorkSchedule ws) {
        if((ws.getStartDate().before(ws.getEndDate()) || ws.getStartDate().equals(ws.getEndDate()))
                && ws.getStartTime().before(ws.getEndTime())){
            return workScheduleRepository.save(ws);
        }
        return null;
    }

    public List<WorkSchedule> getAll(){ return workScheduleRepository.findAll(); }
}
