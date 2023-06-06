package com.org.backend.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.backend.models.Customer;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	//@Disabled
	public void save() throws Exception {
		Customer customer = new Customer();
		
		final String URL = "/customers/save";
		final String CONTENT_TYPE = "application/json";
		final String ACCEPT = "application/json";
		final String JSON = objectMapper.writeValueAsString(customer);	
		
		mockMvc.perform(post(URL).contentType(CONTENT_TYPE).accept(ACCEPT).content(JSON))
		       .andDo(print())
		       .andExpect(status().is(201));
	}
}
