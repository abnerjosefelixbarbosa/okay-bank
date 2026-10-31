package com.okaybank.backend.controller.agency;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

import com.okaybank.backend.dto.request.AgencyRequestDTO;
import com.okaybank.backend.model.Agency;
import com.okaybank.backend.repository.AgencyRepository;

import tools.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class RegisterAgencyIT {
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
	@DisplayName("Should register agency and return 201 status.")
	void registerAgencyTest1() throws Exception {
		AgencyRequestDTO request = new AgencyRequestDTO("11111");
		
		String object = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(post("/agencies").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(object))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.number").value("11111"))
		.andDo(print());
	}
	
	@Test
	@DisplayName("Should not register agency when number is null and return 400 status.")
	void registerAgencyTest2() throws Exception {
		AgencyRequestDTO request = new AgencyRequestDTO(null);
		
		String object = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(post("/agencies").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(object))
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.number").value("Numero deve ser obrigatório."))
		.andDo(print());
	}
	
	@Test
	@DisplayName("Should not register agency when number not has 5 characters and return 400 status.")
	void registerAgencyTest3() throws Exception {
		AgencyRequestDTO request = new AgencyRequestDTO("1111");
		
		String object = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(post("/agencies").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(object))
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.number").value("Numero deve ter 5 caracteres numéricos."))
		.andDo(print());
	}
	
	@Test
	@DisplayName("Should not register agency when number is repeated and return 400 status.")
	void registerAgencyTest4() throws Exception {
		Agency agency = new Agency(null, "11111", LocalDate.now(), null, null); 
		
		agencyRepository.save(agency);
		
		AgencyRequestDTO request = new AgencyRequestDTO("11111");
		
		String object = objectMapper.writeValueAsString(request);
		
		mockMvc.perform(post("/agencies").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(object))
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.message").value("Numero não deve ser repetido."))
		.andDo(print());
	}
}
