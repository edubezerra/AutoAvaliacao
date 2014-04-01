package br.cefet.sca.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.cefet.sca.model.Aluno;
import br.cefet.sca.util.CreationDB;

public class DatabaseService {
	
	private static EntityManager em = null;
	
	
	public EntityManager getEntityManager() {
		
		if (em == null ) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("SCAPU");
		em = emf.createEntityManager();
		System.out.println("Criando EntityManager"); 
		
		}
		
		//em.
		return em;	
		
	}
	

}
