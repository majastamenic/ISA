package com.isa.pharmacy.controller.dto;
import com.isa.pharmacy.domain.Order;

import java.util.Date;
import java.util.List;

public class OrderDto {

    private Long id;
    private List<OrderOfferDto> orderOffers;
    private Date endDate;
    private Date endTime;
    private String pharmacyAdminEmail;

    public OrderDto(){}

    public OrderDto(Long id, List<OrderOfferDto> orderOffers, Date endDate, Date endTime, String pharmacyAdminEmail) {
        this.id = id;
        this.orderOffers = orderOffers;
        this.endDate = endDate;
        this.endTime = endTime;
        this.pharmacyAdminEmail = pharmacyAdminEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderOfferDto> getOrderOffers() {
        return orderOffers;
    }

    public void setOrderOffers(List<OrderOfferDto> orderOffers) {
        this.orderOffers = orderOffers;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPharmacyAdminEmail() {
        return pharmacyAdminEmail;
    }

    public void setPharmacyAdminEmail(String pharmacyAdminEmail) {
        this.pharmacyAdminEmail = pharmacyAdminEmail;
    }
}
