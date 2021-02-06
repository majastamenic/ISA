package com.isa.pharmacy.service;

import java.util.ArrayList;
import java.util.List;

import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.controller.mapping.MedicineMapper;
import com.isa.pharmacy.domain.MedicinePharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.repository.MedicineRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
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

    public Medicine findByName(String name) {
        return medicineRepository.findMedicineByName(name);
    }

    public List<Medicine> getAll() {
        return medicineRepository.findAll();
    }

    public List<MedicineDto> getAllMedicines() {
        List<MedicineDto> medicineDtoList = new ArrayList<>();
        for(Medicine medicine: medicineRepository.findAll()) {
            for (MedicinePharmacy medicinePharmacy :medicine.getMedicinePharmacy()) {
                medicineDtoList.add(MedicineMapper.mapMedicineToMedicineDto(medicinePharmacy.getMedicine(), medicinePharmacy.getPharmacy().getName()));
            }
        }
        return medicineDtoList;
    }
}
