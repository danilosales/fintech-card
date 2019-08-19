package br.com.danilosales.credito.server.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EstadoCivil {

	SOLTEIRO("solteiro", "Solteiro(a)"),
	CASADO("casado", "Casado(a)"),
	DIVORCIADO("divorciado", "Divorciado(a)"),
	VIUVO("viuvo", "Viúvo(a)");
	
	@JsonValue
	private String codigo;
	
	private String descricao;
	
	EstadoCivil(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoCivil getByCodigo(String codigo) {
		return Arrays.stream(values())
				.filter(item -> item.codigo.equals(codigo)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
	
}
