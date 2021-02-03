package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.PriceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceListRepository extends JpaRepository<PriceList, Long> {

    PriceList save(PriceList priceList);

    List<PriceList> findAll();
}
