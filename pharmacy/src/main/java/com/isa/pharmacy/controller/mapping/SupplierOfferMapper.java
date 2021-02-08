package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.SupplierOfferDto;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.domain.SupplierOffer;
import com.isa.pharmacy.users.domain.Supplier;

import java.util.ArrayList;
import java.util.List;

public class SupplierOfferMapper {
    public static SupplierOffer mapSupplierOfferDtoToSupplierOffer(SupplierOfferDto supplierOfferDto, Order order, Supplier supplier){
        SupplierOffer supplierOffer = new SupplierOffer();
        supplierOffer.setOrder(order);
        supplierOffer.setSupplier(supplier);
        supplierOffer.setType(supplierOfferDto.getType());
        supplierOffer.setTotalPrice(supplierOfferDto.getTotalPrice());
        supplierOffer.setDeliveryDate(supplierOfferDto.getDeliveryDate());
        return supplierOffer;
    }

    public static SupplierOfferDto mapSupplierOfferToSupplierOfferDto(SupplierOffer supplierOffer){
        SupplierOfferDto supplierOfferDto = new SupplierOfferDto();
        supplierOfferDto.setDeliveryDate(supplierOffer.getDeliveryDate());
        supplierOfferDto.setOrderId(supplierOffer.getOrder().getId());
        supplierOfferDto.setSupplierEmail(supplierOffer.getSupplier().getUser().getEmail());
        supplierOfferDto.setTotalPrice(supplierOffer.getTotalPrice());
        supplierOfferDto.setType(supplierOffer.getType());
        return supplierOfferDto;
    }

    public static List<SupplierOfferDto> mapSupplierOffersToSupplierOffersDto(List<SupplierOffer> supplierOfferList){
        List<SupplierOfferDto> supplierOfferDtoList = new ArrayList<>();
        for(SupplierOffer supplierOffer: supplierOfferList)
            supplierOfferDtoList.add(mapSupplierOfferToSupplierOfferDto(supplierOffer));
        return supplierOfferDtoList;
    }
}
