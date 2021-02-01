package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.*;
import com.isa.pharmacy.repository.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PharmacistService {
    @Autowired
    private PharmacistRepository pharmacistRepository;

    public Pharmacist save(Pharmacist p) {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(pattern.matcher(p.getEmail()).matches()){
            for(Pharmacist pha: pharmacistRepository.findAll()){
                if(pha.getEmail().equalsIgnoreCase(p.getEmail())){return null;}
            }
            return pharmacistRepository.save(p);
        }
        return null;
    }

    public List<Pharmacist> getAll(){ return pharmacistRepository.findAll(); }

    public Long deletePharmacistById(Long id) {return pharmacistRepository.deletePharmacistById(id);}

    public Pharmacist update(Pharmacist p) {
        Pharmacist pharmacist = pharmacistRepository.findPharmacistById(p.getId());
        pharmacist.setName(p.getName());
        pharmacist.setSurname(p.getSurname());
        pharmacist.setAddress(p.getAddress());
        pharmacist.setCity(p.getCity());
        pharmacist.setCountry(p.getCountry());
        pharmacist.setPhone(p.getPhone());
        pharmacist.setEmail(p.getEmail());
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
