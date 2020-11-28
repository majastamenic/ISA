package com.isa.pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.pharmacy.service.MedicineService;

@RestController
@RequestMapping("/medicine")
@CrossOrigin(value = "http://localhost:4200")
public class MedicineController {
	@Autowired
	private MedicineService medicineService;
}
