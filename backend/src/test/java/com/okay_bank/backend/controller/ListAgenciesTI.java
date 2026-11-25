package com.okay_bank.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.okay_bank.backend.infra.entity.AgencyEntity;
import com.okay_bank.backend.infra.repository.AgencyRepository;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class ListAgenciesTI {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private AgencyRepository agencyRepository;

	@BeforeEach
	void setUp() throws Exception {
		agencyRepository.deleteAll();
	}

	@AfterEach
	void tearDown() throws Exception {
		agencyRepository.deleteAll();
	}

	@Test
	@DisplayName("Should list agencies and return status 200.")
	void listAgenciesTest1() throws Exception {
		AgencyEntity agency1 = new AgencyEntity(
				null,
				"11111",
				LocalDate.now(),
				null,
				null
		);
		
		AgencyEntity agency2 = new AgencyEntity(
				null,
				"22222",
				LocalDate.now(),
				null,
				null
		);
		
		agencyRepository.save(agency1);
		
		agencyRepository.save(agency2);
		
		mockMvc.perform(
				get("/agencies")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
		)
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	@DisplayName("Should list agencies when number is '11111' and return status 200.")
	void listAgenciesTest2() throws Exception {
		AgencyEntity agency1 = new AgencyEntity(
				null,
				"11111",
				LocalDate.now(),
				null,
				null
		);
		
		AgencyEntity agency2 = new AgencyEntity(
				null,
				"22222",
				LocalDate.now(),
				null,
				null
		);
		
		String number = agencyRepository.save(agency1).getNumber();
		
		agencyRepository.save(agency2);
		
		mockMvc.perform(
				get("/agencies")
				.queryParam("number", number)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
		)
		.andExpect(status().isOk())
		.andDo(print());
	}
}
