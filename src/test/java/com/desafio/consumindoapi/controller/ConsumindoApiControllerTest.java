package com.desafio.consumindoapi.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.desafio.consumindoapi.dto.PapelDTO;
import com.desafio.consumindoapi.exception.HandlerException;
import com.desafio.consumindoapi.service.ConsumindoApiService;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@RunWith(MockitoJUnitRunner.class)
public class ConsumindoApiControllerTest {
	
	@InjectMocks
	private ConsumindoApiController controller;
	
	@Mock
	private ConsumindoApiService service;
	
	private MockMvc mockMvc;
	
	@Before
	public void inicializar() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setControllerAdvice(new HandlerException()).build();
		FixtureFactoryLoader.loadTemplates("com.desafio.consumindoapi.fixture");
	}
	
	@Test
	public void deveBuscarPapeis() throws Exception {
		List<PapelDTO> papeis = Fixture.from(PapelDTO.class).gimme(3, "valido");
		final String nome = "teste";
		final String retorno = new ObjectMapper().writeValueAsString(papeis);
		
		when(service.getPapeis(nome)).thenReturn(papeis);
		 
		mockMvc.perform(get("/consultar-bolsa?nome="+nome)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(content().string(retorno));
		
	}
	
	

}
