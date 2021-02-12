package com.isa.pharmacy.users.service;

import com.isa.pharmacy.controller.dto.ExamDermatologistDto;
import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.scheduling.DateManipulation;
import com.isa.pharmacy.service.interfaces.ICounselingService;
import com.isa.pharmacy.service.interfaces.IExaminationService;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.User;
import com.isa.pharmacy.users.repository.PatientRepository;
import com.isa.pharmacy.users.service.interfaces.IPatientService;
import com.isa.pharmacy.users.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private ICounselingService counselingService;
    @Autowired
    private IExaminationService examinationService;

    public Patient registration(Patient patient) {
        Patient existingUser = patientRepository.findByUser_email(patient.getUser().getEmail());
        if (existingUser == null) {
            userService.create(patient.getUser());
            return patientRepository.save(patient);
        }
        throw new AlreadyExistsException(String.format("Patient with email %s, already exists", patient.getUser().getEmail()));
    }

    public String activateProfile(String email, String code){
        User user = userService.getByEmail(email);
        Patient patient = patientRepository.findByUser(user);
        if(patient != null && !patient.getUser().getActive() && patient.getVerificationCode().equals(code)){
            patient.getUser().setActive(true);
            patientRepository.save(patient);
            return "Successfully verified account";
        }
        return "Error while activating account";
    }

    public void updateAllergies(String patientEmail, List<String> allergies){
        Patient patient = getPatient(patientEmail);
        patient.setAllergicMedicines(new ArrayList<>());
        for(String allergy : allergies)
            patient.addAllergy(allergy);
        patientRepository.save(patient);
    }

    public Patient getPatient(String email){
        Patient patient = patientRepository.findByUser_email(email);
        if(patient == null)
            throw new NotFoundException("Patient with email "+ email + " doesn't exists.");
        return patient;
    }

    public List<Patient> getAllPatients(){return patientRepository.findAll();}

    public void deletePatient(long id){
        patientRepository.deleteById(id);
    }

    public Patient save(Patient p){
        Patient patient = patientRepository.findPatientById(p.getId());
        if(patient != null){
            userService.save(patient.getUser());
            return patientRepository.save(patient);
        }
        throw new NotFoundException("Patient doesn't exist.");
    }

    public boolean patientIsFree(Patient patient, Date start, Date end){
        List<Counseling> patientCouns = counselingService.getAllPatientsCounselings(patient.getUser().getEmail());
        List<Examination> patientExams = examinationService.getExaminationByPatient(patient.getUser().getEmail());
        DateManipulation dm = new DateManipulation();
        boolean validTerm = false;
        for(Counseling c: patientCouns){
            Date startCouns = dm.mergeDateAndTime(c.getSchedule().getStartDate(), c.getSchedule().getStartTime());
            Date endCouns = dm.mergeDateAndTime(c.getSchedule().getEndDate(), c.getSchedule().getEndTime());
            if((start.before(startCouns) && end.before(startCouns)) || (start.after(endCouns) && end.after(endCouns))){
                continue;
            }else{
                return false;
            }
        }
        for(Examination e : patientExams){
            Date startExam = dm.mergeDateAndTime(e.getSchedule().getStartDate(), e.getSchedule().getEndTime());
            Date endExam = dm.mergeDateAndTime(e.getSchedule().getEndDate(), e.getSchedule().getEndTime());
            if((start.before(startExam) && end.before(startExam)) || (start.after(endExam) && end.after(endExam))){
                continue;
            }else{
                return false;
            }
        }

        return true;
    }

    public String getPatientEmailByExamination(Long id){
        ExamDermatologistDto examination = examinationService.getById(id);
        return examination.getPatientDto().getUser().getEmail();
    }

}
