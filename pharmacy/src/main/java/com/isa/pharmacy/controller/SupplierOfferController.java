package com.isa.pharmacy.controller;

import com.isa.pharmacy.service.SupplierOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier-offer")
@CrossOrigin(value = "http://localhost:4200")
public class SupplierOfferController {
    @Autowired
    private SupplierOfferService supplierOfferService;
}
