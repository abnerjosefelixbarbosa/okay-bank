package com.api.backend_java.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.api.backend_java.domain.dto.AccountDTO;
import com.api.backend_java.domain.entity.AccountType;
import com.api.backend_java.infra.entity.Address;
import com.api.backend_java.infra.entity.Agency;
import com.api.backend_java.infra.entity.Customer;
import com.api.backend_java.infra.repository.IAccountRepository;
import com.api.backend_java.infra.repository.IAgencyRepository;
import com.api.backend_java.infra.repository.ICustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMappe;
	@Autowired
	private IAgencyRepository agencyRepository;
	@Autowired
	private ICustomerRepository customerRepository;
	@Autowired
	private IAccountRepository accountRepository;

	@BeforeEach
	void setup() {
		accountRepository.deleteAll();
		agencyRepository.deleteAll();
		customerRepository.deleteAll();
	}

	@AfterEach
	void tearDown() {
		accountRepository.deleteAll();
		agencyRepository.deleteAll();
		customerRepository.deleteAll();
	}

	@Test
	void shouldCreateAndReturn201Status() throws Exception {
		loadAgency();
		//loadCustomer();
		AccountDTO dto = new AccountDTO(
				"11111",
				"111111",
				AccountType.SAVINGS,
				"1111",
				"84294415495",
				"11111",
				"name1",
				"email1@gmail.com",
				"81911111111",
				"11111111",
				LocalDate.of(1990, 11, 1),
				"11111",
				"1",
				"name1",
				"distric1",
				"state1",
				"city1"
		);
		String json = objectMappe.writeValueAsString(dto);
		mockMvc.perform(post("/accounts/create").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated()).andDo(print());
	}

	void loadAgency() {
		Agency agency = new Agency(
				UUID.randomUUID().toString(),
				"1111"
		);
		agencyRepository.save(agency);
	}
	
	void loadCustomer() {
		Address address = new Address(
				"11111",
				"1",
				"name1",
				"distric1",
				"state1",
				"city1"
		);
		Customer customer = new Customer(
				UUID.randomUUID().toString(),
				"84294415495",
				"11111",
				"name1",
				"email1@gmail.com",
				"81911111111",
				"11111111",
				LocalDate.of(1990, 11, 1),
				address
		);
		customerRepository.save(customer);
	}
}