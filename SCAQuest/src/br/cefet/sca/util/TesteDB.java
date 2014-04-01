package br.cefet.sca.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.cefet.sca.model.Aluno;

public class TesteDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {		  
			
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("SCAPU");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			
			Aluno aluno = new Aluno("Hugo Pinheiro de Aguiar","1111015WEB","1111015WEB");
						//aluno.
			
			
			
			
			em.persist(aluno);
			
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
