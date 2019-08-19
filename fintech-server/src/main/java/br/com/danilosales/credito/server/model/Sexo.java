package br.com.danilosales.credito.server.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Sexo {

	MASCULINO("M", "Masculino"),
	FEMININO("F", "Feminino");
	
	@JsonValue
	private String codigo;
	
	private String descricao;
	
	Sexo(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Sexo getByCodigo(String codigo) {
		return Arrays.stream(values())
				.filter(item -> item.codigo.equals(codigo))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
	
}
