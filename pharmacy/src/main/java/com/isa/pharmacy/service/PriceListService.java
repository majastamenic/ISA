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

    public CreatePriceListDto save(CreatePriceListDto priceListDto){
        PriceList priceList = priceListRepository.save(PriceListMapper.mapCreatePriceListDtoToPriceList(priceListDto));
        return PriceListMapper.mapPriceListToCreatePriceListDto(priceList);
    }

    public List<PriceList> findAll(){ return priceListRepository.findAll();}
}
