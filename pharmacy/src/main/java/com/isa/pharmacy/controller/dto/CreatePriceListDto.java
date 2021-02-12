package com.isa.pharmacy.controller.dto;

import java.util.Date;

public class CreatePriceListDto {

    private Long id;
    private Date dateFrom;
    private Date dateTo;

    public CreatePriceListDto() {
    }

    public CreatePriceListDto(Long id, Date dateFrom, Date dateTo) {
        this.id = id;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
