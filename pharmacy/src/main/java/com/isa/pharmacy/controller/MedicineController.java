package com.isa.pharmacy.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.pharmacy.controller.dto.MedicineDto;
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
	public List<MedicineDto> getAll(){
		List<MedicineDto> listMedicineDto = new ArrayList<MedicineDto>();
		List<Medicine> listMedicine = medicineService.getAll();
		for(Medicine m: listMedicine) {
			listMedicineDto.add(MedicineMapper.mapMedicineDtoToMedicine(m));
		}
		return listMedicineDto;
	}
	
	@RequestMapping(value="qrcode/{id}", method = RequestMethod.GET)
	public void QRcode(@PathVariable("id") String id, HttpServletResponse response) {
		response.setContentType("image/png");
	}
	
}
