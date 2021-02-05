package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.CreateOrderDto;
import com.isa.pharmacy.domain.Order;

import java.util.ArrayList;

public class OrderMapper {

    public static Order mapCreateOrderDtoToOrder(CreateOrderDto createOrderDto){
        Order order = new Order();
        order.setId(createOrderDto.getId());
        order.setEndTime(createOrderDto.getEndTime());
        order.setEndDate(createOrderDto.getEndDate());
        return order;
    }

    public static CreateOrderDto mapOrderToCreateOrderDto(Order order){
        CreateOrderDto createOrderDto = new CreateOrderDto();
        createOrderDto.setId(order.getId());
        createOrderDto.setEndDate(order.getEndDate());
        createOrderDto.setEndTime(order.getEndTime());
        return createOrderDto;
    }


}
