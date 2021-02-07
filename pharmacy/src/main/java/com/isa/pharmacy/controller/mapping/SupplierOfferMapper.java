package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.SupplierOfferDto;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.domain.SupplierOffer;
import com.isa.pharmacy.users.domain.Supplier;

import java.util.List;

public class SupplierOfferMapper {
    public static SupplierOffer mapSupplierOfferDtoToSupplierOffer(SupplierOfferDto supplierOfferDto, Order order, List<Medicine> medicineList, Supplier supplier){
        SupplierOffer supplierOffer = new SupplierOffer();
        supplierOffer.setOrder(order);
        supplierOffer.setOrderOffer(OrderOffersMapper.mapOrderOffersDtoToOrderOffers(supplierOfferDto.getOrderOffers(), medicineList));
        supplierOffer.setSupplier(supplier);
        supplierOffer.setType(supplierOfferDto.getType());
        return supplierOffer;
    }
}
