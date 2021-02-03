package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.CreatePriceListDto;
import com.isa.pharmacy.controller.mapping.PriceListMapper;
import com.isa.pharmacy.domain.PriceList;
import com.isa.pharmacy.repository.PriceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceListService {
    @Autowired
    private PriceListRepository priceListRepository;

    public PriceList save(CreatePriceListDto priceList){
        PriceList priceList1= PriceListMapper.mapCreatePriceListDtoToPriceList(priceList);
        return priceListRepository.save(priceList1);
    }

    public List<PriceList> findAll(){ return priceListRepository.findAll();}
}
