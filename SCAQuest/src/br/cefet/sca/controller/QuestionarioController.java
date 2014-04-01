package br.cefet.sca.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.cefet.sca.model.Alternativa;
import br.cefet.sca.model.Aluno;
import br.cefet.sca.model.Questao;
import br.cefet.sca.model.Questionario;
import br.cefet.sca.model.Resposta;
import br.cefet.sca.model.Turma;
import br.cefet.sca.service.AlunoService;
import br.cefet.sca.service.QuestionarioService;
import br.cefet.sca.service.TurmaService;
import br.cefet.sca.util.CreationDB;

@Controller
@RequestMapping("/questionario.do")
public class QuestionarioController { 
	 
	
	@RequestMapping(params="comando=questionario")
	public ModelAndView login(){
		
		//SchemaGenerator
		
		
		ModelAndView mv = new ModelAndView("questionario.jsp"); 	
		
		//criaBase();
		
		
		//mv.addObject("msg", "Erro ao efetuar Login");		  	
	    return mv;
		
	}	
	
	
	@RequestMapping(params="comando=responder")
	public ModelAndView responder(ServletRequest request){
		
		//SchemaGenerator
		Map<String,String[]> parameters  = request.getParameterMap();
		
		String matricula = request.getParameter("matricula");
		String codigoTurma = request.getParameter("codigoTurma");
		String codigoDisc = request.getParameter("codigoDisc");
		
		Aluno aluno = AlunoService.getInstance().getAlunoByMatricula(matricula);
		Turma turma = TurmaService.getInstance().getTurmaByCodigo(codigoDisc, codigoTurma);
		
		Map<Long,Long> respostas = new HashMap<Long,Long>();
		
		for (Iterator iterator = parameters.keySet().iterator(); iterator.hasNext();) {
			String paramName = (String) iterator.next();
			
			if ((paramName != null) &&(paramName.startsWith("questao-"))) {
				long idQuestao = Long.parseLong(paramName.substring("questao-".length()));
				long resp = 0;
				
				String[] alternativas = parameters.get("resp-"+idQuestao);
				
				if (alternativas != null && alternativas.length > 0) {
					System.out.println("alternativas[0]="+alternativas[0]);
					resp = Long.parseLong(alternativas[0]);
					respostas.put(idQuestao, resp);
				}
			}			
		}
		
		int countRespostas = 0;
		
		Questionario questionario = new Questionario(aluno,turma,turma.getSemestreLetivo());
		
		for (Iterator iterator = respostas.keySet().iterator(); iterator.hasNext();) {
			Long questaoId = (Long) iterator.next();
			
			Resposta resposta = new Resposta();
			
			Questao questao = QuestionarioService.getInstance().getQuestaoById(questaoId);
			Alternativa escolhida = QuestionarioService.getInstance().getAlternativaById(respostas.get(questaoId));
			
			//resposta.setAluno(aluno);
			resposta.setTurma(turma);
			resposta.setQuestao(questao);
			resposta.setSemestreLetivo(turma.getSemestreLetivo());
			resposta.setAlternativa(escolhida);
			
			//resposta.setAluno(aluno)
			questionario.addResposta(resposta);	
			countRespostas++;
			
		}
		
		aluno.addQuestionario(questionario);
		
		
		AlunoService.getInstance().saveAluno(aluno);	
		
		
		
		
		
		ModelAndView mv = new ModelAndView("questionarioResp.jsp"); 	
		
		//criaBase();
	
		//mv.addObject("msg", "Erro ao efetuar Login");		  	
	    return mv;
		
	}	
	
	
	
	public void criaBase() {
		// TODO Auto-generated method stub
		try {		  
			
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("SCAPU");
			EntityManager em = emf.createEntityManager();
			
			//SchemaGenerator.main(null);
			CreationDB.main(null);
			

			em.getTransaction().begin();
			
			//Aluno aluno = new Aluno();
			//aluno.setMatricula("1111015WEB");
			//aluno.setNome("Hugo Pinheiro de Aguiar");
			//aluno.
			//em.g
			

			
			//em.persist(aluno);
			
			
			//em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public List getQuestoes() {
		// TODO Auto-generated method stub
		try {		  
			
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("SCAPU");
			EntityManager em = emf.createEntityManager();
			
			//SchemaGenerator.main(null);
			//CreationDB.main(null);
			

			//em.getTransaction().begin();
			
			//Aluno aluno = new Aluno();
			//aluno.setMatricula("1111015WEB");
			//aluno.setNome("Hugo Pinheiro de Aguiar");
			//aluno.
			Query query = em.createQuery("Select q from Questao q");
			List lista = query.getResultList();
			
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
