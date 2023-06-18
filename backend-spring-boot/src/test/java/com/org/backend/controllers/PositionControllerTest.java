package com.org.backend.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.backend.models.Position;

@SpringBootTest
@AutoConfigureMockMvc
public class PositionControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@Disabled
	public void save() throws Exception {
		var position = new Position();

		final var URL = "/positions/save";
		final var CONTENT_TYPE = "application/json";
		final var ACCEPT = "application/json";
		final var JSON = objectMapper.writeValueAsString(position);

		mockMvc.perform(post(URL).contentType(CONTENT_TYPE).accept(ACCEPT).content(JSON)).andDo(print())
				.andExpect(status().is(201));
	}
}
