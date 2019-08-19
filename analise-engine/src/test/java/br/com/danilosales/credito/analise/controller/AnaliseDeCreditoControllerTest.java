package br.com.danilosales.credito.analise.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AnaliseDeCreditoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void deveSerAprovadoEntre100e500() throws Exception {
		
		final StringBuilder json = new StringBuilder("{")
				.append("\"renda\": 1000,")
				.append("\"idade\": 17,")
				.append("\"estadoCivil\": \"solteiro\",")
				.append("\"qtdDependentes\": 0")
				.append("}");
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/engine-analise-credito")
				.content(json.toString())
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Aprovado"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.observacao").value("Entre 100 a 500"))
				.andReturn();
		
		
	}
	
	@Test
	public void deveSerAprovadoEntre1000e1500() throws Exception {
		
		final StringBuilder json = new StringBuilder("{")
				.append("\"renda\": 5000,")
				.append("\"idade\": 58,")
				.append("\"estadoCivil\": \"casado\",")
				.append("\"qtdDependentes\": 3")
				.append("}");
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/engine-analise-credito")
				.content(json.toString())
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Aprovado"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.observacao").value("Entre 1000 a 1500"))
				.andReturn();
		
		
	}
	
	@Test
	public void deveSerReprovado() throws Exception {
		
		final StringBuilder json = new StringBuilder("{")
				.append("\"renda\": 2000,")
				.append("\"idade\": 58,")
				.append("\"estadoCivil\": \"casado\",")
				.append("\"qtdDependentes\": 3")
				.append("}");
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/engine-analise-credito")
				.content(json.toString())
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Reprovado"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.observacao").value("Reprovado pela poítica de crédito"))
				.andReturn();
		
		
	}

}
