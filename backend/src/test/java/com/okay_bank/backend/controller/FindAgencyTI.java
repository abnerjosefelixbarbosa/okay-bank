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
class FindAgencyTI {
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
	@DisplayName("Should find agency by id and return status 200.")
	void findAgencyByIdTest1() throws Exception {
		AgencyEntity agency1 = new AgencyEntity(
				null, 
				"11111", 
				LocalDate.now(), 
				null, 
				null
		);
		
		String id = agencyRepository.save(agency1).getId();
		
		mockMvc.perform(
				get("/agencies/" + id)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
		)
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	@DisplayName("Should not find agency by id when id not is existent and return status 404.")
	void findAgencyByIdTest2() throws Exception {
		AgencyEntity agency1 = new AgencyEntity(
				null, 
				"11111", 
				LocalDate.now(), 
				null, 
				null
		);
		
		String id = agencyRepository.save(agency1).getId();
		
		mockMvc.perform(
				get("/agencies/1" + id)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
		)
		.andExpect(status().isNotFound())
		.andDo(print());
	}
}
