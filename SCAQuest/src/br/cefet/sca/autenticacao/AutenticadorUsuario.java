package br.cefet.sca.autenticacao;

public abstract class AutenticadorUsuario {
	
	
	public abstract boolean autentica(String login, String password);
	

}
