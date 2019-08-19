package br.com.danilosales.credito.server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danilosales.credito.server.model.Proposta;

public interface PropostaRepository extends JpaRepository<Proposta, Long>{

	public Optional<Proposta> findByCpf(String cpf);
	
}
