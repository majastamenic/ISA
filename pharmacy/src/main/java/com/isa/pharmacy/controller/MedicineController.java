package com.isa.pharmacy.controller;

import java.util.ArrayList;
import java.util.List;


import com.isa.pharmacy.controller.mapping.MedicinePharmacyMapper;
import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.service.MedicinePharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.controller.dto.MedicineDtoList;
import com.isa.pharmacy.controller.mapping.MedicineMapper;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.service.MedicineService;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
	@Autowired
	private MedicineService medicineService;
	@Autowired
	private MedicinePharmacyService medicinePharmacyService;
	
	@GetMapping
	public List<MedicineDtoList> getAll(){
		List<MedicineDtoList> listMedicineDto = new ArrayList<>();
		List<Medicine> listMedicine = medicineService.getAll();
		for(Medicine m: listMedicine) {
			listMedicineDto.add(MedicineMapper.mapMedicineDtoToMedicine(m));
		}
		return listMedicineDto;
	}
	@PostMapping
	public Medicine create(@RequestBody MedicineDto medicineDTO) {
		MedicineMapper medicineMapper = new MedicineMapper();
		Medicine medicine = medicineMapper.mapMedicineDtoToMedicine(medicineDTO);
		return medicineService.create(medicine);
	}
	
	@DeleteMapping
	public void delete(@RequestParam Long id) {
		Medicine medicine = medicineService.findById(id);
		medicineService.delete(medicine);
	}
}
