package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.domain.users.Supplier;
import com.isa.pharmacy.domain.users.User;
import com.isa.pharmacy.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    private UserService userService;
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier registration(Supplier supplier) {
        User existingUser = userService.getByEmail(supplier.getUser().getEmail());
        if (existingUser == null) {
            userService.create(supplier.getUser());
            return supplierRepository.save(supplier);
        }
        throw new AlreadyExistsException(String.format("Supplier with email %s, already exists", supplier.getUser().getEmail()));
    }
}
