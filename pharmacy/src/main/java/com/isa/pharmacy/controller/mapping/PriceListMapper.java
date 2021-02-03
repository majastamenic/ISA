package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.CreatePriceListDto;
import com.isa.pharmacy.domain.PriceList;

public class PriceListMapper {
    public static PriceList mapCreatePriceListDtoToPriceList(CreatePriceListDto createPriceListDto){
        PriceList priceList = new PriceList();
        priceList.setId(createPriceListDto.getId());
        priceList.setDateFrom(createPriceListDto.getDateFrom());
        priceList.setDateTo(createPriceListDto.getDateTo());
        priceList.setMedicinePharmacy(createPriceListDto.getMedicinePharmacy());
        return priceList;
    }
}
