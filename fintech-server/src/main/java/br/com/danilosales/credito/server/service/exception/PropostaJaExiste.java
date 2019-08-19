package br.com.danilosales.credito.server.service.exception;

public class PropostaJaExiste extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PropostaJaExiste(String mensagem) {
		super(mensagem);
	}
	
}
