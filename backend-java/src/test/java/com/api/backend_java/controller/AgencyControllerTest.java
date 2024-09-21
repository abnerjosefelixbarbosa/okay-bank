package com.api.backend_java.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import com.api.backend_java.domain.dto.CreateAgencyDTO;
import com.github.f4b6a3.ulid.UlidCreator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.api.backend_java.domain.dto.AgencyDTO;
import com.api.backend_java.infra.entity.Agency;
import com.api.backend_java.infra.repository.IAgencyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "dev")
class AgencyControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMappe;
	@Autowired
	private IAgencyRepository agencyRepository;

	@BeforeEach
	void setup() {
		agencyRepository.deleteAll();
	}

	@AfterEach
	void tearDown() {
		agencyRepository.deleteAll();
	}

	@Test
	@DisplayName("should return 201")
	void createCase1() throws Exception {
		CreateAgencyDTO dto = new CreateAgencyDTO();
		dto.setNumber("11111");
		String json = objectMappe.writeValueAsString(dto);
		
		mockMvc.perform(
				post("/agencies/create")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json)
		)
		.andExpect(status().isCreated())
		.andDo(print())
		.andReturn();
	}
	
	@Test
	@DisplayName("should return 400 and number should not be exists message")
	void createCase2() throws Exception {
		loadAgency();
		
		AgencyDTO dto = new AgencyDTO();
		dto.setNumber("11111");
		String json = objectMappe.writeValueAsString(dto);
		
		mockMvc.perform(
				post("/agencies/create")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.message").value("number should not be exists"))
		.andDo(print())
		.andReturn();
	}

	@Test
	@DisplayName("should return 400 and data invalid message")
	void createCase3() throws Exception {
		AgencyDTO dto = new AgencyDTO();
		dto.setNumber("11111");
		String json = objectMappe.writeValueAsString(dto);

		mockMvc.perform(
						post("/agencies/create")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
								.content(json))
				.andExpect(status().isBadRequest())
				.andDo(print())
				.andReturn();
	}
	
	void loadAgency() {
		Agency agency = new Agency();
		agency.setId(UlidCreator.getUlid().toString());
		agency.setNumber("11111");
		
		agencyRepository.save(agency);
	}
}
