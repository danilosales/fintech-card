package br.com.danilosales.credito.server.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danilosales.credito.server.integration.AnaliseDeCreditoEngine;
import br.com.danilosales.credito.server.integration.model.PropostaDTO;
import br.com.danilosales.credito.server.integration.model.ResultadoAnalise;
import br.com.danilosales.credito.server.model.Proposta;
import br.com.danilosales.credito.server.model.Status;
import br.com.danilosales.credito.server.repository.PropostaRepository;
import br.com.danilosales.credito.server.service.exception.PropostaJaExiste;

@Service
public class PropostaService {

	Logger logger = LoggerFactory.getLogger(PropostaService.class);
	
	@Autowired
	private PropostaRepository propostaRepository;
	
	@Autowired
	private AnaliseDeCreditoEngine analiseDeCreditoEngine;
	
	@Transactional
	public void salvar(Proposta proposta) {
		
		Optional<Proposta> propostaExiste = propostaRepository.findByCpf(proposta.getCpf());
		
		if(propostaExiste.isPresent() && !proposta.isNova()) {
			throw new PropostaJaExiste("Já existe uma proposta com este CPF no sistema");
		}
		
		try {
			
			ResultadoAnalise resultadoAnalise = analiseDeCreditoEngine.realizarAnaliseDeCredito(montarPropostaDTO(proposta));
			
			proposta.setStatus(Status.getByCodigo(resultadoAnalise.getStatus().toLowerCase()));
			proposta.setObservacao(resultadoAnalise.getObservacao());
			
		} catch (Exception e) {
			logger.error("Ocorreu um erro ao analisar proposta, verifique os serviços", e);
			e.printStackTrace();
			//TODO Configurar um alerta para a equipe de suporte
			
		}
		
		propostaRepository.save(proposta);
		
	}

	private PropostaDTO montarPropostaDTO(Proposta proposta) {
		PropostaDTO propostaDTO = new PropostaDTO();
		propostaDTO.setEstadoCivil(proposta.getEstadoCivil().getCodigo());
		propostaDTO.setIdade(proposta.getIdade());
		propostaDTO.setQtdDependentes(proposta.getQtdDependentes());
		propostaDTO.setRenda(proposta.getRenda());
		return propostaDTO;
	}
	
}
