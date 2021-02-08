package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.SupplierOffer;
import com.isa.pharmacy.repository.SupplierOfferRepository;
import com.isa.pharmacy.users.domain.Supplier;
import com.isa.pharmacy.users.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierOfferService {
    @Autowired
    private SupplierOfferRepository supplierOfferRepository;
    @Autowired
    private SupplierService supplierService;

    public void createOffer(SupplierOffer supplierOffer){
        SupplierOffer dbsupplierOffer = supplierOfferRepository.findSupplierOfferByOrder(supplierOffer.getOrder());
        if(dbsupplierOffer != null){
            dbsupplierOffer.setType(supplierOffer.getType());
            dbsupplierOffer.setDeliveryDate(supplierOffer.getDeliveryDate());
            dbsupplierOffer.setTotalPrice(supplierOffer.getTotalPrice());
            supplierOfferRepository.save(dbsupplierOffer);
        }else{
            supplierOfferRepository.save(supplierOffer);
        }
    }

    public List<SupplierOffer> getAllSupplierOffers(String email){
        Supplier supplier = supplierService.getByEmail(email);
        List<SupplierOffer> supplierOfferList = supplierOfferRepository.findSupplierOfferBySupplier(supplier);
        if(supplierOfferList.isEmpty())
            throw new NotFoundException("Supplier "+supplier.getUser().getName()+" "+ supplier.getUser().getSurname()+" doesn't have offers");
        return supplierOfferList;
    }

    public SupplierOffer getOffer(Long orderId, String supplierEmail){
        List<SupplierOffer> supplierOfferList = getAllSupplierOffers(supplierEmail);
        for(SupplierOffer supplierOffer: supplierOfferList){
            if(supplierOffer.getOrder().getId().equals(orderId))
                return supplierOffer;
        }
        throw new NotFoundException("Suppler dosen't have offer for order "+orderId);
    }
}
