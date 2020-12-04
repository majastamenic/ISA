package com.isa.pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.pharmacy.controller.dto.MedicineDTO;
import com.isa.pharmacy.controller.mapping.MedicineMapper;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.service.MedicineService;

@RestController
@RequestMapping("/medicine")
@CrossOrigin(value = "http://localhost:4200")
public class MedicineController {
	@Autowired
	private MedicineService medicineService;
	
	@PostMapping
	public Medicine create(@RequestBody MedicineDTO medicineDTO) {
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
