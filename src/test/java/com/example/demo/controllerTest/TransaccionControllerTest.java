package com.example.demo.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TransaccionControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnDefaultMessage2() throws Exception {
		this.mockMvc.perform(delete("/api/transacciones/{id}",2)).andDo(print()).andExpect(status().isOk());
	}
}
