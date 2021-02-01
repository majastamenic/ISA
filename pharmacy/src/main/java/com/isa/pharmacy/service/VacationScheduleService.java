package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.VacationSchedule;
import com.isa.pharmacy.repository.VacationScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VacationScheduleService {
    @Autowired
    private VacationScheduleRepository vacationScheduleRepository;

    public VacationSchedule save(VacationSchedule vs) {
        if(vs.getStartDate().before(vs.getEndDate()) || vs.getStartDate().equals(vs.getEndDate()))
            return vacationScheduleRepository.save(vs);
        return null;
    }

    public List<VacationSchedule> getAll(){ return vacationScheduleRepository.findAll(); }
}
