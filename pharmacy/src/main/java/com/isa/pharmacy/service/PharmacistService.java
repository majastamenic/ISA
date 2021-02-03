package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.CreatePharmacistDto;
import com.isa.pharmacy.controller.dto.PharmacistDto;
import com.isa.pharmacy.controller.mapping.PharmacistMapper;
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
    @Autowired
    private WorkScheduleService workScheduleService;
    @Autowired
    private PharmacyService pharmacyService;


    public CreatePharmacistDto save(CreatePharmacistDto p) {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(pattern.matcher(p.getUser().getEmail()).matches()){
            for(Pharmacist pha: pharmacistRepository.findAll()){
                if(pha.getUser().getEmail().equalsIgnoreCase(p.getUser().getEmail())){return null;}
            }
            User dbUser= userService.create(p.getUser());
            Pharmacist pharmacist = PharmacistMapper.mapCreatePharmacistDtoToPharmacist(p);
            pharmacist.setUser(dbUser);

            for (Long id: p.getWorkScheduleIds()) {
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
        pharmacist.setFirstLog(false);
        pharmacistRepository.save(pharmacist);
        return pharmacist;
    }

    public List<WorkSchedule> getWorkScheduleByPharmacist(Long id){
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
