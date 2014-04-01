package br.cefet.sca.autenticacao;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import br.cefet.sca.webservice.WSAutenticaImpl;
import br.cefet.sca.webservice.WSAutenticaServiceLocator;

public class AutenticadorUsuarioWebService extends AutenticadorUsuario  {

	public AutenticadorUsuarioWebService(){
		System.out.println("AutenticadorUsuarioWebService");
	}
	
	
	
	public boolean autentica(String login, String password) {
		boolean result = false; 	
		System.out.println("Autenticando Via WS");
		
		try {
			System.out.println("Via WS");
			
			WSAutenticaServiceLocator wsloc = new WSAutenticaServiceLocator();			
			WSAutenticaImpl wsImpl = wsloc.getWSAutentica();
			result = wsImpl.autentica(login, password);
			System.out.println("Result = "+result);
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

}
