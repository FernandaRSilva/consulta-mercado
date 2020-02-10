package com.desafio.consumindoapi.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.desafio.consumindoapi.dto.BolsaDeValoresDTO;
import com.desafio.consumindoapi.dto.PapelDTO;
import com.desafio.consumindoapi.exception.ConsumingErrorException;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@RunWith(MockitoJUnitRunner.class)
public class ConsumindoApiServiceTest {
	
	@InjectMocks
	private ConsumindoApiService service;
	
	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	private UriComponentsBuilder uri;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@BeforeClass
	public static void inicializar() {
		FixtureFactoryLoader.loadTemplates("com.desafio.consumindoapi.fixture");
	}
	
	@Test
	public void getPapeisOK() throws ConsumingErrorException {
		BolsaDeValoresDTO bolsaDeValores = Fixture.from(BolsaDeValoresDTO.class).gimme("valido");
		final String nome = "teste";

		ResponseEntity<BolsaDeValoresDTO> responseEntity = new ResponseEntity<>(bolsaDeValores, HttpStatus.OK);
		
		when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(BolsaDeValoresDTO.class))).thenReturn(responseEntity);
	
		List<PapelDTO> resultado = service.getPapeis(nome);
		
		Assert.assertNotNull(resultado);
		
	 
	}
	
	
	
	@Test
	public void getPapeisConsumingException() throws ConsumingErrorException {
		 final String ErrorMessage = "Erro ao consumir a API externa.";
		 ResponseEntity<BolsaDeValoresDTO> responseEntity = new ResponseEntity<BolsaDeValoresDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		 
		 expectedException.expect(ConsumingErrorException.class);
		 expectedException.expectMessage(ErrorMessage);
	
		 
		 when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class),
					eq(BolsaDeValoresDTO.class))).thenReturn(responseEntity);
		 
		 this.service.getPapeis(null);
	}

}
