package br.com.danilosales.credito.server.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name =  "propostas")
public class Proposta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "O CPF é obrigatório")
	@Size(max = 11, min = 11, message = "Informe somente os números do CPF")
	private String cpf;
	
	@NotNull(message = "A idade não pode ser nula")
	private Integer idade;
	
	@NotNull(message = "É obrigatório informar o sexo")
	private Sexo sexo;
	
	@NotNull(message = "É obrigatório informar o estado civil")
	@Column(name = "estado_civil")
	private EstadoCivil estadoCivil;
	
	@NotNull(message = "Informe a sigla do estado")
	@Size(max = 2, min = 2, message = "Informe a sigla do estado com 2 letras")
	@Column(name = "sigla_estado")
	private String siglaEstado;
	
	@NotNull(message = "Informe a quantidade de dependentes")
	@Column(name = "qtd_dependentes")
	private Integer qtdDependentes;
	
	@NotNull(message = "É obrigatório informar a renda")
	private BigDecimal renda;
	
	private Status status = Status.EM_ANALISE;
	
	private String observacao;
	
	@Column(name = "data_envio_proposta")
	private LocalDateTime dataEnvioProposta = LocalDateTime.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getSiglaEstado() {
		return siglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}

	public Integer getQtdDependentes() {
		return qtdDependentes;
	}

	public void setQtdDependentes(Integer qtdDependentes) {
		this.qtdDependentes = qtdDependentes;
	}

	public BigDecimal getRenda() {
		return renda;
	}

	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public boolean isNova() {
		return id == null;
	}

	public LocalDateTime getDataEnvioProposta() {
		return dataEnvioProposta;
	}

	public void setDataEnvioProposta(LocalDateTime dataEnvioProposta) {
		this.dataEnvioProposta = dataEnvioProposta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proposta other = (Proposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
