package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.OrderOffer;
import com.isa.pharmacy.domain.SupplierOffer;
import com.isa.pharmacy.repository.OrderOfferRepository;
import com.isa.pharmacy.repository.SupplierOfferRepository;
import com.isa.pharmacy.users.domain.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierOfferService {
    @Autowired
    private SupplierOfferRepository supplierOfferRepository;
    @Autowired
    private OrderOfferRepository orderOfferRepository;

    public void createOffer(SupplierOffer supplierOffer){
        for(OrderOffer orderOffer: supplierOffer.getOrderOffer())
            orderOfferRepository.save(orderOffer);
        supplierOfferRepository.save(supplierOffer);
    }
}
