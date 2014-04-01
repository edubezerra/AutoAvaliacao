package br.cefet.sca.service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.cefet.sca.model.Aluno;
import br.cefet.sca.model.Turma;


public class TurmaService extends DatabaseService {
	
	
	private static TurmaService theInstance;
	
	private TurmaService(){	
		
	}
	
	public static TurmaService getInstance() {
		
		if (theInstance == null) { 		
		    theInstance = new TurmaService();
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
	
    public Turma getTurmaByCodigo(String codigoDisc, String codigoTurma) {
		
		EntityManager em = this.getEntityManager();
		
		String jpql = "SELECT T FROM Turma T WHERE T.codigo = :codigoTurma AND T.disciplina.codigo = :codigoDisc ";
		Query query = em.createQuery(jpql);
		
		query.setParameter("codigoTurma", codigoTurma);
		query.setParameter("codigoDisc", codigoDisc);
		
		Turma turma = (Turma) query.getSingleResult();
		
		return turma;
		
		
		
	}
	
    public Turma getTurmaById(int idTurma) {
		
		EntityManager em = this.getEntityManager();
		
		String jpql = "SELECT T FROM Turma T WHERE T.id = :idTurma";
		Query query = em.createQuery(jpql);
		
		query.setParameter("idTurma", idTurma);
		
		
		Turma turma = (Turma) query.getSingleResult();
		
		return turma;
		
		
		
	}
	


}
