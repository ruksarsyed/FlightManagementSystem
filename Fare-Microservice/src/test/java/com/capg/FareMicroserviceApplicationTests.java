package com.capg;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.model.Fare;
import com.capg.repository.FareRepo;
import com.capg.service.FareService;

@SpringBootTest
class FareMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	/*@MockBean
	private FareRepo fareRepository;
	
	@Autowired
	private FareService fareService;*/
	
	/*Fare f1=new Fare(12, "BF101", "28-AUG-22", "Rs.6500");
	Fare f2=new Fare(14, "BF103", "18-AUG-22", "Rs.7900");
	
	@Test
	void TestAddLocation() {
		Mockito.when(fareRepository.save(f1)).thenReturn(f1);
		assertEquals(f1, fareService.addFare(f1));
	}
	
	@Test
	void TestgetAllCheckInModel() {
		Mockito.when(fareRepository.findAll())
				.thenReturn(Stream.of(
						new Fare(12, "BF101", "28-AUG-22", "Rs.6500"),
						new Fare(14, "BF103", "18-AUG-22", "Rs.7900"))
						.collect(Collectors.toList()));
		assertEquals(2, fareService.getFare().size());
	}*/
}
