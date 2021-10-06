package com.example.demo.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/api/users")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturnDefaultMessage2() throws Exception {
		this.mockMvc.perform(get("/api/users/{id}",1)).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
    public void shouldReturnDefaultMessage3() throws Exception {

        User randomObj = new User();
        randomObj.setId(1L);
        randomObj.setNombre("fsvs");
        randomObj.setApellido("ffff");
        randomObj.setCedula("6754534");
        randomObj.setEmail("adas");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(randomObj);


        this.mockMvc.perform(post("/api/users")
        	    .contentType(MediaType.APPLICATION_JSON)
        	    .content(json)
        	    .characterEncoding("utf-8"))
        	    .andExpect(status().isOk())
        	    .andReturn();

		}

}
