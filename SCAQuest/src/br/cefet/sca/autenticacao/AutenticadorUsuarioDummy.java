package br.cefet.sca.autenticacao;

public class AutenticadorUsuarioDummy extends AutenticadorUsuario {
	
	public AutenticadorUsuarioDummy(){
		System.out.println("AutenticadorUsuarioDummy");
	}
	

	@Override
	public boolean autentica(String login, String password) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	

}
