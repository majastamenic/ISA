package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.repository.MedicineRepository;
import com.isa.pharmacy.service.interfaces.IMedicineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(SpringExtension.class)
public class MedicineServiceTest {

    @InjectMocks
    private MedicineService medicineService;

    @Mock
    private MedicineRepository medicineRepository;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    public void getByNameTestSuccess() {
        Medicine medicine = new Medicine();
        medicine.setName("Brufen");
        when(medicineRepository.findMedicineByName(medicine.getName())).thenReturn(new Medicine());
        assertNotNull(medicine);
    }
}
