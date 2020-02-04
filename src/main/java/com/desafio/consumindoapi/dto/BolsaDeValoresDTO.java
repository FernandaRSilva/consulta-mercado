package com.desafio.consumindoapi.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BolsaDeValoresDTO {
	
	
	private List<PapelDTO> bestMatches;
}
