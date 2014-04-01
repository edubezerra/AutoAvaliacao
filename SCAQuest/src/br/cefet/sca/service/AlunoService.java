package br.cefet.sca.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.cefet.sca.model.Aluno;


public class AlunoService extends DatabaseService {
	
	
	private static AlunoService theInstance;
	
	private AlunoService(){	
		
	}
	
	public static AlunoService getInstance() {
		
		if (theInstance == null) { 		
		    theInstance = new AlunoService();
		}
		return theInstance;
				
	}
		
	
	public Aluno getAlunoByMatricula(String matricula) {
		
		EntityManager em = this.getEntityManager();
		
		String jpql = "SELECT A FROM Aluno A WHERE A.matricula = :matricula ";
		Query query = em.createQuery(jpql);
		
		query.setParameter("matricula", matricula);
		
		Aluno aluno = (Aluno) query.getSingleResult();
		
		return aluno;
		
		
		
	}
	
	

	

	public void saveAluno(Aluno aluno) {
		
		EntityManager em = this.getEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(aluno);
		
		
		em.getTransaction().commit();
		
		
	}
	
	


}
