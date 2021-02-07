package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.OrderOfferDto;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.domain.OrderOffer;

import java.util.ArrayList;
import java.util.List;

public class OrderOffersMapper {
    public static OrderOffer mapOrderOfferDtoToOrderOffer(OrderOfferDto orderOfferDto, Medicine medicine){
        OrderOffer orderOffer = new OrderOffer();
        orderOffer.setMedicine(medicine);
        orderOffer.setPrice(orderOffer.getPrice());
        orderOffer.setQuantity(orderOffer.getQuantity());
        return orderOffer;
    }

    public static List<OrderOffer> mapOrderOffersDtoToOrderOffers(List<OrderOfferDto> orderOfferDtoList, List<Medicine> medicines){
        List<OrderOffer> orderOfferList = new ArrayList<>();
        for(OrderOfferDto orderOfferDto: orderOfferDtoList){
            for(Medicine medicine: medicines){
                if(orderOfferDto.getMedicineName().equals(medicine.getName()))
                    orderOfferList.add(mapOrderOfferDtoToOrderOffer(orderOfferDto, medicine));
            }
        }
        return orderOfferList;
    }

    public static OrderOfferDto mapOrderOfferToOrderOfferDto(OrderOffer orderOffer){
        OrderOfferDto orderOfferDto = new OrderOfferDto();
        orderOfferDto.setMedicineName(orderOffer.getMedicine().getName());
        orderOfferDto.setQuantity(orderOffer.getQuantity());
        orderOfferDto.setPrice(orderOffer.getPrice());
        return orderOfferDto;
    }

    public static List<OrderOfferDto> mapOrderOffersToOrderOffersDto(List<OrderOffer> orderOfferList){
        List<OrderOfferDto> orderOfferDtoList = new ArrayList<>();
        for(OrderOffer orderOffer: orderOfferList){
            orderOfferDtoList.add(mapOrderOfferToOrderOfferDto(orderOffer));
        }
        return orderOfferDtoList;
    }
}
