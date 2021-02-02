package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.*;
import com.isa.pharmacy.domain.Profile.Patient;
import com.isa.pharmacy.domain.Profile.Pharmacist;
import com.isa.pharmacy.domain.Profile.User;
import com.isa.pharmacy.repository.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PharmacistService {
    @Autowired
    private PharmacistRepository pharmacistRepository;
    @Autowired
    private UserService userService;

    public Pharmacist save(Pharmacist p) {
        User u = userService.create(p.getUser());
        return pharmacistRepository.save(p);
    }

    public List<Pharmacist> getAll(){ return pharmacistRepository.findAll(); }

    public Long deletePharmacistById(Long id) {return pharmacistRepository.deletePharmacistById(id);}

    public Pharmacist update(Pharmacist p) {
        Pharmacist pharmacist = pharmacistRepository.findPharmacistById(p.getId());
        pharmacist.setUser(p.getUser());
        pharmacist.setFirstLog(false);
        pharmacistRepository.save(pharmacist);
        return pharmacist;
    }

    public WorkSchedule getWorkScheduleByPharmacist(Long id){
        return pharmacistRepository.findPharmacistById(id).getWorkSchedule();
    }

    public List<Patient> getPatientsByPharmacist(Long id){
        List<Patient> patients = null;
        for(Counseling c : pharmacistRepository.findPharmacistById(id).getCounselings()){
            patients.add(c.getPatient());
        }
        return patients;
    }

    public List<VacationSchedule> getVacationScheduleByPharmacist(Long id){
        return pharmacistRepository.findPharmacistById(id).getVacationSchedules();
    }

}
