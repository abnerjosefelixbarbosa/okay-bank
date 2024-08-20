package com.org.back_end_java.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.back_end_java.domain.dto.RegisterCustomerDTO;
import com.org.back_end_java.infra.repository.IAccountRepository;
import com.org.back_end_java.infra.repository.IAgencyRepository;
import com.org.back_end_java.infra.repository.ICustomerRepository;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
public class CustomerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ICustomerRepository customerRepository;
	@Autowired
	private IAccountRepository accountRepository;
	@Autowired
	private IAgencyRepository agencyRepository;

	@BeforeEach
	public void setup() {
		accountRepository.deleteAll();
		customerRepository.deleteAll();
		agencyRepository.deleteAll();
	}

	@AfterEach
	public void tearDown() {
		accountRepository.deleteAll();
		customerRepository.deleteAll();
		agencyRepository.deleteAll();
	}

	@Test
	public void register() throws Exception {
		RegisterCustomerDTO dto = new RegisterCustomerDTO();
		
		String json = objectMapper.writeValueAsString(dto);
		
		mockMvc.perform(post("/customers/register")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(json))
		        .andExpect(MockMvcResultMatchers.status().isCreated())
				.andDo(print());
	}
}
