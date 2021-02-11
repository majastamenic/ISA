package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.GetAllMedicinePharmacyDto;
import com.isa.pharmacy.controller.dto.MedicinePharmacyDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.MedicinePharmacyMapper;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.repository.MedicinePharmacyRepository;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.service.PatientService;
import com.isa.pharmacy.users.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicinePharmacyService {
    @Autowired
    private MedicinePharmacyRepository medicinePharmacyRepository;
    @Autowired
    private CounselingService counselingService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PharmacyService pharmacyService;
    @Autowired
    private PharmacistService pharmacistService;


    public MedicinePharmacy save(MedicinePharmacy medicinePharmacy){return medicinePharmacyRepository.save(medicinePharmacy);}


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


    public List<MedicinePharmacyDto> getMedicinesByPharmacy(String pharmacyName, String email) {
        Pharmacy pharmacy = pharmacyService.getByName(pharmacyName);
        Patient patient = patientService.getPatient(email);
        List<MedicinePharmacyDto> meds = getMedicinesPharmacy(pharmacy, patient);
        return meds;
    }


    public List<MedicinePharmacyDto> getMedicinesByPharmacist(String pharmacistEmail, String patientEmail){
        Pharmacy pharmacy = pharmacistService.findUserByEmail(pharmacistEmail).getPharmacy();
        Patient patient = patientService.getPatient(patientEmail);
        List<MedicinePharmacyDto> meds = getMedicinesPharmacy(pharmacy, patient);
        return meds;
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



}
