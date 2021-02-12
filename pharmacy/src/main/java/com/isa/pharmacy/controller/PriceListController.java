package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.CreatePriceListDto;
import com.isa.pharmacy.domain.PriceList;
import com.isa.pharmacy.service.interfaces.IPriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
@RequestMapping("/pricelist")
public class PriceListController {

    @Autowired
    private IPriceListService priceListService;

    @PostMapping("/define")
    public CreatePriceListDto save(@RequestBody CreatePriceListDto priceList){ return priceListService.save(priceList); }

    @GetMapping
    public List<PriceList> getAll() { return priceListService.findAll(); }
}
