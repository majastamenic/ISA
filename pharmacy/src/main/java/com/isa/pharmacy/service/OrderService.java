package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.SupplierOfferDto;
import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.SupplierOfferMapper;
import com.isa.pharmacy.domain.*;
import com.isa.pharmacy.domain.enums.OrderState;
import com.isa.pharmacy.repository.OrderRepository;
import com.isa.pharmacy.service.interfaces.IEmailService;
import com.isa.pharmacy.service.interfaces.IMedicinePharmacyService;
import com.isa.pharmacy.service.interfaces.IOrderService;
import com.isa.pharmacy.service.interfaces.ISupplierOfferService;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.users.service.interfaces.IPharmacyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ISupplierOfferService supplierOfferService;
    @Autowired
    private IEmailService emailService;
    @Autowired
    private IMedicinePharmacyService medicinePharmacyService;
    @Autowired
    private IPharmacyAdminService pharmacyAdminService;

    public List<Order> getAll(){
        List<Order> orders= orderRepository.findAll();
        if(orders.isEmpty())
            throw new NotFoundException("There is no any order.");
        return orders;
    }

    public void save(Order order){
        orderRepository.save(order);
    }

    public void deleteOrder(Long id){
        Order order = orderRepository.findOrderById(id);
        if(order == null)
            throw new NotFoundException("Order has already been deleted");
        List<SupplierOfferDto> orderOfferList = supplierOfferService.offersByOrderId(order.getId());
        if(!orderOfferList.isEmpty())
            throw new InvalidActionException("You can't delete order with offers");
        orderRepository.delete(order);
    }

    public Order getById(Long id){
        Order order = orderRepository.findOrderById(id);
        if(order == null)
            throw new NotFoundException("Order doesn't exists.");
        return order;
    }

    public List<Order> getByOffers(List<SupplierOffer> supplierOffers){
        List<Order> orderList = new ArrayList<>();
        for(SupplierOffer supplierOffer: supplierOffers){
            orderList.add(orderRepository.findOrderById(supplierOffer.getOrder().getId()));
        }
        return orderList;
    }

    public List<Order> findOrderWithoutSupplierOffer(String email){
        return orderRepository.findOrderWithoutSupplierOffer(email);
    }

    public void updateWinner(Long winnerId,String adminEmail){
        SupplierOffer supplierOffer = supplierOfferService.getById(winnerId);
        Order order = supplierOffer.getOrder();
        PharmacyAdmin admin = pharmacyAdminService.findPharmacyAdminByEmail(adminEmail);
        List<SupplierOfferDto> supplierOffers= supplierOfferService.offersByOrderId(order.getId());
        Date date = new Date();
        if(order.getPharmacyAdmin().equals(admin)) {
            if (order.getEndDate().before(date)) {
                order.setWinnerId(winnerId);
                orderRepository.save(order);
                emailService.orderWinner(supplierOffer.getSupplier().getUser().getEmail());
                supplierOffers.remove(SupplierOfferMapper.mapSupplierOfferToSupplierOfferDto(supplierOffer));
                for (SupplierOfferDto offer : supplierOffers) {
                    if (supplierOffers != null)
                        emailService.orderNonWinner(offer.getSupplierEmail());
                }
                MedicinePharmacy medicinePharmacy = medicinePharmacyService.getByPharmacyAndMedicine(order.getPharmacyAdmin().getPharmacy().getName(), order.getMedicine().getName());
                if (medicinePharmacy == null) {
                    MedicinePharmacy medicinePharmacy1 = new MedicinePharmacy();
                    medicinePharmacy1.setPharmacy(order.getPharmacyAdmin().getPharmacy());
                    medicinePharmacy1.setMedicine(order.getMedicine());
                    medicinePharmacy1.setQuantity(order.getQuantity());
                    medicinePharmacy1.setPrice(order.getPrice());
                    medicinePharmacyService.save(medicinePharmacy1);
                } else {
                    medicinePharmacy.setQuantity(medicinePharmacy.getQuantity() + order.getQuantity());
                    medicinePharmacyService.save(medicinePharmacy);
                }
            }
            else{
                throw new InvalidActionException("You can't set winner before expiration date");
            }
        }
        else
            throw new InvalidActionException("You can't set winner because you didn't create order");
    }

    public List<Order> getAllByAdmin(String adminEmail){
        List<Order> orders= orderRepository.findAll();
        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.findPharmacyAdminByEmail(adminEmail);
        List<Order> deleteList = new ArrayList<>();
        for(Order o:orders){
            if(!o.getPharmacyAdmin().getPharmacy().equals(pharmacyAdmin.getPharmacy()) || o.getOrderState().equals(OrderState.PROCESSED))
                deleteList.add(o);
        }
        orders.removeAll(deleteList);

        if(orders.isEmpty())
            throw new NotFoundException("There is no any order.");
        return orders;
    }

    public List<Order> getAllFinishedByAdmin(String adminEmail){
        List<Order> orders= orderRepository.findAll();
        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.findPharmacyAdminByEmail(adminEmail);
        List<Order> deleteList = new ArrayList<>();
        for(Order o:orders){
            if(!o.getPharmacyAdmin().getPharmacy().equals(pharmacyAdmin.getPharmacy()) || o.getOrderState().equals(OrderState.WAITING_FOR_OFFERS))
                deleteList.add(o);
        }
        orders.removeAll(deleteList);

        if(orders.isEmpty())
            throw new NotFoundException("There is no any order.");
        return orders;
    }



}
