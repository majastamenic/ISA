package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.OrderOfferDto;
import com.isa.pharmacy.controller.dto.SupplierOfferDto;
import com.isa.pharmacy.controller.mapping.SupplierOfferMapper;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.domain.OrderOffer;
import com.isa.pharmacy.domain.SupplierOffer;
import com.isa.pharmacy.service.MedicineService;
import com.isa.pharmacy.service.OrderService;
import com.isa.pharmacy.service.SupplierOfferService;
import com.isa.pharmacy.users.domain.Supplier;
import com.isa.pharmacy.users.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/supplier-offer")
@CrossOrigin(value = "http://localhost:4200")
public class SupplierOfferController {
    @Autowired
    private SupplierOfferService supplierOfferService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/{email}")
    private List<SupplierOfferDto> getAllSupplierOffers(@PathVariable String email){
        return SupplierOfferMapper.mapSupplierOffersToSupplierOffersDto(supplierOfferService.getAllSupplierOffers(email));
    }

    @PostMapping
    private void createOffer(@RequestBody SupplierOfferDto supplierOfferDto){
        Order order = orderService.getById(supplierOfferDto.getOrderId());
        Supplier supplier = supplierService.getByEmail(supplierOfferDto.getSupplierEmail());
        SupplierOffer supplierOffer = SupplierOfferMapper.mapSupplierOfferDtoToSupplierOffer(supplierOfferDto, order, supplier);

        supplierOfferService.createOffer(supplierOffer);
    }
}
