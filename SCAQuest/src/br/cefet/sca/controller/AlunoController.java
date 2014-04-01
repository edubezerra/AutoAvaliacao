package br.cefet.sca.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.cefet.sca.model.Aluno;
import br.cefet.sca.model.SemestreLetivo;
import br.cefet.sca.model.Turma;
import br.cefet.sca.service.QuestionarioService;
import br.cefet.sca.service.TurmaService;
import br.cefet.sca.util.CreationDB;

@Controller
@RequestMapping("/aluno.do")
public class AlunoController {
	
	  
	public AlunoController(){
		criaBase();
	}
	
	
	
	@RequestMapping(params="comando=menu")
	public ModelAndView exibeMenu(HttpServletRequest request){
		
		//SchemaGenerator
		
		
		ModelAndView mv = new ModelAndView("aluno_menu.jsp");
		Aluno aluno = (Aluno)request.getSession().getAttribute("usuario");
		
		SemestreLetivo semestre = new SemestreLetivo(2013,2);
		
		
		List turmasDisponiveis = getQuestionarios(aluno.getMatricula(),2013,2);
		     
		
		
		System.out.println("aluno_menu");
		
		//Aluno aluno = AlunoService.getInstance().getAlunoByMatricula(matricula);
		//Turma turma = TurmaService.getInstance().getTurmaById(idTurma);
		
		
		mv.addObject("turmasDisponiveis",turmasDisponiveis);		
		mv.addObject("aluno",aluno);		
		//mv.addObject("turma",turma);
		
		
		
		
		
		
		//mv.addObject("msg", "Erro ao efetuar Login");		  	
	    return mv;
		
	}	
	
	
	
	private List<Turma> getQuestionarios(String matricula,int ano, int semestre) {
		// TODO Auto-generated method stub
		return QuestionarioService.getInstance().getTurmasPreenchimento(matricula, ano, semestre);
	}



	@RequestMapping(params="comando=questionario")
	public ModelAndView iniciaQuestionario(HttpServletRequest request, @RequestParam("turma") Integer idTurma ){
		
		//SchemaGenerator
		
		
		ModelAndView mv = new ModelAndView("questionario.jsp");
		
		Aluno aluno = (Aluno)request.getSession().getAttribute("usuario");
		System.out.println("questionario");
		
		List lista = getQuestoes();
		
		
		//Aluno aluno = AlunoService.getInstance().getAlunoByMatricula(matricula);
		Turma turma = TurmaService.getInstance().getTurmaById(idTurma);
		
		
		mv.addObject("lista",lista);		
		mv.addObject("aluno",aluno);		
		mv.addObject("turma",turma);
		
		
		
		
		
		
		//mv.addObject("msg", "Erro ao efetuar Login");		  	
	    return mv;
		
	}	
	
	
	@RequestMapping(params="comando=turmas")
	public ModelAndView turmas(){
		
		//SchemaGenerator
		
		
		ModelAndView mv = new ModelAndView("questionario.jsp"); 	
		System.out.println("questionario_turmas");
		
		List lista = getQuestoes();
		
		mv.addObject("lista",lista);
		
		
		
		
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
			
			
			
			
			//em.persist(aluno);
			
			
			em.getTransaction().commit();
			
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
	
	
	
	public List getTurmas() {
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
