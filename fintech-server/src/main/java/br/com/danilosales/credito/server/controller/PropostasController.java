package br.com.danilosales.credito.server.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.danilosales.credito.server.model.Proposta;
import br.com.danilosales.credito.server.repository.PropostaRepository;
import br.com.danilosales.credito.server.service.PropostaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API backend para cadastro de propostas")
@RestController
@RequestMapping(value = "/api/propostas")
@CrossOrigin(origins = "*")
public class PropostasController {

	@Autowired
	private PropostaService propostaService;
	
	@Autowired
	private PropostaRepository propostaRepository;
	
	@ApiOperation(value = "Cadastra uma proposta")
	@PostMapping
	public ResponseEntity<Proposta> inserirProposta(@Valid @RequestBody Proposta proposta) {
		
		propostaService.salvar(proposta);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{codigo}")
				.buildAndExpand(proposta.getId()).toUri();
		
		return ResponseEntity.created(location).body(proposta);
		
	}
	
	@ApiOperation(value = "Atualizar os dados de uma proposta")
	@PutMapping("/{codigo}")
	public ResponseEntity<Proposta> atualizarProposta(@PathVariable("codigo") Long codigo,
			@Valid @RequestBody Proposta proposta) {
		
		proposta.setId(codigo);
		propostaService.salvar(proposta);
		
		return ResponseEntity.ok().build();
		
	}
	
	
	@ApiOperation(value = "Buscar uma proposta por id")
	@GetMapping("/{codigo}")
	public ResponseEntity<Proposta> buscarPorCodigo(@PathVariable("codigo") String codigo) {
		Optional<Proposta> proposta = propostaRepository.findById(Long.parseLong(codigo));
		
		return proposta.isPresent() ? 
				ResponseEntity.ok(proposta.get()) : ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Buscar proposta por cpf do cliente")
	@GetMapping("/cliente/{cpf}")
	public ResponseEntity<Proposta> buscarPropostaPorCpf(@PathVariable("cpf") String cpf) {
		Optional<Proposta> proposta = propostaRepository.findByCpf(cpf);
		
		return proposta.isPresent() ? 
				ResponseEntity.ok(proposta.get()) : ResponseEntity.noContent().build();
	}
	
}
