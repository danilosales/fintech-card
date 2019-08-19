package br.com.danilosales.credito.server.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.danilosales.credito.server.integration.model.PropostaDTO;
import br.com.danilosales.credito.server.integration.model.ResultadoAnalise;

@FeignClient(name = "AnaliseCreditoIntegration", url = "analise-engine:9080/api/engine-analise-credito")
public interface AnaliseDeCreditoEngine {

	@PostMapping
	public ResultadoAnalise realizarAnaliseDeCredito(PropostaDTO proposta);
	
}
