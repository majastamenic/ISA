package com.isa.pharmacy.scheduling.service;

import com.isa.pharmacy.controller.dto.*;
import com.isa.pharmacy.controller.mapping.WorkScheduleMapper;
import com.isa.pharmacy.scheduling.DateManipulation;
import com.isa.pharmacy.scheduling.domain.WorkSchedule;
import com.isa.pharmacy.scheduling.repository.WorkScheduleRepository;
import com.isa.pharmacy.scheduling.service.interfaces.IWorkScheduleService;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.service.interfaces.IDermatologistService;
import com.isa.pharmacy.users.service.interfaces.IPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WorkScheduleService implements IWorkScheduleService {

    @Autowired
    private WorkScheduleRepository workScheduleRepository;
    @Autowired
    private IDermatologistService dermatologistService;
    @Autowired
    private IPharmacistService pharmacistService;

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


    public boolean compareDateWithWorkTime(List<WorkSchedulePharmacyDto> pharmacistWork, Date requiredStartDate, Date requiredEndDate){
        for(WorkSchedulePharmacyDto ws : pharmacistWork){
            if(requiredStartDate.before(ws.getWorkScheduleDto().getStartDate()) && requiredEndDate.before(ws.getWorkScheduleDto().getStartDate())){
                continue;
            }else if(requiredStartDate.after(ws.getWorkScheduleDto().getEndDate()) && requiredEndDate.after(ws.getWorkScheduleDto().getEndDate())){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean pharmacistIsWorking(Pharmacist pharmacist, CounselingCreateDto counselingCreateDto){
        List<WorkSchedulePharmacyDto> pharmacistWork = getWorkScheduleByPharmacist(pharmacist.getUser().getEmail());
        DateManipulation dm = new DateManipulation();
        Date startDate = counselingCreateDto.getSchedule().getStartDate();
        Date startTime = counselingCreateDto.getSchedule().getStartTime();
        Date endTime = counselingCreateDto.getSchedule().getEndTime();
        for(WorkSchedulePharmacyDto ws : pharmacistWork) {
            if (startDate.after(ws.getWorkScheduleDto().getStartDate()) && startDate.before(ws.getWorkScheduleDto().getEndDate()) || startDate.equals(ws.getWorkScheduleDto().getEndDate()) || startDate.equals(ws.getWorkScheduleDto().getStartDate())) {
                if (dm.mergeDateAndTime(startDate, endTime).before(ws.getWorkScheduleDto().getEndDate()) && dm.mergeDateAndTime(startDate, startTime).after(ws.getWorkScheduleDto().getStartTime())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dermatologistIsWorking(ExaminationCreateDto examinationCreateDto, Dermatologist dermatologist, String pharmacyName){
        List<WorkSchedulePharmacyDto> dermatologistWork = getWorkScheduleByDermatologist(dermatologist.getUser().getEmail());
        DateManipulation dm = new DateManipulation();
        Date startDate = examinationCreateDto.getSchedule().getStartDate();
        Date startTime = examinationCreateDto.getSchedule().getStartTime();
        Date endTime = examinationCreateDto.getSchedule().getEndTime();
        for(WorkSchedulePharmacyDto ws : dermatologistWork){
            if(ws.getPharmacyName().equals(pharmacyName)){
                if (startDate.after(ws.getWorkScheduleDto().getStartDate()) && startDate.before(ws.getWorkScheduleDto().getEndDate()) || startDate.equals(ws.getWorkScheduleDto().getEndDate()) || startDate.equals(ws.getWorkScheduleDto().getStartDate())) {
                    if (dm.mergeDateAndTime(startDate, endTime).before(dm.mergeDateAndTime(startDate, ws.getWorkScheduleDto().getEndTime())) && dm.mergeDateAndTime(startDate, startTime).after(dm.mergeDateAndTime(startDate, ws.getWorkScheduleDto().getStartTime()))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
