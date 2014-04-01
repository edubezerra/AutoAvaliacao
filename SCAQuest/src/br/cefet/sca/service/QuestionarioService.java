package br.cefet.sca.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.cefet.sca.model.Alternativa;
import br.cefet.sca.model.Questao;
import br.cefet.sca.model.SemestreLetivo;
import br.cefet.sca.model.Turma;


public class QuestionarioService extends DatabaseService {
	
	
	private static QuestionarioService theInstance;
	
	private QuestionarioService(){	
		
	}
	
	public static QuestionarioService getInstance() {
		
		if (theInstance == null) { 		
		    theInstance = new QuestionarioService();
		}
		return theInstance;
				
	}
		
	
	public Questao getQuestaoById(Long id) {
		
		EntityManager em = this.getEntityManager();
		
		String jpql = "SELECT Q FROM Questao Q WHERE Q.id = :id ";
		Query query = em.createQuery(jpql);
		
		query.setParameter("id", id);
		
		Questao questao = (Questao) query.getSingleResult();
		
		return questao;
		
		
		
	}
	
	
    public Alternativa getAlternativaById(Long id) {
		
		EntityManager em = this.getEntityManager();
		
		String jpql = "SELECT A FROM Alternativa A WHERE A.id = :id ";
		Query query = em.createQuery(jpql);
		
		query.setParameter("id", id);
		
		Alternativa alternativa = (Alternativa) query.getSingleResult();
		
		return alternativa;
		
		
		
	}
    
    
    public Turma getQuestionariosTurmas(Long id) {
		
		EntityManager em = this.getEntityManager();
		
		String jpql = "SELECT A.turmas FROM Aluno A, Turma T WHERE T.id = A.turmas.id  ";
		Query query = em.createQuery(jpql);
		
		query.setParameter("id", id);
		
		Turma turma = (Turma) query.getSingleResult();
		
		return turma;
		
		
		
	}
    
    
    
  public List<Turma>  getTurmasSemestre(SemestreLetivo semestreLetivo) {
		
		EntityManager em = this.getEntityManager();
		
		String jpql = "SELECT T FROM Turma T, Turma T WHERE T.semestreLetivo.ano =:ano and T.semestreLetivo.semestre =:semestre ";
		Query query = em.createQuery(jpql);
		
		query.setParameter("ano", semestreLetivo.getAno());
		query.setParameter("semestre", semestreLetivo.getSemestre());
		
		List<Turma> turmas = query.getResultList();
		
		return turmas;
		
		
		
	}
  
  
  
  public List<Turma> getTurmasPreenchimento(String matricula, int ano, int semestre) {
		
		EntityManager em = this.getEntityManager();
		
		String jpql = "SELECT T FROM Aluno A inner join A.turmas T where " +
				" A.matricula =:matricula and T.semestreLetivo.ano =:ano and T.semestreLetivo.semestre =:semestre ";
		Query query = em.createQuery(jpql);
		
		query.setParameter("matricula", matricula);
		query.setParameter("ano", ano);
		query.setParameter("semestre", semestre);
		
		List<Turma> turmas1 = query.getResultList();
		
		
		String jpql2 = "SELECT Q.turma FROM Aluno A inner join A.questionarios Q where A.matricula =:matricula and Q.semestreLetivo.ano =:ano and " +
				"Q.semestreLetivo.semestre =:semestre and  " +
				" SIZE(Q.respostas) = (SELECT count(U) from Questao U) ";
		Query query2 = em.createQuery(jpql2);
		query2.setParameter("matricula", matricula);
		query2.setParameter("ano", ano);
		query2.setParameter("semestre", semestre);
		
		List<Turma> turmas2 = query2.getResultList();
		
		turmas1.removeAll(turmas2);
		
		
		return turmas1;
		
		
		
	}	
  

    /*
	public void saveQuestionario(QuestionarioRespondido qr) {
		// TODO Auto-generated method stub
		EntityManager em = this.getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(qr);		
		
		em.getTransaction().commit();
	}
	
	*/


	
	


}
