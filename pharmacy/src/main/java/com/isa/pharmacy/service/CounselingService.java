package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.CounselingDto;
import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.CounselingMapper;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.Report;
import com.isa.pharmacy.repository.CounselingRepository;
import com.isa.pharmacy.scheduling.service.interfaces.IScheduleService;
import com.isa.pharmacy.service.interfaces.*;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.service.interfaces.IPatientService;
import com.isa.pharmacy.users.service.interfaces.IPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CounselingService implements ICounselingService {

    @Autowired
    private CounselingRepository counselingRepository;

    @Autowired
    private IScheduleService scheduleService;
    @Autowired
    private IReportService reportService;
    @Autowired
    private IEmailService emailService;
    @Autowired
    private IPharmacistService pharmacistService;
    @Autowired
    private IPatientService patientService;
    @Autowired
    private IMedicineService medicineService;


    public List<Counseling> getAll(){
        List<Counseling> counselingList = counselingRepository.findAll();
        if(counselingList.isEmpty())
            throw new NotFoundException("There is no counseling.");
        return counselingList;
    }

    public Counseling getCounselingById(long id){
        Counseling counseling = counselingRepository.findCounselingById(id);
        if(counseling == null)
            throw new NotFoundException("Counseling not found");
        return counseling;
    }

    public List<Counseling> getCounselingByPharmacist(Pharmacist pharmacist) {
        List<Counseling> counselingList = counselingRepository.findByPharmacist(pharmacist);
        if(counselingList.isEmpty())
            throw new NotFoundException("Pharmacist has no consultation.");
        return counselingList;
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

    public List<String> getPharmacistNameByPatient(Patient patient){
        List<String> pharmacistNames = new ArrayList<>();
        for(Counseling counseling: counselingRepository.findByPatient(patient)){
            if(counseling.getPatientCame() != null && counseling.getPatientCame()){
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

    public CounselingDto updateCounseling(CounselingDto updateCounseling) {
        Counseling updated = counselingRepository.findCounselingById(updateCounseling.getId());
        if(updated != null){
            Pharmacist pharmacist = pharmacistService.findUserByEmail(updateCounseling.getEmail());
            Patient patient = patientService.getPatient(updateCounseling.getPatientDto().getUser().getEmail());
            if(pharmacist != null && patient != null){
                List<Medicine> medicines = medicineService.getAllMedicinesByCode(updateCounseling.getReport().getMedicines());
                medicines = medicineService.decreaseQuantityInPharmacy(medicines, pharmacist.getPharmacy().getName());
                Counseling couns = CounselingMapper.mapCounselingDtoToCounseling(updateCounseling);
                couns.setPharmacist(pharmacist);
                couns.setLoyaltyGroup(updated.getLoyaltyGroup());
                if(!couns.getPatientCame() && couns.getPatientCame() != null){
                    patient.setPenal(patient.getPenal()+1);
                    patientService.save(patient);
                }else{
                    Report report = new Report();
                    report.setMedicines(medicines);
                    report.setDays(updateCounseling.getReport().getDays());
                    reportService.save(report);
                    couns.setReport(report);
                    reportService.save(report);
                }
                couns.setPatient(patient);
                patientService.save(patient);
                counselingRepository.save(couns);
            }else{
                throw new InvalidActionException("Can't update counseling without patient and pharmacist.");
            }
        }else{
            throw new NotFoundException("Counseling not found.");
        }
        return updateCounseling;
    }

}
