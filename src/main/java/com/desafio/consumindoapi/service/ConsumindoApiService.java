package com.desafio.consumindoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafio.consumindoapi.dto.BolsaDeValoresDTO;
import com.desafio.consumindoapi.dto.PapelDTO;

@Service
public class ConsumindoApiService {
	
	@Autowired
	private RestTemplate resttemplate;

	

	public List<PapelDTO> getPapeis(String nome) {
		String uri = "https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords="+nome+"&apikey=ZR1V1Q8XNTEKETK0";
		ResponseEntity<BolsaDeValoresDTO> entity = resttemplate.getForEntity(uri, BolsaDeValoresDTO.class);
		return entity.getBody().getBestMatches();
	}
		

}
