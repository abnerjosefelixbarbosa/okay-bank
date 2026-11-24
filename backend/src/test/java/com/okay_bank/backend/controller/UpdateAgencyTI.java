package com.okay_bank.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

import com.okay_bank.backend.infra.dto.request.AgencyRequestDTO;
import com.okay_bank.backend.infra.entity.AgencyEntity;
import com.okay_bank.backend.infra.repository.AgencyRepository;

import tools.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class UpdateAgencyTI {
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
	@DisplayName("Should update agency and return status 200.")
	void updateAgencyTest1() throws Exception {
		AgencyEntity agency1 = new AgencyEntity(
				null, 
				"11111", 
				LocalDate.now(), 
				null, 
				null
		);
		
		String id = agencyRepository.save(agency1).getId();
		
		AgencyRequestDTO request = new AgencyRequestDTO("22222");
		
		String obj = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(
				put("/agencies/" + id)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(obj)
		)
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	@DisplayName("Should not update agency when number is null and return status 400.")
	void updateAgencyTest2() throws Exception {
		AgencyEntity agency1 = new AgencyEntity(
				null, 
				"11111", 
				LocalDate.now(), 
				null, 
				null
		);
		
		String id = agencyRepository.save(agency1).getId();
		
		AgencyRequestDTO request = new AgencyRequestDTO(null);
		
		String obj = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(
				put("/agencies/" + id)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(obj)
		)
		.andExpect(status().isBadRequest())
		.andDo(print());
	}
	
	@Test
	@DisplayName("Should not update agency when number is empty and return status 400.")
	void updateAgencyTest3() throws Exception {
		AgencyEntity agency1 = new AgencyEntity(
				null, 
				"11111", 
				LocalDate.now(), 
				null, 
				null
		);
		
		String id = agencyRepository.save(agency1).getId();
		
		AgencyRequestDTO request = new AgencyRequestDTO("");
		
		String obj = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(
				put("/agencies/" + id)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(obj)
		)
		.andExpect(status().isBadRequest())
		.andDo(print());
	}
	
	@Test
	@DisplayName("Should not update agency when number not has 5 characters and return status 400.")
	void updateAgencyTest4() throws Exception {
		AgencyEntity agency1 = new AgencyEntity(
				null, 
				"11111", 
				LocalDate.now(), 
				null, 
				null
		);
		
		String id = agencyRepository.save(agency1).getId();
		
		AgencyRequestDTO request = new AgencyRequestDTO("1");
		
		String obj = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(
				put("/agencies/" + id)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(obj)
		)
		.andExpect(status().isBadRequest())
		.andDo(print());
	}
	
	@Test
	@DisplayName("Should not update agency when number not has numeric characters and return status 400.")
	void updateAgencyTest5() throws Exception {
		AgencyEntity agency1 = new AgencyEntity(
				null, 
				"11111", 
				LocalDate.now(), 
				null, 
				null
		);
		
		String id = agencyRepository.save(agency1).getId();
		
		AgencyRequestDTO request = new AgencyRequestDTO("1111a");
		
		String obj = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(
				put("/agencies/" + id)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(obj)
		)
		.andExpect(status().isBadRequest())
		.andDo(print());
	}
	
	@Test
	@DisplayName("Should not update agency when number is repeated and return status 400.")
	void updateAgencyTest6() throws Exception {
		AgencyEntity agency1 = new AgencyEntity(
				null, 
				"11111", 
				LocalDate.now(), 
				null, 
				null
		); 
		
		String id = agencyRepository.save(agency1).getId();
		
		AgencyRequestDTO request = new AgencyRequestDTO("11111");
		
		String obj = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(
				put("/agencies/" + id)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(obj)
		)
		.andExpect(status().isBadRequest())
		.andDo(print());
	}
	
	@Test
	@DisplayName("Should not update agency when id not is existent and return status 404.")
	void updateAgencyTest7() throws Exception {
		AgencyEntity agency1 = new AgencyEntity(
				null, 
				"11111", 
				LocalDate.now(), 
				null, 
				null
		); 
		
		String id = agencyRepository.save(agency1).getId();
		
		AgencyRequestDTO request = new AgencyRequestDTO("22222");
		
		String obj = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(
				put("/agencies/1" + id)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(obj)
		)
		.andExpect(status().isNotFound())
		.andDo(print());
	}
}
