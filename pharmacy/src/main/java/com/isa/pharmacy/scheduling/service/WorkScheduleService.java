package com.isa.pharmacy.scheduling.service;

import com.isa.pharmacy.controller.dto.WorkScheduleDto;
import com.isa.pharmacy.controller.dto.WorkSchedulePharmacyDto;
import com.isa.pharmacy.controller.mapping.WorkScheduleMapper;
import com.isa.pharmacy.scheduling.DateManipulation;
import com.isa.pharmacy.scheduling.domain.WorkSchedule;
import com.isa.pharmacy.scheduling.repository.WorkScheduleRepository;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.service.DermatologistService;
import com.isa.pharmacy.users.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WorkScheduleService {

    @Autowired
    private WorkScheduleRepository workScheduleRepository;
    @Autowired
    private DermatologistService dermatologistService;
    @Autowired
    private PharmacistService pharmacistService;


    public List<WorkScheduleDto> getAll(){
        List<WorkScheduleDto> schedulesDtos= new ArrayList<>();
        List<WorkSchedule> schedules = workScheduleRepository.findAll();
        for (WorkSchedule schedule:schedules) {
            schedulesDtos.add(WorkScheduleMapper.mapWorkScheduleToWorkScheduleDto(schedule));
        }
        return schedulesDtos;
    }

    public WorkSchedule getById(Long id) {
        return this.workScheduleRepository.findWorkScheduleById(id);
    }

    public WorkSchedule save(WorkSchedule ws) {
        if((ws.getSchedule().getStartDate().before(ws.getSchedule().getEndDate())
                || ws.getSchedule().getStartDate().equals(ws.getSchedule().getEndDate()))
                && ws.getSchedule().getStartTime().before(ws.getSchedule().getEndTime())){
            return workScheduleRepository.save(ws);
        }
        return null;
    }

    public boolean isEmployeeWorking(List<WorkSchedule> wsList, Date eagerDate){
        for(WorkSchedule ws : wsList){
            if(isWorking(ws, eagerDate))
                return true;
        }
        return false;
    }

    private boolean isWorking(WorkSchedule ws, Date eagerDate){
        Date startTime = DateManipulation.mergeDateAndTime(eagerDate, ws.getSchedule().getStartTime());
        Date endTime = DateManipulation.mergeDateAndTime(eagerDate, ws.getSchedule().getEndTime());
        return (ws.getSchedule().getStartDate().compareTo(eagerDate) <= 0 &&
                ws.getSchedule().getEndDate().compareTo(eagerDate) >= 0 &&
                startTime.compareTo(eagerDate) <= 0 &&
                endTime.compareTo(eagerDate) >= 0);
    }

    public List<WorkSchedulePharmacyDto> getWorkScheduleByDermatologist(String email){
        List<WorkSchedulePharmacyDto> workSchedulesDto = new ArrayList<>();
        Dermatologist dermatologist = dermatologistService.findUserByEmail(email);
        List<WorkSchedule> workSchedules = dermatologist.getWorkSchedule();
        if(workSchedules != null){
            for(WorkSchedule ws: workSchedules)
                workSchedulesDto.add(WorkScheduleMapper.mapWorkScheduleToWorkSchedulePharmacyDto(ws, ws.getAdmin().getPharmacy().getName()));
        }
        return workSchedulesDto;
    }


    public List<WorkSchedulePharmacyDto> getWorkScheduleByPharmacist(String email){
        List<WorkSchedulePharmacyDto> workSchedulesDto = new ArrayList<>();
        Pharmacist pharmacist = pharmacistService.findUserByEmail(email);
        List<WorkSchedule> workSchedules = pharmacist.getWorkSchedule();
        if(workSchedules != null){
            for(WorkSchedule ws: workSchedules)
                workSchedulesDto.add(WorkScheduleMapper.mapWorkScheduleToWorkSchedulePharmacyDto(ws, pharmacist.getPharmacy().getName()));
        }
        return workSchedulesDto;
    }
}
