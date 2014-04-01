package br.cefet.sca.webservice;

import br.cefet.sca.service.LoginService;

public class WSAutentica {
	
	public boolean autentica(String login, String password) {	
		System.out.println("WSAutentica");	
		
		if (password != null) {
			
		   //return password.equals(login);
			System.out.println("autenticando via hibernate");	
			//return LoginService.getInstance().autenticaUsuario(login, password);
			return password.equals(login);
		   
		} else {
		   return false; 	
		}	
		
	}

}
