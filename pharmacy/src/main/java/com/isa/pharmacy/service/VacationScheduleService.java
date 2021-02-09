package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.domain.VacationSchedule;
import com.isa.pharmacy.repository.VacationScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VacationScheduleService {

    @Autowired
    private VacationScheduleRepository vacationScheduleRepository;

    public VacationSchedule save(VacationSchedule vs) {
        if(vs.getStartDate().compareTo(vs.getEndDate()) > 0 )
            throw new InvalidActionException("Start date can't be greater than end date");
        return vacationScheduleRepository.save(vs);
    }

    public List<VacationSchedule> getAll(){ return vacationScheduleRepository.findAll(); }

    public boolean isEmployeeOnVacation(List<VacationSchedule> vacationList, Date eagerDate){
        for(VacationSchedule vacation : vacationList)
            if(isOnVacation(vacation, eagerDate))
                return true;
        return false;
    }

    private boolean isOnVacation(VacationSchedule vacation, Date eagerDate){
        return (vacation.getStartDate().compareTo(eagerDate) <= 0 &&
                vacation.getEndDate().compareTo(eagerDate) >= 0);
    }
}
