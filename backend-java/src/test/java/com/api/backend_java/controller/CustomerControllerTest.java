package com.api.backend_java.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.api.backend_java.domain.dto.CustomerDTO;
import com.api.backend_java.domain.dto.LoginDTO;
import com.api.backend_java.infra.entity.Customer;
import com.api.backend_java.infra.repository.ICustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "dev")
class CustomerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMappe;
	@Autowired
	private ICustomerRepository customerRepository;

	@BeforeEach
	void setUp() {
		customerRepository.deleteAll();
	}

	@AfterEach
	void tearDown() {
		customerRepository.deleteAll();
	}

	@Test
	@DisplayName("should return status 201")
	void createCase1() throws Exception {
		CustomerDTO dto = new CustomerDTO(
				null,
				"name1",
				"email1@gmail.com",
				"11111111",
				"81911111111",
				"36896983086",
				"11111",
				LocalDate.of(1990, 11, 11),
				"11111",
				"1",
				"name1",
				"district1",
				"city1",
				"state1"
		);
		String json = objectMappe.writeValueAsString(dto);
		
		mockMvc.perform(
				post("/customers/create")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json)
		)
		.andExpect(status().isCreated())
		.andDo(print())
		.andReturn();
	}
	
	@Test
	@DisplayName("should return status 400 and return message cpf, rg, email, contact or password exists")
	void createCase2() throws Exception {
		loadCustomer();
		
		CustomerDTO dto = new CustomerDTO(
				null,
				"name1",
				"email1@gmail.com",
				"11111111",
				"81911111111",
				"36896983086",
				"11111",
				LocalDate.of(1990, 11, 11),
				"11111",
				"1",
				"name1",
				"district1",
				"city1",
				"state1"
		);
		String json = objectMappe.writeValueAsString(dto);
		
		mockMvc.perform(
				post("/customers/create")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json)
		)
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.message").value("cpf, rg, email, contact or password exists"))
		.andDo(print())
		.andReturn();
	}
	
	@Test
	@DisplayName("should return status 400 and return MethodArgumentNotValidException")
	void loginCase3() throws Exception {
		LoginDTO dto = new LoginDTO(
				null,
				null
		);
		String json = objectMappe.writeValueAsString(dto);
		
		MvcResult mvcResult = mockMvc.perform(
				post("/customers/login")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json)
		)
		.andExpect(status().isBadRequest())
		.andDo(print())
		.andReturn();
		
		Assertions.assertThrows(MethodArgumentNotValidException.class, mvcResult.);
		//MethodArgumentNotValidException
	
	}

	void loadCustomer() {
		Customer customer = new Customer(
				UUID.randomUUID().toString(),
				"name1",
				"email1@gmail.com",
				"11111111",
				"81911111111",
				"36896983086",
				"11111",
				LocalDate.of(1990, 11, 11),
				"11111",
				"1",
				"name1",
				"district1",
				"city1",
				"state1"
		);
		
		customerRepository.save(customer);
	}
}
