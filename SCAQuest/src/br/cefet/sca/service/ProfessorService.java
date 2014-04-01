package br.cefet.sca.service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.cefet.sca.model.Professor;

public class ProfessorService extends DatabaseService {
	
    private static ProfessorService theInstance;
	
	private ProfessorService(){	
		
	}
	
	public static ProfessorService getInstance() {
		
		if (theInstance == null) { 		
		    theInstance = new ProfessorService();
		}
		return theInstance;
				
	}
	
	
	
	public Professor getProfessorByMatricula(String matricula) {
		
		EntityManager em = this.getEntityManager();
		
		String jpql = "SELECT P FROM Profesor P WHERE P.matricula = :matricula ";
		Query query = em.createQuery(jpql);
		
		query.setParameter("matricula", matricula);
		
		Professor professor = (Professor) query.getSingleResult();
		
		return professor;
		
		
		
	}

	
	
	
	
}
