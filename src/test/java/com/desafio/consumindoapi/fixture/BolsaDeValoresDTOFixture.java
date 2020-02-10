package com.desafio.consumindoapi.fixture;

import com.desafio.consumindoapi.dto.BolsaDeValoresDTO;
import com.desafio.consumindoapi.dto.PapelDTO;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class BolsaDeValoresDTOFixture implements TemplateLoader{
	@Override
	public void load() {
		Fixture.of(BolsaDeValoresDTO.class).addTemplate("valido", new Rule() {
			{
				add("bestMatches", has(3).of(PapelDTO.class, "valido"));
			}
		});
	}
}
