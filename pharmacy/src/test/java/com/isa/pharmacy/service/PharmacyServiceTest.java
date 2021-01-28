package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.repository.PharmacyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@RunWith(SpringRunner.class)
public class PharmacyServiceTest {

	@InjectMocks
	private PharmacyService pharmacyService;

	@Mock
	private PharmacyRepository pharmacyRepository;

	@Before
	public void setUp() {
		openMocks(this);
	}

	@Test
	public void getAllTest() {
		when(pharmacyRepository.findAll()).thenReturn(emptyList());
		List<Pharmacy> all = pharmacyService.getAll();
		assertEquals(all.size(), 0);
	}

	@Test
	public void getByApyKeyTestSuccess() {
		String apiKey = "ApiKey";
		when(pharmacyRepository.findPharmacyByApiKey(apiKey)).thenReturn(new Pharmacy());
		Pharmacy pharmacy = pharmacyService.getByApiKey(apiKey);
		assertNotNull(pharmacy);
	}

}
