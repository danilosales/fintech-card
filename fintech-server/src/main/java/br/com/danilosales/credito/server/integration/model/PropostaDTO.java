package br.com.danilosales.credito.server.integration.model;

import java.math.BigDecimal;

public class PropostaDTO {

	private BigDecimal renda;
	
	private Integer idade;
	
	private String estadoCivil;
	
	private Integer qtdDependentes = 0;

	public BigDecimal getRenda() {
		return renda;
	}

	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Integer getQtdDependentes() {
		return qtdDependentes;
	}

	public void setQtdDependentes(Integer qtdDependentes) {
		this.qtdDependentes = qtdDependentes;
	}
	
}
