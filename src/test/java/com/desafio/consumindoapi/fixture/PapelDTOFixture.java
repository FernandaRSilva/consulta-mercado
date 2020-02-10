package com.desafio.consumindoapi.fixture;

import com.desafio.consumindoapi.dto.PapelDTO;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class PapelDTOFixture implements TemplateLoader{
	@Override
	public void load() {
		Fixture.of(PapelDTO.class).addTemplate("valido", new Rule() {
			{
				add("symbol", "TST");
				add("name", "teste");
			}
		});
	}
}
