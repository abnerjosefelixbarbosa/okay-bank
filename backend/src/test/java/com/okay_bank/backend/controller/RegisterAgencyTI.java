package com.okay_bank.backend.controller;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.okay_bank.backend.infra.dto.request.AgencyRequestDTO;
import com.okay_bank.backend.infra.entity.AgencyEntity;
import com.okay_bank.backend.infra.repository.AgencyRepository;

import tools.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class RegisterAgencyTI {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
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
	@DisplayName("Should register agency and return status 201.")
	void registerAgencyTest1() throws Exception {
		AgencyRequestDTO request = new AgencyRequestDTO("11111");
		
		String obj = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(
				MockMvcRequestBuilders.post("/agencies")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(obj)
		)
		.andExpect(MockMvcResultMatchers.status().isCreated())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	@DisplayName("Should not register agency when number is null and return status 400.")
	void registerAgencyTest2() throws Exception {
		AgencyRequestDTO request = new AgencyRequestDTO(null);
		
		String obj = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(
				MockMvcRequestBuilders.post("/agencies")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(obj)
		)
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	@DisplayName("Should not register agency when number is empty and return status 400.")
	void registerAgencyTest3() throws Exception {
		AgencyRequestDTO request = new AgencyRequestDTO(null);
		
		String obj = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(
				MockMvcRequestBuilders.post("/agencies")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(obj)
		)
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	@DisplayName("Should not register agency when number not has 5 characters and return status 400.")
	void registerAgencyTest4() throws Exception {
		AgencyRequestDTO request = new AgencyRequestDTO("1");
		
		String obj = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(
				MockMvcRequestBuilders.post("/agencies")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(obj)
		)
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	@DisplayName("Should not register agency when number not has numeric characters and return status 400.")
	void registerAgencyTest5() throws Exception {
		AgencyRequestDTO request = new AgencyRequestDTO("1111a");
		
		String obj = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(
				MockMvcRequestBuilders.post("/agencies")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(obj)
		)
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	@DisplayName("Should not register agency when number is repeated and return status 400.")
	void registerAgencyTest6() throws Exception {
		AgencyEntity agencyEntity1 = new AgencyEntity(
				null, 
				"11111", 
				LocalDate.now(), 
				null, 
				null
		); 
		
		agencyRepository.save(agencyEntity1);
		
		AgencyRequestDTO request = new AgencyRequestDTO("11111");
		
		String obj = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(
				MockMvcRequestBuilders.post("/agencies")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(obj)
		)
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andDo(MockMvcResultHandlers.print());
	}
}
