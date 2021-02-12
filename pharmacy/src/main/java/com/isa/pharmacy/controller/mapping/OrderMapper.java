package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.OrderDto;
import com.isa.pharmacy.controller.dto.ViewOrderOfferDto;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.users.domain.PharmacyAdmin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderMapper {

    public static Order mapOrderDtoToOrder(OrderDto orderDto, PharmacyAdmin pharmacyAdmin, List<Medicine> medicineList){
        Order order = new Order();
        order.setPharmacyAdmin(pharmacyAdmin);
        order.setEndDate(orderDto.getEndDate());
        order.setEndTime(order.getEndTime());
        order.setOrderOffers(OrderOffersMapper.mapOrderOffersDtoToOrderOffers(orderDto.getOrderOffers(), medicineList));
        return order;
    }

    public static OrderDto mapOrderToOrderDto(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setEndDate(order.getEndDate());
        orderDto.setEndTime(order.getEndTime());
        orderDto.setId(order.getId());
        orderDto.setPharmacyAdminEmail(order.getPharmacyAdmin().getUser().getEmail());
        orderDto.setOrderOffers(OrderOffersMapper.mapOrderOffersToOrderOffersDto(order.getOrderOffers()));
        return orderDto;
    }

    public static List<OrderDto> mapOrdersToOrdersDto(List<Order> orders){
        List<OrderDto> orderDtoList = new ArrayList<>();
        for(Order order: orders){
            orderDtoList.add(mapOrderToOrderDto(order));
        }
        return orderDtoList;
    }

    public static Collection<ViewOrderOfferDto> mapOrdersToViewOrderOffersDto(List<Order> orders){
        List<ViewOrderOfferDto> viewOrderOfferDtos = new ArrayList<>();
        for (Order order : orders)
            viewOrderOfferDtos.add(mapOrderToViewOrderOfferDto(order));
        return viewOrderOfferDtos;
    }

    public static ViewOrderOfferDto mapOrderToViewOrderOfferDto(Order order){
        ViewOrderOfferDto viewOrderOfferDto = new ViewOrderOfferDto();
        viewOrderOfferDto.setId(order.getId());
        viewOrderOfferDto.setOrderOffers(OrderOffersMapper.mapOrderOffersToOrderOffersDto(order.getOrderOffers()));
        viewOrderOfferDto.setEndDate(order.getEndDate());
        viewOrderOfferDto.setEndTime(order.getEndTime());
        if(order.getPharmacyAdmin().getUser() != null)
            viewOrderOfferDto.setPharmacyAdminEmail(order.getPharmacyAdmin().getUser().getEmail());
        return viewOrderOfferDto;
    }
}
