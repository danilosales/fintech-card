package br.com.danilosales.credito.server.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {

	APROVADO("aprovado", "Aprovado"),
	REPROVADO("reprovado", "Reprovado"),
	EM_ANALISE("em_analise", "Em análise");
	
	private String codigo;
	
	@JsonValue
	private String descricao;

	Status(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Status getByCodigo(String codigo) {
		return Arrays.stream(values())
				.filter(item -> item.codigo.equals(codigo))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
	
	
}
