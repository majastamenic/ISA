package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.PriceList;
import com.isa.pharmacy.repository.PriceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceListService {
    @Autowired
    private PriceListRepository priceListRepository;

    public PriceList save(PriceList priceList){ return priceListRepository.save(priceList);}

    public List<PriceList> findAll(){ return priceListRepository.findAll();}
}
