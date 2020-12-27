package com.isa.pharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.service.PharmacyService;

@RestController
@RequestMapping("/pharmacy")
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
	
	@GetMapping("/{name}")
	public ResponseEntity<String> sendResponse(@RequestHeader("apiKey") String apiKey) {
		if (apiKey.equals(""))
			return new ResponseEntity<String>("", 
			          HttpStatus.FORBIDDEN);
		if ((pharmacyService.getByApiKey(apiKey)).equals(""))
			return new ResponseEntity<String>("Wrong apiKey", 
			          HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<String>(
			          "Welcome", 
			          HttpStatus.OK);
	}
}
