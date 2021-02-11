package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.CounselingDto;
import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.CounselingMapper;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.Report;
import com.isa.pharmacy.repository.CounselingRepository;
import com.isa.pharmacy.scheduling.service.ScheduleService;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.service.PatientService;
import com.isa.pharmacy.users.service.PharmacistService;
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
    @Autowired
    private PharmacistService pharmacistService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PharmacyService pharmacyService;
    @Autowired
    private MedicineService medicineService;


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


    public List<String> getPharmacistNameByPatient(Patient patient){
        List<String> pharmacistNames = new ArrayList<>();
        for(Counseling counseling: counselingRepository.findByPatient(patient)){
            if(counseling.getPatientCame()){
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
