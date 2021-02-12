package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.GetAllPharmaciesDto;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.repository.PharmacyRepository;
import com.isa.pharmacy.service.interfaces.IPharmacyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(SpringExtension.class)
public class PharmacyServiceTest {

	@InjectMocks
	private PharmacyService pharmacyService;

	@Mock
	private PharmacyRepository pharmacyRepository;

	@BeforeEach
	public void setUp() {
		openMocks(this);
	}

	@Test
	public void getAllTest() {
		when(pharmacyRepository.findAll()).thenReturn(emptyList());
		List<GetAllPharmaciesDto> all = pharmacyService.getAll();
		assertEquals(all.size(), 0);
		System.out.println("test");
	}

	@Test
	public void getByNameTestSuccess() {
		Pharmacy pharmacy = new Pharmacy();
		pharmacy.setName("Jankovic");
		when(pharmacyRepository.findPharmacyByName(pharmacy.getName())).thenReturn(new Pharmacy());
		assertNotNull(pharmacy);
	}
}
