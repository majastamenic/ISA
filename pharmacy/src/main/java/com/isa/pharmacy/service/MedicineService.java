package com.isa.pharmacy.service;

import java.util.ArrayList;
import java.util.List;

import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.controller.dto.MedicineLoyaltyDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.MedicineMapper;
import com.isa.pharmacy.domain.MedicinePharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.repository.MedicineRepository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private PharmacyService pharmacyService;

    public Medicine create(Medicine medicine) {
        if(medicineRepository.findMedicineById(medicine.getId()) != null)
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        return medicineRepository.save(medicine);
    }

    public void delete(Medicine medicine) {
        medicineRepository.delete(medicine);

    }

    public Medicine findById(Long id) {
        return medicineRepository.findMedicineById(id);
    }

    public List<Medicine> getAll() {
        List<Medicine> medicineList = medicineRepository.findAll();
        if(medicineList == null)
            throw new NotFoundException("Pharmacy system doesnt have any medicine");
        return medicineList;
    }

    public List<MedicineDto> getAllMedicines() {
        List<Medicine> medicineList = medicineRepository.findAll();
        List<MedicineDto> medicineDtoList = new ArrayList<>();
        for(Medicine medicine: medicineList) {
            for (MedicinePharmacy medicinePharmacy :medicine.getMedicinePharmacy()) {
                medicineDtoList.add(MedicineMapper.mapMedicineToMedicineDto(medicinePharmacy.getMedicine(), medicinePharmacy.getPharmacy().getName()));
            }
        }
        return medicineDtoList;
    }

    public MedicineLoyaltyDto changeLoyalty(MedicineLoyaltyDto medicineLoyaltyDto){
        Medicine medicine = medicineRepository.findMedicineByCode(medicineLoyaltyDto.getCode());
        if(medicine == null)
            throw new NotFoundException("Medicine "+ medicineLoyaltyDto.getName()+" doesnt exist.");
        medicine.setLoyaltyPoints(medicineLoyaltyDto.getLoyaltyPoints());
        medicineRepository.save(medicine);
        return medicineLoyaltyDto;
    }
}
