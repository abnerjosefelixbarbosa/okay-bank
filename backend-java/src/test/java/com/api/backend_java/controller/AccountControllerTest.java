package com.api.backend_java.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.infra.entity.Agency;
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
		AgencyDTO dto = new AgencyDTO("11111");
		String json = objectMappe.writeValueAsString(dto);
		mockMvc.perform(post("/agencies/create").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated()).andDo(print());
	}
	
	void load() {
		Agency agency = new Agency(UUID.randomUUID().toString(), "11111");
		agencyRepository.save(agency);
	}
}