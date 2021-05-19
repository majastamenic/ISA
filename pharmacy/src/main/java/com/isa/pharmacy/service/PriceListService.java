package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.CreatePriceListDto;
import com.isa.pharmacy.controller.dto.MedicinePharmacyDto;
import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.mapping.MedicinePharmacyMapper;
import com.isa.pharmacy.controller.mapping.PriceListMapper;
import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.PriceList;
import com.isa.pharmacy.repository.PriceListRepository;
import com.isa.pharmacy.service.interfaces.IMedicinePharmacyService;
import com.isa.pharmacy.service.interfaces.IPharmacyService;
import com.isa.pharmacy.service.interfaces.IPriceListService;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.users.repository.PharmacyAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceListService implements IPriceListService {

    @Autowired
    private PriceListRepository priceListRepository;
    @Autowired
    private PharmacyAdminRepository pharmacyAdminRepository;
    @Autowired
    private IPharmacyService pharmacyService;
    @Autowired
    private IMedicinePharmacyService medicinePharmacyService;

    public CreatePriceListDto save(CreatePriceListDto priceListDto){
        PriceList priceList = PriceListMapper.mapCreatePriceListDtoToPriceList(priceListDto);
        priceList.setMedicinePharmacy(medicinePharmacyService.getById(priceListDto.getMedicineId()));

        List<PriceList> priceLists = priceListRepository.findAll();
        for(PriceList priceList1:priceLists){
            if(priceList.getMedicinePharmacy().getId() == priceList1.getMedicinePharmacy().getId()){
                if(priceList.getDateFrom().after(priceList1.getDateFrom()) && priceList.getDateFrom().before(priceList1.getDateTo())||
                priceList.getDateTo().after(priceList1.getDateFrom())&& priceList.getDateTo().before(priceList1.getDateTo())){
                    throw new AlreadyExistsException("You already set price for this interval of time.");
                }
            }
        }
        priceListRepository.save(priceList);
        return PriceListMapper.mapPriceListToCreatePriceListDto(priceList);
    }

    public List<PriceList> findAll(){ return priceListRepository.findAll();}
}
