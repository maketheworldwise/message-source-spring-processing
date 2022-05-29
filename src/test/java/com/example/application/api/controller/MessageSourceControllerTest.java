package com.example.application.api.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(MessageSourceController.class)
class MessageSourceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Accept-Language: ko-kr, [GET] /say/hello")
	public void sayHelloInKo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/say/hello")
				.header(HttpHeaders.ACCEPT_LANGUAGE, "ko-kr")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string("안녕!"))
			.andDo(print());
	}

	@Test
	@DisplayName("Accept-Language: en-us, [GET] /say/hello")
	public void sayHelloInEn() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/say/hello")
				.header(HttpHeaders.ACCEPT_LANGUAGE, "en-us")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string("hi!"))
			.andDo(print());
	}

}