package com.booking.Controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.booking.model.Flight;

public class FlightControllerTests extends AbstractTest {
	/*
	 * @Override
	 * 
	 * @BeforeAll public void setUp() { super.setUp(); }
	 * 
	 * @Test public void getAllFlights() throws Exception { String uri =
	 * "/get-all-flights"; MvcResult mvcResult =
	 * mvc.perform(MockMvcRequestBuilders.get(uri)
	 * .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	 * 
	 * int status = mvcResult.getResponse().getStatus(); assertEquals(200, status);
	 * String content = mvcResult.getResponse().getContentAsString(); Flight[]
	 * flight = super.mapFromJson(content, Flight[].class); assertTrue(flight.length
	 * > 0); }
	 */
}