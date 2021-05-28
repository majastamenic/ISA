package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.controller.dto.SupplierOfferDto;
import com.isa.pharmacy.domain.SupplierOffer;
import com.isa.pharmacy.domain.enums.OrderOfferType;

;import java.util.List;

public interface ISupplierOfferService {

     void createOffer(SupplierOffer supplierOffer);

     List<SupplierOffer> getAllSupplierOffers(String email);

     List<SupplierOffer> filter(String email, OrderOfferType type);

     SupplierOffer getOffer(Long orderId, String supplierEmail);

     List<SupplierOfferDto> offersByOrderId(Long id);

     SupplierOffer getById(Long id);
}
