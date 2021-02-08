package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.CreateOrderDto;
import com.isa.pharmacy.controller.dto.OrderDto;
import com.isa.pharmacy.controller.dto.OrderOfferDto;
import com.isa.pharmacy.controller.mapping.OrderMapper;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.service.MedicineService;
import com.isa.pharmacy.service.OrderService;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.users.service.PharmacyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(value = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PharmacyAdminService pharmacyAdminService;
    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public List<OrderDto> getAll(){
        List<Order> orders = orderService.getAll();
        return OrderMapper.mapOrdersToOrdersDto(orders);
    }

   @PostMapping
    public void createOrder(@RequestBody OrderDto orderDto){
       PharmacyAdmin pharmacyAdmin = pharmacyAdminService.getByEmail(orderDto.getPharmacyAdminEmail());
       List<String> medicineNames = new ArrayList<>();
       for(OrderOfferDto orderOfferDto: orderDto.getOrderOffers()){
           medicineNames.add(orderOfferDto.getMedicineName());
       }
       List<Medicine> medicineList = medicineService.getMedicinesByNames(medicineNames);
       Order order = OrderMapper.mapOrderDtoToOrder(orderDto, pharmacyAdmin, medicineList);
       orderService.save(order);
   }

   @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
   }
}
