package com.isa.pharmacy.controller;

import java.util.ArrayList;
import java.util.List;

import com.isa.pharmacy.controller.dto.AddMedicineDto;
import com.isa.pharmacy.controller.dto.MedicineLoyaltyDto;
import com.isa.pharmacy.controller.dto.SearchMedicineDto;
import com.isa.pharmacy.domain.enums.FormOfMedicine;
import com.isa.pharmacy.domain.enums.MedicinePublishingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.isa.pharmacy.controller.mapping.MedicineMapper;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.service.MedicineService;


@RestController
@RequestMapping("/medicine")
@CrossOrigin(value = "http://localhost:4200")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

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
    public Page<SearchMedicineDto> getMedicineFromPharmacy(@RequestParam int pageSize, @RequestParam int pageNumber) {
        Page<Medicine> medicineList = medicineService.getAll(pageNumber, pageSize);
        return medicineList.map(MedicineMapper::mapMedicineToSearchMedicineDto);
    }

    @GetMapping("/search")
    public Page<SearchMedicineDto> searchMedicine(@RequestParam int pageSize, @RequestParam int pageNumber,
                                                  @RequestParam String name, @RequestParam(required = false) Double startPrice,
                                                  @RequestParam(required = false) Double endPrice, @RequestParam(required = false) List<Long> pharmacies,
                                                  @RequestParam(required = false) String typeOfMedicine, @RequestParam(required = false) String manufactured,
                                                  @RequestParam(required = false) String composition, @RequestParam(required = false) FormOfMedicine formOfMedicine,
                                                  @RequestParam(required = false) MedicinePublishingType publishingType ){
        Page<Medicine> medicines = medicineService.filterMedicines(pageSize, pageNumber, name, startPrice, endPrice,
                pharmacies, typeOfMedicine, manufactured, composition, formOfMedicine, publishingType);
        return medicines.map(MedicineMapper::mapMedicineToSearchMedicineDto);
    }
}
