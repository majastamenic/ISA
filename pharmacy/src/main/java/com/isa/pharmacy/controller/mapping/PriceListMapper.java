package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.CreatePriceListDto;
import com.isa.pharmacy.domain.PriceList;

public class PriceListMapper {

    public static PriceList mapCreatePriceListDtoToPriceList(CreatePriceListDto createPriceListDto){
        PriceList priceList = new PriceList();
        priceList.setId(createPriceListDto.getId());
        priceList.setDateFrom(createPriceListDto.getDateFrom());
        priceList.setDateTo(createPriceListDto.getDateTo());
        return priceList;
    }

    public  static CreatePriceListDto mapPriceListToCreatePriceListDto(PriceList priceList){
        CreatePriceListDto createPriceListDto = new CreatePriceListDto();
        createPriceListDto.setId(priceList.getId());
        createPriceListDto.setDateFrom(priceList.getDateFrom());
        createPriceListDto.setDateTo(priceList.getDateTo());
        return  createPriceListDto;
    }

}
