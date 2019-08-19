package br.com.danilosales.credito.analise.engine.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danilosales.credito.analise.engine.model.Proposta;
import br.com.danilosales.credito.analise.engine.model.ResultadoAnalise;
import br.com.danilosales.credito.analise.engine.service.AnaliseDeCreditoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Analise de crédito")
@RestController
@RequestMapping(value = "/api/engine-analise-credito")
public class AnaliseDeCreditoController {

	@Autowired
	private AnaliseDeCreditoService service;
	
	@ApiOperation(value = "Realiza a analise da proposta")
	@PostMapping
	public ResultadoAnalise analisarProposta(@Valid @RequestBody Proposta proposta) {
		
		return this.service.analisarProposta(proposta);
	}

	
	
}
