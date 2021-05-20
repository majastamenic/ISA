package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.OrderDto;
import com.isa.pharmacy.controller.dto.OrderOfferDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.OrderMapper;
import com.isa.pharmacy.controller.mapping.OrderOffersMapper;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.domain.OrderOffer;
import com.isa.pharmacy.service.interfaces.IMedicineService;
import com.isa.pharmacy.service.interfaces.IOrderOfferService;
import com.isa.pharmacy.service.interfaces.IOrderService;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.users.service.interfaces.IPharmacyAdminService;
import com.isa.pharmacy.users.service.interfaces.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class OrderController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IPharmacyAdminService pharmacyAdminService;
    @Autowired
    private IMedicineService medicineService;
    @Autowired
    private IOrderOfferService orderOfferService;

    @GetMapping
    public List<OrderDto> getAll(){
        List<Order> orders = orderService.getAll();
        return OrderMapper.mapOrdersToOrdersDto(orders);
    }

   @PostMapping
    public void createOrder(@RequestBody OrderDto orderDto){
       PharmacyAdmin pharmacyAdmin = pharmacyAdminService.getByEmail(orderDto.getPharmacyAdminEmail());
       Medicine medicine = medicineService.findByName(orderDto.getMedicineName());
       if(medicine ==null)
           throw  new NotFoundException("Medicine doesn't exist in this pharmacy system.");
       Order order = OrderMapper.mapOrderDtoToOrder(orderDto, pharmacyAdmin, medicine);
       orderService.save(order);
   }

   @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
   }
}
