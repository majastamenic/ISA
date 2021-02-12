package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.CounselingDto;
import com.isa.pharmacy.controller.dto.ExamDermatologistDto;
import com.isa.pharmacy.controller.dto.ExaminationCreateDto;
import com.isa.pharmacy.controller.dto.WorkSchedulePharmacyDto;
import com.isa.pharmacy.controller.exception.BadRequestException;
import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.ExaminationMapper;
import com.isa.pharmacy.controller.mapping.ScheduleMapper;
import com.isa.pharmacy.domain.*;
import com.isa.pharmacy.repository.ExaminationRepository;
import com.isa.pharmacy.scheduling.DateManipulation;
import com.isa.pharmacy.scheduling.domain.Schedule;
import com.isa.pharmacy.scheduling.service.interfaces.IScheduleService;
import com.isa.pharmacy.scheduling.service.interfaces.IWorkScheduleService;
import com.isa.pharmacy.service.interfaces.*;
import com.isa.pharmacy.users.controller.dto.PatientDto;
import com.isa.pharmacy.users.controller.mapping.PatientMapper;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.service.interfaces.IDermatologistService;
import com.isa.pharmacy.users.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ExaminationService implements IExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;
    @Autowired
    private IPatientService patientService;
    @Autowired
    private IEmailService emailService;
    @Autowired
    private IDermatologistService dermatologistService;
    @Autowired
    private IPharmacyService pharmacyService;
    @Autowired
    private IPrescriptionService prescriptionService;
    @Autowired
    private IDiagnosisService diagnosisService;
    @Autowired
    private IMedicineService medicineService;
    @Autowired
    private IEPrescriptionService ePrescriptionService;
    @Autowired
    private IWorkScheduleService workScheduleService;
    @Autowired
    private IScheduleService scheduleService;


    public Examination save(Examination examination){
        return examinationRepository.save(examination);
    }

    public List<Examination> getAllFreeExaminationTerms(){
        List<Examination> freeExaminations = new ArrayList<>();
        for(Examination exam : examinationRepository.findAll())
            if(exam.getPatient() == null && exam.getSchedule().getStartDate().after(Calendar.getInstance().getTime()))
                freeExaminations.add(exam);
        return freeExaminations;
    }

    public List<Examination> getFreeExaminationTermsByPharmacy(String pharmacyName){
        List<Examination> freeExaminations = new ArrayList<>();
        for(Examination exam : examinationRepository.findAll())
            if(exam.getPharmacy().getName().equals(pharmacyName) &&
               exam.getPatient() == null &&
               exam.getSchedule().getStartDate().after(Calendar.getInstance().getTime()))
                freeExaminations.add(exam);
        return freeExaminations;
    }

    public List<Examination> getExaminationByPatient(String email){
        return examinationRepository.findByPatient(patientService.getPatient(email));
    }

    public void scheduleExamination(String patientEmail, Long examinationId){
        Examination examination = examinationRepository.findExaminationById(examinationId);
        if(examination.getPatient() != null || examination.getSchedule().getStartDate().before(Calendar.getInstance().getTime()))
            throw new InvalidActionException("Examination cannot be scheduled!");
        examination.setPatient(patientService.getPatient(patientEmail));
        Examination scheduledExam = examinationRepository.save(examination);
        try{emailService.successfulExamSchedule(scheduledExam);
        }catch (Exception e){
            throw new BadRequestException("Email feature not available on heroku");
        }
    }

    public void cancelExamination(Long examinationId){
        Examination examination = examinationRepository.findExaminationById(examinationId);
        Date currentDate = DateManipulation.addMinutes(new Date(), 60*24);
        if((currentDate.compareTo(examination.getSchedule().mergeStartDateAndTime())) > 0)
            throw new InvalidActionException("Too late! Examination can't be canceled!");
        Examination newExamination = new Examination(examination.getDermatologist(),
                examination.getPharmacy(), examination.getSchedule(), examination.getPrice(),
                examination.getLoyaltyGroup());
        examinationRepository.delete(examination);
        examinationRepository.save(newExamination);
    }

    public List<ExamDermatologistDto> getAllByDermatologist(Dermatologist dermatologist) {
        List<Examination> examinations = examinationRepository.findByDermatologist(dermatologist);
        List<ExamDermatologistDto> examDermatologistDtos = new ArrayList<>();
        if(examinations.isEmpty() == false){
            for(Examination e : examinations){
                if(e.getPatient() != null){
                    PatientDto patientDto = PatientMapper.mapPatientToPatientDto(e.getPatient());
                    ExamDermatologistDto examDermatologistDto = ExaminationMapper.mapExaminationToExaminationDto(e, patientDto);
                    examDermatologistDtos.add(examDermatologistDto);
                }
            }
        }
        return examDermatologistDtos;
    }


    public ExamDermatologistDto getById(long id) {
        Examination examination = examinationRepository.findExaminationById(id);
        if(examination == null)
            throw new NotFoundException("Examination is not found.");
        if (examination.getPatient() != null && examination.getDermatologist() != null) {
            PatientDto patientDto = PatientMapper.mapPatientToPatientDto(examination.getPatient());
            return ExaminationMapper.mapExaminationToExaminationDto(examination, patientDto);
        } else if (examination.getPatient() == null || examination.getDermatologist() == null)
            throw new InvalidActionException("Examination with that id exist but no one scheduled it.");
        throw new NotFoundException("Examination not found");
    }

    public List<String> getDermatologistNameByPatient(Patient patient){
        String dermatologistName;
        List<String> dermatologistNames = new ArrayList<>();
        List<Examination> examinationList = examinationRepository.findByPatient(patient);
        for(Examination examination: examinationList){
            if(examination.getPatientCame() != null && examination.getPatientCame()){
                dermatologistName = examination.getDermatologist().getUser().getRole().toString() + ": " + examination.getDermatologist().getUser().getName()+" "+ examination.getDermatologist().getUser().getSurname();
                dermatologistNames.add(dermatologistName);
            }
        }
        return dermatologistNames;
    }

    public ExamDermatologistDto updateExamination(ExamDermatologistDto updateExamination){
        Examination updated = examinationRepository.findExaminationById(updateExamination.getId());
        Examination exam = new Examination();
        if(updated != null){
            Dermatologist dermatologist = dermatologistService.findUserByEmail(updateExamination.getEmail());
            Patient patient = patientService.getPatient(updateExamination.getPatientDto().getUser().getEmail());
            if(dermatologist != null && patient != null){
                List<Diagnosis> diagnosis = diagnosisService.getAllDiagnosisById(updateExamination.getPrescription().getDiagnosis());
                List<Medicine> medicines = medicineService.getAllMedicinesByCode(updateExamination.getPrescription().getMedicines());
                medicines = medicineService.decreaseQuantityInPharmacy(medicines, updateExamination.getPharmacyName());
                if(!updateExamination.getPatientCame()){
                    patient.setPenal(patient.getPenal() + 1);
                    patientService.save(patient);
                }
                Pharmacy pharmacy = pharmacyService.getPharmacyByName(updateExamination.getPharmacyName());
                Prescription prescription = new Prescription();
                prescription.setMedicines(medicines);
                prescription.setDiagnosis(diagnosis);
                prescription.setDays(updateExamination.getPrescription().getDays());
                prescriptionService.save(prescription);
                if(prescription.getMedicines() != null && prescription.getDays() != null){
                    ePrescriptionService.createEPrescription(prescription, patient);
                }
                exam.setPrescription(prescription);
                exam = ExaminationMapper.mapExaminationDtoToExamination(updateExamination, dermatologist, patient, pharmacy, prescription, updated.getSchedule());
                exam.setLoyaltyGroup(updated.getLoyaltyGroup());
                prescriptionService.save(prescription);
                examinationRepository.save(exam);
            }else{
                throw new InvalidActionException("Can't update examination without patient and pharmacist.");
            }
        }else{
            throw new NotFoundException("Examination not found.");
        }
        return updateExamination;
    }


    public List<Examination> getFreeExaminationsByDermatologist(String email){
        List<Examination> freeExaminations = new ArrayList<>();
        Dermatologist dermatologist = dermatologistService.findUserByEmail(email);
        if(dermatologist != null){
            for(Examination e : getAllFreeExaminationTerms()){
                if(e.getDermatologist().equals(dermatologist) && e.getSchedule() != null){
                    freeExaminations.add(e);
                }
            }
        }
        return freeExaminations;
    }

    public List<Examination> getFreeExaminationByDermatologistPatient(Long id){
        ExamDermatologistDto oldExamination = getById(id);
        List<Examination> freeDermExams = getFreeExaminationsByDermatologist(oldExamination.getEmail());
        List<Examination> freeDermPharmacyExams = new ArrayList<>();
        DateManipulation dm = new DateManipulation();
        Patient patient = patientService.getPatient(oldExamination.getPatientDto().getUser().getEmail());
        for(Examination e: freeDermExams){
            Date start = dm.mergeDateAndTime(e.getSchedule().getStartDate(), e.getSchedule().getStartTime());
            Date end = dm.mergeDateAndTime(e.getSchedule().getEndDate(), e.getSchedule().getEndTime());
            if(e.getPharmacy().getName().equals(oldExamination.getPharmacyName()) && patientService.patientIsFree(patient, start, end)){
                freeDermPharmacyExams.add(e);
            }
        }
        return  freeDermPharmacyExams;
    }

    public boolean createExaminationByDermatologist(ExaminationCreateDto examinationCreateDto){
        DateManipulation dm = new DateManipulation();
        Date start = dm.mergeDateAndTime(examinationCreateDto.getSchedule().getStartDate(), examinationCreateDto.getSchedule().getStartTime());
        Date end = dm.mergeDateAndTime(examinationCreateDto.getSchedule().getEndDate(), examinationCreateDto.getSchedule().getEndTime());
        ExamDermatologistDto oldExamination = getById(examinationCreateDto.getOldExaminationId());
        Dermatologist dermatologist = dermatologistService.findUserByEmail(oldExamination.getEmail());
        String pharmacyName = oldExamination.getPharmacyName();
        Patient patient = patientService.getPatient(oldExamination.getPatientDto().getUser().getEmail());
        List <WorkSchedulePharmacyDto> dermatologistWork = workScheduleService.getWorkScheduleByDermatologist(dermatologist.getUser().getEmail());
        if(workScheduleService.dermatologistIsWorking(examinationCreateDto, dermatologist, pharmacyName)){
            if(dermatologistNotOnExamination(dermatologist, start, end)){
                if(patientService.patientIsFree(patient, start, end)){
                    Examination examination = new Examination();
                    Schedule schedule = ScheduleMapper.mapWorkScheduleDtoToSchedule(examinationCreateDto.getSchedule());
                    examination.setDermatologist(dermatologist);
                    examination.setPharmacy(pharmacyService.getPharmacyByName(pharmacyName));
                    examination.setPatient(patient);
                    examination.setSchedule(schedule);
                    scheduleService.save(schedule);
                    save(examination);
                    return true;
                }
            }
        }
        return false;
    }


    public boolean dermatologistNotOnExamination(Dermatologist dermatologist, Date start, Date end){
        List<Examination> examinations = examinationRepository.findByDermatologist(dermatologist);
        DateManipulation dm = new DateManipulation();
        for(Examination exam: examinations){
            Date startExam = dm.mergeDateAndTime(exam.getSchedule().getStartDate(), exam.getSchedule().getStartTime());
            Date endExam = dm.mergeDateAndTime(exam.getSchedule().getEndDate(), exam.getSchedule().getEndTime());
            if((start.before(startExam) && end.before(startExam)) || (start.after(endExam) && end.after(endExam))){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }



    public boolean compareDateWithExaminationTerm(Dermatologist dermatologist, Date requiredStartDate, Date requiredEndDate){
        List<Examination> examinations = examinationRepository.findByDermatologist(dermatologist);
        for(Examination exam : examinations){
            if(requiredStartDate.before(exam.getSchedule().getStartDate())){
                continue;
            }else if(requiredStartDate.after(exam.getSchedule().getStartDate())){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

}
