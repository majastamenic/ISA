package com.isa.pharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.EPrescription;
import com.isa.pharmacy.service.EPrescriptionService;


@RestController
@RequestMapping("/ePrescription")
@CrossOrigin(value = "http://localhost:4200")
public class ePrescriptionController {
	
	@Autowired
	private EPrescriptionService ePrescriptionService;
	
	@GetMapping
	public List<EPrescription> getAll(){
		return ePrescriptionService.getAll();
	}

	
	@GetMapping("/{id}")
	public EPrescription getEPrescription(@PathVariable("id") Long id) {
		EPrescription ePrescription = ePrescriptionService.getById(id);
		if(ePrescription == null) {
			throw new NotFoundException(String.format("User with id %s not found", id));
		}
		return ePrescription;
	}
	

}
