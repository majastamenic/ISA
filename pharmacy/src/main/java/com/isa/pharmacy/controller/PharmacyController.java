package com.isa.pharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.service.PharmacyService;

@RestController
@RequestMapping("/pharmacy")
@CrossOrigin(value = "http://localhost:4200")
public class PharmacyController {
	
	@Autowired
	private PharmacyService pharmacyService;
	
	@GetMapping
	public List<Pharmacy> getAll(){
		return pharmacyService.getAll();
	}
	@PostMapping
	public Pharmacy save(Pharmacy p) {
		return pharmacyService.save(p);
	}
}
