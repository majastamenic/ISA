package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.CounselingCreateDto;
import com.isa.pharmacy.controller.dto.CounselingDto;
import com.isa.pharmacy.controller.dto.WorkSchedulePharmacyDto;
import com.isa.pharmacy.controller.exception.BadRequestException;
import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.CounselingMapper;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.Report;
import com.isa.pharmacy.repository.CounselingRepository;
import com.isa.pharmacy.scheduling.DateManipulation;
import com.isa.pharmacy.scheduling.service.interfaces.IScheduleService;
import com.isa.pharmacy.scheduling.service.interfaces.IWorkScheduleService;
import com.isa.pharmacy.service.interfaces.*;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.service.interfaces.IPatientService;
import com.isa.pharmacy.users.service.interfaces.IPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.time.temporal.ChronoUnit.HOURS;

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
    @Autowired
    private IPharmacyService pharmacyService;
    @Autowired
    private IExaminationService examinationService;
    @Autowired
    private IWorkScheduleService workScheduleService;



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
        //TODO Gojko: Provera da li je slobodan farmaceut u tom periodu - NEMOJ!
        scheduleService.save(counseling.getSchedule());
        Counseling scheduledCounseling = counselingRepository.save(counseling);
        try{emailService.successfulCounselingSchedule(scheduledCounseling);
        }catch (Exception e){
            throw new BadRequestException("Email feature not available on heroku");
        }
        return scheduledCounseling;
    }

    public void cancelCounseling(Long counselingId){
        Counseling counseling = counselingRepository.findCounselingById(counselingId);
        Date currentDate = DateManipulation.addMinutes(new Date(), 60*24);
        if((currentDate.compareTo(counseling.getSchedule().mergeStartDateAndTime())) > 0)
            throw new InvalidActionException("Too late! Counseling can't be canceled!");
        counselingRepository.delete(counseling);
    }

    public boolean createCounselingByPharmacist(CounselingCreateDto counselingDto){
        DateManipulation dm = new DateManipulation();
        Date start = dm.mergeDateAndTime(counselingDto.getSchedule().getStartDate(), counselingDto.getSchedule().getStartTime());
        Date end = dm.mergeDateAndTime(counselingDto.getSchedule().getEndDate(), counselingDto.getSchedule().getEndTime());
        Pharmacist pharmacist = pharmacistService.findUserByEmail(counselingDto.getPharmacistEmail());
        Patient patient = patientService.getPatient(counselingDto.getPatientEmail());
        List<WorkSchedulePharmacyDto> pharmacistWork = workScheduleService.getWorkScheduleByPharmacist(counselingDto.getPharmacistEmail());
        if(workScheduleService.pharmacistIsWorking(pharmacist, counselingDto)) {
            boolean validCouns = pharmacistOnCounseling(pharmacist, start, end);
            if (validCouns) {
                boolean validTerm = patientService.patientIsFree(patient, start, end);
                if (validTerm) {
                    Counseling counseling = CounselingMapper.mapCounselingCreateDtoToCounseling(counselingDto);
                    counseling.setPharmacist(pharmacist);
                    counseling.setPatient(patient);
                    createCounseling(counseling);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean pharmacistOnCounseling(Pharmacist pharmacist, Date start, Date end){
        List<Counseling> pharmacistCouns = getCounselingByPharmacist(pharmacist);
        DateManipulation dm = new DateManipulation();
        for(Counseling c: pharmacistCouns){
            Date startCouns = dm.mergeDateAndTime(c.getSchedule().getStartDate(), c.getSchedule().getStartTime());
            Date endCouns = dm.mergeDateAndTime(c.getSchedule().getEndDate(), c.getSchedule().getEndTime());
            if((start.before(startCouns) && end.before(startCouns)) || (start.after(endCouns) && end.after(endCouns))){
                continue;
            }else{
                return false;
            }
        }
        return true;
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

    public boolean compareDateWithCounselingTerm(List<CounselingDto> pharmacistCounseling, Date requiredStartDate, Date requiredEndDate){
        for(CounselingDto couns : pharmacistCounseling){
            if(requiredStartDate.before(couns.getSchedule().getStartDate())){
                continue;
            }else if(requiredStartDate.after(couns.getSchedule().getStartDate())){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

}
