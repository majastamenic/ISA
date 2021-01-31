package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.*;
import com.isa.pharmacy.repository.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacistService {
    @Autowired
    private PharmacistRepository pharmacistRepository;

    public Pharmacist save(Pharmacist p) { return pharmacistRepository.save(p); }

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
        Pharmacist pharmacist = pharmacistRepository.findPharmacistById(id);
        return pharmacist.getWorkSchedule();
    }

    public List<Patient> getPatientsByPharmacist(Long id){
        Pharmacist pharmacist = pharmacistRepository.findPharmacistById(id);
        List<Counseling> counselings = pharmacist.getCounselings();
        List<Patient> patients = null;
        for(Counseling c : counselings){
            if(!patients.contains(c.getPatient())){
                patients.add(c.getPatient());
            }
        }
        return patients;
    }

}
