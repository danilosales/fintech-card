package br.com.danilosales.credito.analise.engine.model;

import java.util.Arrays;

public enum AnaliseProposta {

	REPROVADO("reprovado", "Reprovado", "Reprovado pela poítica de crédito"),
	RENDA_BAIXA("renda-baixa", "Reprovado", "Renda baixa"),
	ENTRE_100_500("100-500", "Aprovado", "Entre 100 a 500"),
	ENTRE_500_1000("500-1000", "Aprovado", "Entre 500 a 1000"),
	ENTRE_1000_1500("1000-1500", "Aprovado", "Entre 1000 a 1500"),
	ENTRE_1500_2000("1500-2000", "Aprovado", "Entre 1500 a 2000"),
	ACIMA_200("2000-acima", "Aprovado", "Superior a 2000");
	
	private String codigo;
	
	private String status;
	
	private String observacao;
	
	AnaliseProposta(String codigo, String status, String observacao) {
		this.codigo = codigo;
		this.status = status;
		this.observacao = observacao;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getStatus() {
		return status;
	}

	public String getObservacao() {
		return observacao;
	}

	public static AnaliseProposta getByCodigo(String codigo) {
		return Arrays.stream(values())
				.filter(item -> item.codigo.equals(codigo)).findFirst().get();
	}
	
	
}
