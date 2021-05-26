package com.isa.pharmacy.scheduling.service;

import com.isa.pharmacy.controller.dto.VacationConfirmationDto;
import com.isa.pharmacy.controller.dto.VacationScheduleDto;
import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.VacationScheduleMapper;
import com.isa.pharmacy.scheduling.domain.VacationSchedule;
import com.isa.pharmacy.scheduling.repository.VacationScheduleRepository;
import com.isa.pharmacy.scheduling.service.interfaces.IVacationService;
import com.isa.pharmacy.service.interfaces.IEmailService;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.users.service.interfaces.IDermatologistService;
import com.isa.pharmacy.users.service.interfaces.IPharmacistService;
import com.isa.pharmacy.users.service.interfaces.IPharmacyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VacationScheduleService implements IVacationService {

    @Autowired
    private VacationScheduleRepository vacationScheduleRepository;
    @Autowired
    private IDermatologistService dermatologistService;
    @Autowired
    private IPharmacistService pharmacistService;
    @Autowired
    private IPharmacyAdminService pharmacyAdminService;
    @Autowired
    private IEmailService emailService;

    public VacationSchedule save(VacationSchedule vs) {
        if(vs.getStartDate().compareTo(vs.getEndDate()) > 0 )
            throw new InvalidActionException("Start date can't be greater than end date");
        return vacationScheduleRepository.save(vs);
    }

    public List<VacationSchedule> getAll(){ return vacationScheduleRepository.findAll(); }

    public VacationSchedule update(VacationSchedule vacationSchedule){
        VacationSchedule vs= vacationScheduleRepository.getVacationScheduleById(vacationSchedule.getId());
        if(vs ==null)
            throw new NotFoundException("Dermatologist doesn't exists.");
        vs.setApproved(vacationSchedule.getApproved());
        vacationScheduleRepository.save(vs);
        return vs;
    }
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

    public List<VacationScheduleDto> getVacationScheduleDermatologists(){
        List<Dermatologist> dermatologistList = dermatologistService.getAll();
        List<VacationScheduleDto> vacationScheduleDtos = new ArrayList<>();
        for(Dermatologist dermatologist:dermatologistList){
            List<VacationSchedule> vacationSchedules = dermatologist.getVacationSchedules();
            for(VacationSchedule vs:vacationSchedules){
                if(vs.getApproved() == false)
                    vacationScheduleDtos.add(VacationScheduleMapper.mapVacationScheduleToVacationScheduleDto(vs));
            }
        }
        return vacationScheduleDtos;
    }

    public void confirmation(VacationConfirmationDto vacationSchedule){
        VacationSchedule vacationSchedule1 = vacationScheduleRepository.getVacationScheduleById(vacationSchedule.getVacationScheduleId());
        List<Dermatologist> dermatologistList = dermatologistService.getAll();
        for(Dermatologist dermatologist : dermatologistList){
            if(dermatologist.getVacationSchedules().contains(vacationSchedule1)){
                if(vacationSchedule.getConfirmed().equals("Confirmed")) {
                    vacationSchedule1.setApproved(true);
                    //emailService.confirmedVacation(dermatologist.getUser().getEmail(), vacationSchedule.getMessage());
                    update(vacationSchedule1);
                }else {
                    vacationSchedule1.setApproved(false);
                    //emailService.declinedVacation(dermatologist.getUser().getEmail(), vacationSchedule.getMessage());
                    update(vacationSchedule1);
                }
            }
        }
    }

    public void confirmationPharmacist(VacationConfirmationDto vacationSchedule){
        VacationSchedule vacationSchedule1 = vacationScheduleRepository.getVacationScheduleById(vacationSchedule.getVacationScheduleId());
        List<Pharmacist> dermatologistList = pharmacistService.getAll();
        for(Pharmacist dermatologist : dermatologistList){
            if(dermatologist.getVacationSchedules().contains(vacationSchedule1)){
                if(vacationSchedule.getConfirmed().equals("Confirmed")) {
                    vacationSchedule1.setApproved(true);
                    //emailService.confirmedVacation(dermatologist.getUser().getEmail(), vacationSchedule.getMessage());
                    update(vacationSchedule1);
                }else {
                    vacationSchedule1.setApproved(false);
                    //emailService.declinedVacation(dermatologist.getUser().getEmail(), vacationSchedule.getMessage());
                    update(vacationSchedule1);
                }
            }
        }
    }

    public List<VacationScheduleDto> getVacationScheduleByDermatologist(String email){
        List<VacationScheduleDto> vacationScheduleDtos = new ArrayList<>();
        Dermatologist dermatologist = dermatologistService.findUserByEmail(email);
        if(dermatologist != null){
            List<VacationSchedule> vacationSchedules = dermatologist.getVacationSchedules();
            if(vacationSchedules != null){
                for(VacationSchedule vs: vacationSchedules)
                    vacationScheduleDtos.add(VacationScheduleMapper.mapVacationScheduleToVacationScheduleDto(vs));
            }
        }
        return vacationScheduleDtos;
    }

    public List<VacationScheduleDto> getVacationSchedulePharmacists(String email){
        List<VacationScheduleDto> vacationScheduleDtos = new ArrayList<>();
        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.findPharmacyAdminByEmail(email);
        List<Pharmacist> pharmacists = pharmacistService.getAll();
        for(Pharmacist pharmacist:pharmacists) {
            if (pharmacist.getPharmacy().equals(pharmacyAdmin.getPharmacy())) {
                List<VacationSchedule> vacationSchedules = pharmacist.getVacationSchedules();
                for (VacationSchedule vs : vacationSchedules) {
                    if (vs.getApproved() == false)
                        vacationScheduleDtos.add(VacationScheduleMapper.mapVacationScheduleToVacationScheduleDto(vs));
                }
            }
        }
        return vacationScheduleDtos;
    }

    public List<VacationScheduleDto> getVacationScheduleByPharmacist(String email){
        List<VacationScheduleDto> vacationScheduleDtos = new ArrayList<>();
        Pharmacist pharmacist = pharmacistService.findUserByEmail(email);
        if(pharmacist != null){
            List<VacationSchedule> vacationSchedules = pharmacist.getVacationSchedules();
            if(vacationSchedules != null){
                for(VacationSchedule vs: vacationSchedules)
                    vacationScheduleDtos.add(VacationScheduleMapper.mapVacationScheduleToVacationScheduleDto(vs));
            }
        }
        return vacationScheduleDtos;
    }



    public boolean compareDateWithVacations(List<VacationScheduleDto> workerVacations, Date requiredStartDate, Date requiredEndDate){
        for(VacationScheduleDto vs: workerVacations){
            if(requiredStartDate.before(vs.getStartDate()) && requiredEndDate.before(vs.getStartDate())){
                continue;
            }else if(requiredStartDate.after(vs.getEndDate()) && requiredEndDate.after(vs.getEndDate())){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }


}
