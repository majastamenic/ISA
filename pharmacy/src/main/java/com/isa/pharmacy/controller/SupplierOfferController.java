package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.SupplierOfferDto;
import com.isa.pharmacy.controller.dto.ViewOrderOfferDto;
import com.isa.pharmacy.controller.mapping.OrderMapper;
import com.isa.pharmacy.controller.mapping.SupplierOfferMapper;
import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.domain.SupplierOffer;
import com.isa.pharmacy.domain.enums.OrderOfferType;
import com.isa.pharmacy.service.interfaces.IOrderService;
import com.isa.pharmacy.service.interfaces.ISupplierOfferService;
import com.isa.pharmacy.users.domain.Supplier;
import com.isa.pharmacy.users.service.interfaces.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/supplier-offer")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class SupplierOfferController {

    @Autowired
    private ISupplierOfferService supplierOfferService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private ISupplierService supplierService;

    @GetMapping("/{email}")
    public List<ViewOrderOfferDto> getAllSupplierOffers(@PathVariable String email){
        List<SupplierOffer> supplierOfferList = supplierOfferService.getAllSupplierOffers(email);
        List<ViewOrderOfferDto> viewOrderOfferDtos = SupplierOfferMapper.mapSupplierOffersAndOrdersToViewOrderOfferDtos(supplierOfferList);
        List<Order> orders = orderService.findOrderWithoutSupplierOffer(email);
        if(!orders.isEmpty())
            viewOrderOfferDtos.addAll(OrderMapper.mapOrdersToViewOrderOffersDto(orders).stream().distinct().collect(Collectors.toList()));
        return viewOrderOfferDtos;
    }

    @GetMapping
    public List<ViewOrderOfferDto> filter(@RequestParam String email, @RequestParam OrderOfferType type){
        List<SupplierOffer> supplierOfferList = supplierOfferService.filter(email, type);
        return SupplierOfferMapper.mapSupplierOffersAndOrdersToViewOrderOfferDtos(supplierOfferList);
    }

    @PostMapping
    public void createOffer(@RequestBody SupplierOfferDto supplierOfferDto){
        Order order = orderService.getById(supplierOfferDto.getOrderId());
        Supplier supplier = supplierService.getByEmail(supplierOfferDto.getSupplierEmail());
        SupplierOffer supplierOffer = SupplierOfferMapper.mapSupplierOfferDtoToSupplierOffer(supplierOfferDto, order, supplier);

        supplierOfferService.createOffer(supplierOffer);
    }
}
