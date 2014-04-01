package br.cefet.sca.service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.cefet.sca.model.Aluno;
import br.cefet.sca.model.Usuario;

public class LoginService extends DatabaseService {
	
	
	
    private static LoginService theInstance;
	
	private LoginService(){	
		
	}
	
	public static LoginService getInstance() {
		
		if (theInstance == null) { 		
		    theInstance = new LoginService();
		}
		return theInstance;
				
	}
	
	
	
	public boolean autenticaUsuario(String login, String senha) {
		
		boolean autenticado = false;
		
		EntityManager em = this.getEntityManager();
		
		String jpql = "SELECT U FROM Usuario U WHERE U.login = :login";
		Query query = em.createQuery(jpql);
		
		query.setParameter("login", login);
		
		Usuario usuario = (Usuario) query.getSingleResult();		
		
		if (usuario != null) {
			autenticado = usuario.getSenha().equals(senha);
		}	
		
		return autenticado;	
		
	}
	
	
	public Usuario getUsuarioByLogin(String login) {
		
		EntityManager em = this.getEntityManager();
		
		String jpql = "SELECT U FROM Usuario U WHERE U.login = :login ";
		Query query = em.createQuery(jpql);
		
		query.setParameter("login", login);
		
		Usuario usuario = (Usuario) query.getSingleResult();
		
		return usuario;
		
		
		
	}

	
	
	
	
}
