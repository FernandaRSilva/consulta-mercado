package com.desafio.consumindoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.desafio.consumindoapi.dto.BolsaDeValoresDTO;
import com.desafio.consumindoapi.dto.PapelDTO;
import com.desafio.consumindoapi.exception.ConsumingErrorException;

@Service
public class ConsumindoApiService {
	private static final String URI = "https://www.alphavantage.co/query";
	
	@Autowired
	private RestTemplate resttemplate;

	

	public List<PapelDTO> getPapeis(String nome) throws ConsumingErrorException {
		try {
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(URI)
					.queryParam("function", "SYMBOL_SEARCH").queryParam("keywords", nome).queryParam("apikey", "ZR1V1Q8XNTEKETK0");
			ResponseEntity<BolsaDeValoresDTO> entity = resttemplate.getForEntity(uriBuilder.toUriString(), BolsaDeValoresDTO.class);
			return entity.getBody().getBestMatches();
			
		} catch (Exception e) {
			throw new ConsumingErrorException("Erro ao consumir a API externa.");
		}
	}
		

}
