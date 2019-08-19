package br.com.danilosales.credito.analise.engine.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class Proposta {

	@NotNull(message = "Informe o valor da renda")
	private BigDecimal renda;
	
	@NotNull(message = "Informe a idade")
	private Integer idade;
	
	@NotNull(message = "Informe um estado civil válido")
	private EstadoCivil estadoCivil;
	
	@NotNull(message = "Informe a quantidade de dependentes")
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

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Integer getQtdDependentes() {
		return qtdDependentes;
	}

	public void setQtdDependentes(Integer qtdDependentes) {
		this.qtdDependentes = qtdDependentes;
	}
	
}
