package com.isa.pharmacy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.isa.pharmacy.controller.dto.MedicineDtoList;
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
	
	@GetMapping
	public List<MedicineDtoList> getAll(){
		List<MedicineDtoList> listMedicineDto = new ArrayList<MedicineDtoList>();
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
