package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class EmployeesControllerTest {
	private MockMvc mockMvc;
	
	@Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new EmployeesController()).build();
    }

	@Test
	public void getMaleEmployees() throws Exception{
		this.mockMvc.perform(get("/employees?gender=male")).andExpect(status().isOk());
	}
	
	@Test
	public void postEmployee1() throws Exception{
		this.mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).
				content("{\"name\": \"Ardi\",\"gender\": \"Male\"}")).andExpect(status().isOk());
	}
	
	@Test
	public void postEmployee3() throws Exception{
		this.mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).
				content("{\"name\": \"Ardi\",\"gender\": \"Male\"}")).andExpect(content().
						json("{\"name\": \"Ardi\",\"gender\": \"Male\"}"));
		
	}

}
