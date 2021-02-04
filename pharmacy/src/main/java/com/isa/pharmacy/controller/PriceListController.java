package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.CreatePriceListDto;
import com.isa.pharmacy.domain.PriceList;
import com.isa.pharmacy.service.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pricelist")
public class PriceListController {

    @Autowired
    private PriceListService priceListService;

    @PostMapping("/define")
    public PriceList save(@RequestBody CreatePriceListDto priceList){ return priceListService.save(priceList); }

    @GetMapping
    public List<PriceList> getAll() { return priceListService.findAll(); }
}
