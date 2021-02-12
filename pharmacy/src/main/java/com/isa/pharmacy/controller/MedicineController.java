package com.isa.pharmacy.controller;

import java.util.ArrayList;
import java.util.List;

import com.isa.pharmacy.controller.dto.*;
import com.isa.pharmacy.domain.enums.FormOfMedicine;
import com.isa.pharmacy.domain.enums.MedicinePublishingType;
import com.isa.pharmacy.service.interfaces.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.isa.pharmacy.controller.mapping.MedicineMapper;
import com.isa.pharmacy.domain.Medicine;


@RestController
@RequestMapping("/medicine")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class MedicineController {

    @Autowired
    private IMedicineService medicineService;

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


    @PostMapping("/check/{pharmacyName}")
    public List<AvailabilityMedicineDto> checkAvailabilityMedicines(@PathVariable String pharmacyName, @RequestBody List<String> meds){
        return medicineService.checkAvailabilityMedicines(pharmacyName, meds);
    }

    @PostMapping("/check/pharmacist/{pharmacistEmail}")
    public List<AvailabilityMedicineDto> checkAvailabilityMedicinesByPharmacist(@PathVariable String pharmacistEmail, @RequestBody List<String> meds){
        return medicineService.checkAvailabilityMedicinesByPharmacist(pharmacistEmail, meds);
    }

    @GetMapping("specification/{name}")
    public MedicineDto findMedicineSpecification(@PathVariable("name") String name){
        return medicineService.findMedicineSpecification(name);
    }

}
