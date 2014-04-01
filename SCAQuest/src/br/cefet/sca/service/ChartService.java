package br.cefet.sca.service;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.cefet.sca.model.Alternativa;
import br.cefet.sca.model.Questao;
import br.cefet.sca.model.SemestreLetivo;
import br.cefet.sca.model.Turma;


public class ChartService extends DatabaseService {
	
	
	private static ChartService theInstance;
	
	private ChartService(){	
		
	}
	
	public static ChartService getInstance() {
		
		if (theInstance == null) { 		
		    theInstance = new ChartService();
		}
		return theInstance;
				
	}
		
	
	public List getRespostas(Long id) {
		
		EntityManager em = this.getEntityManager();
		
		String sql ="" ;
		/*"Select "
		"(select count(1) " 
from RESPOSTA
where alternativa_id = 1
and questao_id = 1) as count1 , 
(select count(1) 
from RESPOSTA
where alternativa_id = 2 
and questao_id = 1) as count2 , 
(select count(1) 
from RESPOSTA
where alternativa_id = 3 
and questao_id = 1) as count3 , 
(select count(1) 
from RESPOSTA
where alternativa_id = 4 
and questao_id = 1) as count4;"; */
		Query query = em.createNativeQuery(sql);
		
		query.setParameter("id", id);
		
		Questao questao = (Questao) query.getSingleResult();
		
		return null;
		
		
		
	}
	
	
    public Alternativa getAlternativaById(Long id) {
		
		EntityManager em = this.getEntityManager();
		
		String jpql = "SELECT A FROM Alternativa A WHERE A.id = :id ";
		Query query = em.createQuery(jpql);
		
		query.setParameter("id", id);
		
		Alternativa alternativa = (Alternativa) query.getSingleResult();
		
		return alternativa;	
		
	}
    
    
    public Alternativa[] getAlternativas(){
    	
    	  EntityManager em = this.getEntityManager(); 
		  String jpql = "SELECT A FROM Alternativa A ";
		  Query query = em.createQuery(jpql);
		  
		  List<Alternativa> alternativas = query.getResultList();
		  
		  alternativas.size();
		  
		  Alternativa[] resp = new Alternativa[alternativas.size()];
		  int i = 0;		  
		  
		  for (Iterator iterator = alternativas.iterator(); iterator.hasNext();) {
			Alternativa alternativa = (Alternativa) iterator.next();
			resp[i] = alternativa;
			i++;
	 	  }
		  return resp;
	  }
	  
      public int[] getDadosQuestao(Turma turma,Questao questao){
    	  
    	  Alternativa[] alternativas = getAlternativas();    
    	  
    	  System.out.println("alternativas.length="+alternativas.length);
    	  
    	  return getDadosQuestao(turma, turma.getSemestreLetivo(), questao, alternativas);
    	  
      }
      
      
      public int[][] getDadosQuestoes(Turma turma){
    	  
    	  Alternativa[] alternativas = getAlternativas();   
    	  
    	  List<Questao> questoes = getQuestoes();
    	  
    	  int[][] result = new int[questoes.size()][alternativas.length];
    	  
    	  int q = 0;
    	      	  
    	  for (Iterator iterator = questoes.iterator(); iterator.hasNext();) {
			Questao questao = (Questao) iterator.next();
			int[] restQuest = getDadosQuestao(turma, turma.getSemestreLetivo(), questao, alternativas);
			
			for (int i = 0; i < restQuest.length; i++) {
				result[q][i] = restQuest[i];
			}
			q++;
		  }
    	  
    	  
    	  return result;
      }
	  
	  public int[] getDadosQuestao(Turma turma, SemestreLetivo semestreLetivo, Questao questao,Alternativa[] alternativas) {
			
			EntityManager em = this.getEntityManager();
		    
		  
		    int[] resp = new int[alternativas.length];
		    
		    //create table RESPOSTA (id  bigserial not null, numero int8 not null, alternativa_id int8, questao_id int8, semestreLetivo_id int4, turma_id int4, primary key (id));
		    //create table ALTERNATIVA (id  bigserial not null, descricao varchar(255), primary key (id));
		    //create table QUESTAO (id  bigserial not null, descricao varchar(255), primary key (id));
		    
	    
			String sql = " SELECT count(id) FROM RESPOSTA R " +
					     " WHERE R.alternativa_id =:alternativaId and R.turma_id =:turmaId and R.questao_id =:questaoId ";
					
			Query query = em.createNativeQuery(sql);	
			
			for (int i = 0; i < alternativas.length; i++) {
				query.setParameter("turmaId", turma.getId());
				if (alternativas[i] != null) {
				query.setParameter("alternativaId", alternativas[i].getId());
				} else {
					System.out.println("XXXXXXXXX");
				}
				query.setParameter("questaoId", questao.getId());
				int total = ((BigInteger)query.getSingleResult()).intValue();
				resp[i] = total;
			}
		
			return resp;		
			
		}	
	
    
	
/*
     public List getDadosGraficoArea(long turmaId, long ano, long periodo) {
		
		EntityManager em = this.getEntityManager();
		
		String jpql = "SELECT R.questao.id, count FROM Resposta R left join R.alternativa A  WHERE R.turma.id = :turmaId and A.id = 1";
		Query query = em.createQuery(jpql);
		
		query.setParameter("turmaId", turmaId);
		
		Alternativa alternativa = (Alternativa) query.getSingleResult();
		
		return alternativa;
		
		
		
	}
	*/
	  
	  public List<Turma> getTurmasPeriodo(SemestreLetivo semestreLetivo){
		  EntityManager em = this.getEntityManager();
		  
		  String jpql = "SELECT T FROM Turma T where T.semestreLetivo.ano =:ano and  T.semestreLetivo.semestre =:semestre  ";
		  Query query = em.createQuery(jpql);
		  
		  query.setParameter("ano", semestreLetivo.getAno());
		  query.setParameter("semestre", semestreLetivo.getSemestre());
		  
		  List<Turma> turmas = query.getResultList();
		  
		  return turmas;
	  }
	  
	  
	  public List<Questao> getQuestoes() {
			// TODO Auto-generated method stub
			try {		  
				
				EntityManager em = this.getEntityManager();
				//SchemaGenerator.main(null);
				//CreationDB.main(null);
				

				//em.getTransaction().begin();
				
				//Aluno aluno = new Aluno();
				//aluno.setMatricula("1111015WEB");
				//aluno.setNome("Hugo Pinheiro de Aguiar");
				//aluno.
				Query query = em.createQuery("Select q from Questao q",Questao.class);
				List<Questao> lista = query.getResultList();
				
				return lista;
				
				//em.persist(aluno);
				
				
				//em.getTransaction().commit();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}


}
