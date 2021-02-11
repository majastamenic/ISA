package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.GetAllMedicinePharmacyDto;
import com.isa.pharmacy.controller.dto.MedicinePharmacyDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.service.MedicinePharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicinepharmacy")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
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

    @GetMapping("/all/pharmacist/{pharmacyName}/{email}")
    public List<MedicinePharmacyDto> getMedicinesByPharmacist(@PathVariable("pharmacyName")String pharmacistEmail, @PathVariable("email")String patientEmail) {
        return medicinePharmacyService.getMedicinesByPharmacist(pharmacistEmail, patientEmail);
    }

    @GetMapping("/{id}")
    public List<MedicinePharmacyDto> getMedicinePharmacyByCounseling(@PathVariable("id")Long id){return medicinePharmacyService.getMedicinesByCounseling(id);}
}
