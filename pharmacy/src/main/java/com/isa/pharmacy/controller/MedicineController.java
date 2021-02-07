package com.isa.pharmacy.controller;

import java.util.ArrayList;
import java.util.List;


import com.isa.pharmacy.controller.dto.medicine.AddMedicineDto;
import com.isa.pharmacy.controller.dto.medicine.MedicineLoyaltyDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.isa.pharmacy.controller.dto.medicine.MedicineDto;
import com.isa.pharmacy.controller.mapping.MedicineMapper;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.service.MedicineService;

@RestController
@RequestMapping("/medicine")
@CrossOrigin(value = "http://localhost:4200")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public List<MedicineDto> getAll() {
        List<MedicineDto> listMedicineDto = new ArrayList<>();
        List<Medicine> listMedicine = medicineService.getAll();
        for (Medicine medicine : listMedicine) {
            //TODO: Treba logovana apoteka
            listMedicineDto.add(MedicineMapper.mapMedicineToMedicineDto(medicine, ""));
        }
        return listMedicineDto;
    }

    @GetMapping("/loyalty")
    public List<MedicineLoyaltyDto> getAllMedicines() {
        List<MedicineLoyaltyDto> listMedicineDto = new ArrayList<>();
        List<Medicine> listMedicine = medicineService.getAll();
        for (Medicine medicine : listMedicine) {
            listMedicineDto.add(MedicineMapper.mapMedicineToMedicineLoyalityDto(medicine));
        }
        return listMedicineDto;
    }

    @PutMapping("/loyalty")
    public MedicineLoyaltyDto changeLoyalty(@RequestBody MedicineLoyaltyDto medicineLoyaltyDto){
        return medicineService.changeLoyalty(medicineLoyaltyDto);
    }

    @PostMapping
    public Medicine addMedicines(@RequestBody AddMedicineDto medicineDto) {
        Medicine medicine = MedicineMapper.mapAddMedicineDtoToMedicine(medicineDto);
        return medicineService.create(medicine);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        Medicine medicine = medicineService.findById(id);
        medicineService.delete(medicine);
    }

    @GetMapping("/getAllMedicines")
    public List<MedicineDto> getMedicineFromPharmacy() {
        List<MedicineDto> medicineDtoList = medicineService.getAllMedicines();
        if (medicineDtoList.isEmpty()) {
            throw new NotFoundException("Pharmacy system doesn't have any medicine");
        }
        return medicineDtoList;
    }
}
