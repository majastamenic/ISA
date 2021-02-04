package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.GetAllMedicinePharmacyDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.service.MedicinePharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicinepharmacy")
@CrossOrigin(value = "http://localhost:4200")
public class MedicinePharmacyController {

    @Autowired
    private MedicinePharmacyService medicinePharmacyService;
    @GetMapping("/getAllMedicines")
    public List<GetAllMedicinePharmacyDto> getAll() {
        List<GetAllMedicinePharmacyDto> medicineDtoList = medicinePharmacyService.getAllMedicinePharmacies();
        if (medicineDtoList.isEmpty()) {
            throw new NotFoundException("Pharmacy system doesn't have any medicine");
        }
        return medicineDtoList;
    }

    @GetMapping("/getAllMedicines/{id}")
    public List<GetAllMedicinePharmacyDto> getMedicinePharmacyByPharmacy(Long id) {
        List<GetAllMedicinePharmacyDto> medicineDtoList = medicinePharmacyService.getAllMedicinesByPharmacies(id);
        if (medicineDtoList.isEmpty()) {
            throw new NotFoundException("Pharmacy system doesn't have any medicine");
        }
        return medicineDtoList;
    }
}
