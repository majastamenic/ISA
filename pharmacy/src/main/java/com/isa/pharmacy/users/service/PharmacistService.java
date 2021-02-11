package com.isa.pharmacy.users.service;


import com.isa.pharmacy.controller.dto.*;
import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.mapping.CounselingMapper;
import com.isa.pharmacy.scheduling.DateManipulation;
import com.isa.pharmacy.scheduling.domain.VacationSchedule;
import com.isa.pharmacy.scheduling.service.VacationScheduleService;
import com.isa.pharmacy.users.controller.dto.CreatePharmacistDto;
import com.isa.pharmacy.users.controller.mapping.PharmacistMapper;
import com.isa.pharmacy.service.CounselingService;
import com.isa.pharmacy.service.PharmacyService;
import com.isa.pharmacy.scheduling.service.WorkScheduleService;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.domain.User;
import com.isa.pharmacy.users.repository.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PharmacistService {
    @Autowired
    private PharmacistRepository pharmacistRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CounselingService counselingService;
    @Autowired
    private WorkScheduleService workScheduleService;
    @Autowired
    private VacationScheduleService vacationScheduleService;
    @Autowired
    private PharmacyService pharmacyService;


    public Pharmacist savePharmacist(Pharmacist pharmacist){
        return pharmacistRepository.save(pharmacist);
    }

    public CreatePharmacistDto save(CreatePharmacistDto p) {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (pattern.matcher(p.getUser().getEmail()).matches()) {
            for (Pharmacist pha : pharmacistRepository.findAll()) {
                if (pha.getUser().getEmail().equalsIgnoreCase(p.getUser().getEmail())) {
                    return null;
                }
            }
            User dbUser = userService.create(p.getUser());
            Pharmacist pharmacist = PharmacistMapper.mapCreatePharmacistDtoToPharmacist(p);
            pharmacist.setUser(dbUser);

            for (Long id : p.getWorkScheduleIds()) {
                pharmacist.getWorkSchedule().add(this.workScheduleService.getById(id));
            }

            pharmacist.setPharmacy(this.pharmacyService.getById(p.getPharmacyId()));
            Pharmacist savedPharmacist = pharmacistRepository.save(pharmacist);
//            Pharmacy pharmacy = this.pharmacyService.getById(p.getPharmacyId());
//            this.pharmacyService.save(pharmacy);
            return PharmacistMapper.mapPharmacistToCreatePharmacistDto(savedPharmacist);
        }
        return null;
    }

    public List<Pharmacist> getAll(){ return pharmacistRepository.findAll(); }

    public Long deletePharmacistById(Long id) {return pharmacistRepository.deletePharmacistById(id);}

    public Pharmacist update(Pharmacist p) {
        Pharmacist pharmacist = pharmacistRepository.findPharmacistById(p.getId());
        pharmacist.setUser(p.getUser());
        pharmacistRepository.save(pharmacist);
        return pharmacist;
    }


    public List<VacationSchedule> getVacationScheduleByPharmacist(Long id){
        return pharmacistRepository.findPharmacistById(id).getVacationSchedules();
    }

    public Pharmacist findUserByEmail(String email){
        return pharmacistRepository.findPharmacistByUser_email(email);
    }

    public List<PharmacistByPharmacyDto> findPharmacistsByPharmacyId(Long id){
        List<Pharmacist> pharmacists = pharmacistRepository.findPharmacistByPharmacy_id(id);
        List<PharmacistByPharmacyDto> pharmacistByPharmacyDtos = new ArrayList<>();
        for(Pharmacist pharmacist:pharmacists){
            pharmacistByPharmacyDtos.add(PharmacistMapper.mapPharmacistToPharmacistByPharmacyDto(pharmacist));
        }
        return pharmacistByPharmacyDtos;
    }

    public List<Pharmacist> getFreePharmacistByPharmacyAndDate(String pharmacyName, DateTimeDto date){
        List<Pharmacist> freePharmacists = new ArrayList<>();
        for (Pharmacist pharmacist : getFreePharmacistByDate(date))
            if(pharmacist.getPharmacy().getName().equals(pharmacyName))
                freePharmacists.add(pharmacist);
        return freePharmacists;
    }

    public List<Pharmacist> getFreePharmacistByDate(DateTimeDto date){
        Date eagerDate = DateManipulation.mergeDateAndTime(date.getDate(), date.getTime());
        List<Pharmacist> freePharmacists = new ArrayList<>();
        for(Pharmacist pharmacist : pharmacistRepository.findAll()){
            if(counselingService.isPharmacistOccupied(pharmacist, eagerDate) ||
               vacationScheduleService.isEmployeeOnVacation(pharmacist.getVacationSchedules(), eagerDate))
                continue;
            if(workScheduleService.isEmployeeWorking(pharmacist.getWorkSchedule(), eagerDate))
                freePharmacists.add(pharmacist);
        }
        return freePharmacists;
    }


    public boolean checkVacationTerm(VacationScheduleDto vacationScheduleDto, String email){
        VacationSchedule vacationSchedule = new VacationSchedule();
        if(vacationScheduleDto == null){
            throw new NullPointerException("No parametars");
        }
        Date requiredStartDate = vacationScheduleDto.getStartDate();
        Date requiredEndDate = vacationScheduleDto.getEndDate();
        if(requiredStartDate.before(requiredEndDate) || requiredStartDate.equals(requiredEndDate) || requiredEndDate == null){
            boolean validVacationTerms = vacationScheduleService.compareDateWithVacations(vacationScheduleService.getVacationScheduleByPharmacist(email),
                    requiredStartDate, requiredEndDate, email);
            boolean validWorkTimeTerms = workScheduleService.compareDateWithWorkTime(workScheduleService.getWorkScheduleByPharmacist(email),
                    requiredStartDate, requiredEndDate, email);
            boolean validCounselingTerms = counselingService.compareDateWithCounselingTerm(CounselingMapper.mapListCounselingToCounselingDto(counselingService.getCounselingByPharmacist(findUserByEmail(email))),
                    requiredStartDate, requiredEndDate, email);
            if(validCounselingTerms && validVacationTerms && validWorkTimeTerms){
                vacationSchedule.setStartDate(requiredStartDate);
                vacationSchedule.setEndDate(requiredEndDate);
                vacationScheduleService.save(vacationSchedule);
                Pharmacist pharmacist = findUserByEmail(email);
                List<VacationSchedule> pharmacistVacations = new ArrayList<>();
                for(VacationSchedule vs : pharmacist.getVacationSchedules()){
                    pharmacistVacations.add(vs);
                }
                pharmacistVacations.add(vacationSchedule);
                pharmacist.setVacationSchedules(pharmacistVacations);
                savePharmacist(pharmacist);
                return true;
            }
        }else{
            throw new InvalidActionException("Start date can't be after end date.");
        }

        return false;
    }








}
