package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.SupplierOfferDto;
import com.isa.pharmacy.controller.dto.ViewOrderOfferDto;
import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.domain.SupplierOffer;
import com.isa.pharmacy.domain.enums.OrderOfferType;
import com.isa.pharmacy.users.domain.Supplier;

import java.util.ArrayList;
import java.util.List;

public class SupplierOfferMapper {

    public static SupplierOffer mapSupplierOfferDtoToSupplierOffer(SupplierOfferDto supplierOfferDto, Order order, Supplier supplier){
        SupplierOffer supplierOffer = new SupplierOffer();
        supplierOffer.setOrder(order);
        supplierOffer.setId(supplierOfferDto.getId());
        supplierOffer.setSupplier(supplier);
        supplierOffer.setType(OrderOfferType.WAITING_FOR_ANSWER);
        supplierOffer.setTotalPrice(supplierOfferDto.getTotalPrice());
        supplierOffer.setDeliveryDate(supplierOfferDto.getDeliveryDate());
        return supplierOffer;
    }

    public static SupplierOfferDto mapSupplierOfferToSupplierOfferDto(SupplierOffer supplierOffer){
        SupplierOfferDto supplierOfferDto = new SupplierOfferDto();
        supplierOfferDto.setDeliveryDate(supplierOffer.getDeliveryDate());
        supplierOfferDto.setOrderId(supplierOffer.getOrder().getId());
        supplierOfferDto.setId(supplierOffer.getId());
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

    public static ViewOrderOfferDto mapSupplierOfferAndOrderToViewOrderOfferDto(SupplierOffer supplierOffer){
        ViewOrderOfferDto viewOrderOfferDto = new ViewOrderOfferDto();
        viewOrderOfferDto.setId(supplierOffer.getOrder().getId());
        viewOrderOfferDto.setEndDate(supplierOffer.getOrder().getEndDate());
        if(supplierOffer.getOrder().getPharmacyAdmin() != null)
            viewOrderOfferDto.setPharmacyAdminEmail(supplierOffer.getOrder().getPharmacyAdmin().getUser().getEmail());
        viewOrderOfferDto.setType(supplierOffer.getType());
        viewOrderOfferDto.setSupplierEmail(supplierOffer.getSupplier().getUser().getEmail());
        viewOrderOfferDto.setTotalPrice(supplierOffer.getTotalPrice());
        viewOrderOfferDto.setDeliveryDate(supplierOffer.getDeliveryDate());
        return viewOrderOfferDto;
    }

    public static List<ViewOrderOfferDto> mapSupplierOffersAndOrdersToViewOrderOfferDtos (List<SupplierOffer> supplierOfferList){
        List<ViewOrderOfferDto> viewOrderOfferDtos = new ArrayList<>();
        for(SupplierOffer supplierOffer: supplierOfferList){
            viewOrderOfferDtos.add(mapSupplierOfferAndOrderToViewOrderOfferDto(supplierOffer));
        }
        return viewOrderOfferDtos;
    }
}
