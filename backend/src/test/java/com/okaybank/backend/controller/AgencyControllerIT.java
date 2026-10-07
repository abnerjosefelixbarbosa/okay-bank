package com.okaybank.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.okaybank.backend.dto.AgencyRequestDTO;
import com.okaybank.backend.model.Agency;
import com.okaybank.backend.repository.AgencyRepository;

import tools.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class AgencyControllerIT {
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

	// create agency

	@Test
	@DisplayName("Should create agency and return 201 status.")
	void createAgencyTest1() throws Exception {
		AgencyRequestDTO request = new AgencyRequestDTO("11111");

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/agencies/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isCreated()).andDo(print());
	}

	@Test
	@DisplayName("Should not create agency when number is repeated and return 400 status.")
	void createAgencyTest2() throws Exception {
		Agency agency = new Agency(null, "11111", LocalDate.now(), null, null);

		agencyRepository.save(agency);

		AgencyRequestDTO request = new AgencyRequestDTO("11111");

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/agencies/register").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isBadRequest()).andDo(print());
	}

	// updade agency

	@Test
	@DisplayName("Should update agency and return 200 status.")
	void updateAgencyTest3() throws Exception {
		Agency agency = new Agency(null, "11222", LocalDate.now(), null, null);

		String id = agencyRepository.save(agency).getId();

		AgencyRequestDTO request = new AgencyRequestDTO("11333");

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(put("/agencies/update/" + id).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	@DisplayName("Should not update agency when id not is existent and return 404 status.")
	void updateAgencyTest4() throws Exception {
		Agency agency = new Agency(null, "11222", LocalDate.now(), null, null);

		String id = agencyRepository.save(agency).getId();

		AgencyRequestDTO request = new AgencyRequestDTO("11333");

		String obj = objectMapper.writeValueAsString(request);

		mockMvc.perform(put("/agencies/update/" + id).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(obj)).andExpect(status().isOk()).andDo(print());
	}
}
