package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.GetAllMedicinePharmacyDto;
import com.isa.pharmacy.controller.mapping.MedicinePharmacyMapper;
import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.repository.MedicinePharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicinePharmacyService {
    @Autowired
    private MedicinePharmacyRepository medicinePharmacyRepository;

    public List<GetAllMedicinePharmacyDto> getAllMedicinePharmacies() {
        List<MedicinePharmacy> medicinePharmacies = medicinePharmacyRepository.findAll();
        List<GetAllMedicinePharmacyDto> medicineDtoList = new ArrayList<>();
        for(MedicinePharmacy medicine:medicinePharmacies){
            for(GetAllMedicinePharmacyDto medicinePharmacyDto:medicineDtoList){
                medicineDtoList.add(MedicinePharmacyMapper.mapMedicinePharmacyToGetAllMedicinePharmacyDto(medicine));
            }
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
}
