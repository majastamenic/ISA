package com.isa.pharmacy.service;

import com.isa.pharmacy.repository.SupplierOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierOfferService {
    @Autowired
    private SupplierOfferRepository supplierOfferRepository;
}
