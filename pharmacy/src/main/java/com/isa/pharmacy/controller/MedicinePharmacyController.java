package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.GetAllMedicinePharmacyDto;
import com.isa.pharmacy.controller.dto.MedicinePharmacyDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.service.MedicinePharmacyService;
import com.isa.pharmacy.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<GetAllMedicinePharmacyDto> getMedicinePharmacyByPharmacy(@PathVariable("id")Long id) {
        List<GetAllMedicinePharmacyDto> medicineDtoList = medicinePharmacyService.getAllMedicinesByPharmacies(id);
        if (medicineDtoList.isEmpty()) {
            throw new NotFoundException("Pharmacy system doesn't have any medicine");
        }
        return medicineDtoList;
    }

    @GetMapping("/all/{pharmacyName}/{email}")
    public List<MedicinePharmacyDto> getMedicinesByPharmacy(@PathVariable("pharmacyName")String pharmacyName, @PathVariable("email")String email) {
        return medicinePharmacyService.getMedicinesByPharmacy(pharmacyName, email);
    }

    @GetMapping("/{id}")
    public List<MedicinePharmacyDto> getMedicinePharmacyByCounseling(@PathVariable("id")Long id){return medicinePharmacyService.getMedicinesByCounseling(id);}
}
