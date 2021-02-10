package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.CounselingDto;
import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.repository.CounselingRepository;
import com.isa.pharmacy.scheduling.service.ScheduleService;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.Pharmacist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CounselingService {

    @Autowired
    private CounselingRepository counselingRepository;

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private EmailService emailService;


    public List<Counseling> getAll(){ return counselingRepository.findAll(); }

    public Counseling getCounselingById(long id){
        Counseling counseling = counselingRepository.findCounselingById(id);
        if(counseling == null)
            throw new NotFoundException("Counseling not found");
        return counseling;
    }

    public List<Counseling> getCounselingByPharmacist(Pharmacist pharmacist) {
        return counselingRepository.findByPharmacist(pharmacist);
    }

    public List<Counseling> getAllPatientsCounselings(String patientEmail){
        return counselingRepository.findCounselingByPatient_User_Email(patientEmail);
    }

    public Counseling createCounseling(Counseling counseling) {
        if(counseling.getSchedule().getStartDate().compareTo(counseling.getSchedule().getEndDate()) != 0)
            throw new InvalidActionException("Start date and end date must be on a same date");
        //TODO Gojko: Provera da li je slobodan farmaceut u tom periodu
        scheduleService.save(counseling.getSchedule());
        Counseling scheduledCounseling = counselingRepository.save(counseling);
        emailService.successfulCounselingSchedule(scheduledCounseling);
        return scheduledCounseling;
    }

    public Counseling updateCounseling(CounselingDto c) {
        Counseling counseling = counselingRepository.findCounselingById(c.getId());
        if(counseling == null)
            throw new NotFoundException("Counseling not found");
        counseling.setReport(reportService.update(c.getReport()));
        counseling.setPatientCame(c.isPatientCame());
        counselingRepository.save(counseling);
        return counseling;
    }

    public List<String> getPharmacistNameByPatient(Patient patient){
        List<String> pharmacistNames = new ArrayList<>();
        for(Counseling counseling: counselingRepository.findByPatient(patient)){
            if(counseling.isPatientCame()){
                String pharmacistName = counseling.getPharmacist().getUser().getRole().toString() + ": " + counseling.getPharmacist().getUser().getName()+" "+ counseling.getPharmacist().getUser().getSurname();
                pharmacistNames.add(pharmacistName);
            }
        }
        return pharmacistNames;
    }


    public boolean isPharmacistOccupied(Pharmacist pharmacist, Date eagerDate){
        for(Counseling c : counselingRepository.findByPharmacist(pharmacist)){
            if(c.getSchedule().mergeStartDateAndTime().compareTo(eagerDate) >= 0 &&
                c.getSchedule().mergeEndDateAndTime().compareTo(eagerDate) <= 0)
                return true;
        }
        return false;
    }
}
