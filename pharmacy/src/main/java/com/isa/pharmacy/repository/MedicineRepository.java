package com.isa.pharmacy.repository;

import java.util.List;

import com.isa.pharmacy.domain.enums.FormOfMedicine;
import com.isa.pharmacy.domain.enums.MedicinePublishingType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.isa.pharmacy.domain.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    Medicine save(Medicine medicine);

    Medicine findMedicineById(Long id);

    Medicine findMedicineByName(String name);

    Medicine findMedicineByCode(Long code);

    List<Medicine> findAll();

    Page<Medicine> findAll(Pageable pageable);

    @Query(value = "select distinct m from Medicine m join MedicinePharmacy mp" +
            "       on mp.medicine.id = m.id" +
            "       where lower(m.name) like concat('%',lower(:name),'%')" +
            "       and ((:pharmacies) is null or mp.pharmacy.id in (:pharmacies)) " +
            "       and (:startPrice is null or mp.price >= :startPrice)" +
            "       and (:endPrice is null or mp.price <= :endPrice) " +
            "       and (:typeOfMedicine = '' or lower(m.typeOfMedicine) like concat('%',lower(:typeOfMedicine),'%'))" +
            "       and (:manufactured = '' or lower(m.manufactured) like concat('%',lower(:manufactured),'%'))" +
            "       and (:composition = '' or lower(m.composition) like concat('%',lower(:composition),'%'))" +
            "       and (:formOfMedicine is null or m.formOfMedicine = :formOfMedicine)" +
            "       and (:publishingType is null or m.publishingType = :publishingType) " +
            "")
    Page<Medicine> filterMedicine(@Param("name") String name, @Param("startPrice") Double startPrice,
                                  @Param("endPrice") Double endPrice, @Param("pharmacies") List<Long> pharmacies,
                                  @Param("typeOfMedicine") String typeOfMedicine, @Param("manufactured") String manufactured,
                                  @Param("composition") String composition, @Param("formOfMedicine") FormOfMedicine formOfMedicine,
                                  @Param("publishingType") MedicinePublishingType publishingType,
                                  Pageable pageable);
}
