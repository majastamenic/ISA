package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.GetAllMedicinePharmacyDto;
import com.isa.pharmacy.controller.dto.MedicinePharmacyDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.MedicinePharmacyMapper;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.service.interfaces.IMedicinePharmacyService;
import com.isa.pharmacy.service.interfaces.IPharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medicinepharmacy")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class MedicinePharmacyController {

    @Autowired
    private IMedicinePharmacyService medicinePharmacyService;

    @Autowired
    private IPharmacyService pharmacyService;

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

    @GetMapping("/getMedicines/{name}")
    public List<GetAllMedicinePharmacyDto> getMedicinePharmacyByPharmacyName(@PathVariable("name")String name) {
        Pharmacy pharmacy = pharmacyService.getPharmacyByName(name);
        List<GetAllMedicinePharmacyDto> medicineDtoList = medicinePharmacyService.getAllMedicinesByPharmacies(pharmacy.getId());
        if (medicineDtoList.isEmpty()) {
            throw new NotFoundException("Pharmacy system doesn't have any medicine");
        }
        return medicineDtoList;
    }

    @PutMapping("/{medicineName}/{medicineId}/{adminEmail}")
    public void deleteFromPharmacy(@PathVariable String medicineName, @PathVariable Long medicineId, @PathVariable String adminEmail){
        medicinePharmacyService.deleteFromPharmacy(medicineName,adminEmail,medicineId);
    }

    @GetMapping("/getMedicinesByAdminPharmacy/{email}")
    public List<GetAllMedicinePharmacyDto> getMedicinePharmacyByPharmacyAdmin(@PathVariable("email")String email) {
       List<GetAllMedicinePharmacyDto> medicineDtoList = medicinePharmacyService.getAllMedicinesByAdminPharmacy(email);
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

    @GetMapping("/medicine/{medName}")
    public List<MedicinePharmacyDto> getMedicinePharmaciesByMedicineName(@PathVariable String medName){
        return MedicinePharmacyMapper.mapListMedicinePharmacyToMedicinePhDto(
                medicinePharmacyService.getByMedicine(medName));
    }
}
