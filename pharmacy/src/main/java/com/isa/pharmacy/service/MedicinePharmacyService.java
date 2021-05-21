package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.GetAllMedicinePharmacyDto;
import com.isa.pharmacy.controller.dto.MedicinePharmacyDto;
import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.MedicinePharmacyMapper;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.repository.MedicinePharmacyRepository;
import com.isa.pharmacy.service.interfaces.ICounselingService;
import com.isa.pharmacy.service.interfaces.IMedicinePharmacyService;
import com.isa.pharmacy.service.interfaces.IMedicineService;
import com.isa.pharmacy.service.interfaces.IPharmacyService;
import com.isa.pharmacy.users.controller.dto.PharmacyAdminDto;
import com.isa.pharmacy.users.controller.mapping.PharmacyAdminMapper;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.users.service.interfaces.IPatientService;
import com.isa.pharmacy.users.service.interfaces.IPharmacistService;
import com.isa.pharmacy.users.service.interfaces.IPharmacyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicinePharmacyService implements IMedicinePharmacyService {

    @Autowired
    private MedicinePharmacyRepository medicinePharmacyRepository;
    @Autowired
    private ICounselingService counselingService;
    @Autowired
    private IPatientService patientService;
    @Autowired
    private IPharmacyService pharmacyService;
    @Autowired
    private IPharmacistService pharmacistService;
    @Autowired
    private IPharmacyAdminService pharmacyAdminService;
    @Autowired
    private IMedicineService medicineService;


    public MedicinePharmacy save(MedicinePharmacy medicinePharmacy){return medicinePharmacyRepository.save(medicinePharmacy);}

    public MedicinePharmacy getByPharmacyAndMedicine(String pharmacyName, String medicineName){
        return medicinePharmacyRepository.findMedicinePharmacyByAndPharmacy_NameAndMedicine_Name(pharmacyName, medicineName);
    }

    public List<GetAllMedicinePharmacyDto> getAllMedicinePharmacies() {
        List<MedicinePharmacy> medicinePharmacies = medicinePharmacyRepository.findAll();
        List<GetAllMedicinePharmacyDto> medicineDtoList = new ArrayList<>();
        for(MedicinePharmacy medicine:medicinePharmacies){
                medicineDtoList.add(MedicinePharmacyMapper.mapMedicinePharmacyToGetAllMedicinePharmacyDto(medicine));
        }
        return medicineDtoList;
    }

    public List<GetAllMedicinePharmacyDto> getAllMedicinesByPharmacies(Long id) {
        List<MedicinePharmacy> medicinePharmacies = medicinePharmacyRepository.findMedicinePharmacyByPharmacy_id(id);
        List<GetAllMedicinePharmacyDto> medicineDtoList = new ArrayList<>();
        for(MedicinePharmacy medicine:medicinePharmacies){
            medicineDtoList.add(MedicinePharmacyMapper.mapMedicinePharmacyToGetAllMedicinePharmacyDto(medicine));
        }
        return medicineDtoList;
    }

    public void deleteFromPharmacy(String medicineName,String adminEmail, Long id){
        Medicine medicine = medicineService.findByName(medicineName);
        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.findPharmacyAdminByEmail(adminEmail);
        Pharmacy pharmacy = pharmacyService.getPharmacyByName(pharmacyAdmin.getPharmacy().getName());
        MedicinePharmacy medicinePharmacy = getById(id);
        if(medicinePharmacy.getPharmacy().getId() != pharmacyAdmin.getPharmacy().getId()){
            throw new InvalidActionException("You are not allowed to delete this medicine");
        }
        List<MedicinePharmacy> medicinePharmacies = medicine.getMedicinePharmacy();
        medicinePharmacies.remove(medicinePharmacy);
        medicine.setMedicinePharmacy(medicinePharmacies);
        medicineService.update(medicine);
        medicinePharmacy.setPharmacy(null);
        update(medicinePharmacy);

    }

    public MedicinePharmacy getById(Long id){return medicinePharmacyRepository.findMedicinePharmacyById(id);}

    public List<GetAllMedicinePharmacyDto> getAllMedicinesByAdminPharmacy(String email) {
        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.findPharmacyAdminByEmail(email);
        Pharmacy pharmacy= pharmacyService.getById(pharmacyAdmin.getPharmacy().getId());
        List<MedicinePharmacy> medicinePharmacies = medicinePharmacyRepository.findMedicinePharmacyByPharmacy_id(pharmacy.getId());
        List<GetAllMedicinePharmacyDto> medicineDtoList = new ArrayList<>();
        for(MedicinePharmacy medicine:medicinePharmacies){
            medicineDtoList.add(MedicinePharmacyMapper.mapMedicinePharmacyToGetAllMedicinePharmacyDto(medicine));
        }
        return medicineDtoList;

    }

    public List<MedicinePharmacyDto> getMedicinesByPharmacy(String pharmacyName, String email) {
        Pharmacy pharmacy = pharmacyService.getPharmacyByName(pharmacyName);
        Patient patient = patientService.getPatient(email);
        return getMedicinesPharmacy(pharmacy, patient);
    }

    public List<MedicinePharmacyDto> getMedicinesByPharmacist(String pharmacistEmail, String patientEmail){
        Pharmacy pharmacy = pharmacistService.findUserByEmail(pharmacistEmail).getPharmacy();
        Patient patient = patientService.getPatient(patientEmail);
        return getMedicinesPharmacy(pharmacy, patient);
    }

    public List<MedicinePharmacyDto> getMedicinesPharmacy(Pharmacy pharmacy, Patient patient){
        if(pharmacy == null)
            throw  new NotFoundException("Pharmacy doesn't exist in this pharmacy system.");
        if(patient == null)
            throw  new NotFoundException("Patient doesn't exist in this pharmacy system.");
        List<MedicinePharmacy> medicinePharmacies = medicinePharmacyRepository.findMedicinePharmacyByPharmacy_id(pharmacy.getId());
        List<MedicinePharmacyDto> meds = new ArrayList<>();
        for(MedicinePharmacy mp : medicinePharmacies){
            boolean find = false;
            for(String m: patient.getAllergicMedicines()){
                if(mp.getMedicine().getName().equals(m))
                    find = true;
            }
            if(!find){
                MedicinePharmacyDto mpDto = MedicinePharmacyMapper.mapMedicinePharmacyToMedicinePharmacyDto(mp);
                meds.add(mpDto);
            }
        }
        return meds;
    }

    public void update(MedicinePharmacy medicine){
        medicinePharmacyRepository.save(medicine);
    }

    public List<MedicinePharmacyDto> getMedicinesByCounseling(long id){
        Counseling counseling = counselingService.getCounselingById(id);
        List<MedicinePharmacyDto> meds = new ArrayList<>();
        for(MedicinePharmacy mp : medicinePharmacyRepository.findMedicinePharmacyByPharmacy_id(counseling.getPharmacist().getPharmacy().getId())){
            for(String s : counseling.getPatient().getAllergicMedicines()){
                if(mp.getMedicine().getName().equalsIgnoreCase(s)){
                    MedicinePharmacyDto mpd = MedicinePharmacyMapper.mapMedicinePharmacyToMedicinePharmacyDto(mp);
                    meds.add(mpd);
                }
            }
        }
        return meds;
    }

    public List<MedicinePharmacy> getByMedicine(String medicineName){
        return medicinePharmacyRepository.findMedicinePharmaciesByMedicine_Name(medicineName);
    }
}
