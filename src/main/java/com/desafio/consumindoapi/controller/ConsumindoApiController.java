package com.desafio.consumindoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.consumindoapi.dto.PapelDTO;
import com.desafio.consumindoapi.service.ConsumindoApiService;

@RestController
@RequestMapping(value = "consultar-bolsa")
public class ConsumindoApiController {
	
	@Autowired
	private ConsumindoApiService consumindoApiService;
	
	@GetMapping
	public ResponseEntity<List<PapelDTO>> getPapeis(@RequestParam String nome) {
		return ResponseEntity.ok(consumindoApiService.getPapeis(nome));
	}
	
	
}
