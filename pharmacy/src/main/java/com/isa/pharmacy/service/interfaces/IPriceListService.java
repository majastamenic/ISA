package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.controller.dto.CreatePriceListDto;
import com.isa.pharmacy.domain.PriceList;

import java.util.List;

public interface IPriceListService {

     CreatePriceListDto save(CreatePriceListDto priceListDto);

     List<PriceList> findAll();
}
