package br.cefet.sca.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.cefet.sca.model.Alternativa;
import br.cefet.sca.model.Aluno;
import br.cefet.sca.model.Professor;
import br.cefet.sca.model.Questao;
import br.cefet.sca.model.Questionario;
import br.cefet.sca.model.Resposta;
import br.cefet.sca.model.SemestreLetivo;
import br.cefet.sca.model.Turma;
import br.cefet.sca.service.AlunoService;
import br.cefet.sca.service.ChartService;
import br.cefet.sca.service.QuestionarioService;
import br.cefet.sca.service.TurmaService;



@Controller
@RequestMapping("/chart.do")
public class ChartController {
	
	
	@RequestMapping(params="comando=semestre")
	public ModelAndView iniciar(HttpServletRequest request ){
		
		//SchemaGenerator   
		Professor professor = (Professor)request.getSession().getAttribute("usuario");
		
		ModelAndView mv = new ModelAndView("turmasSemestre.jsp"); 	
		
		SemestreLetivo semestreLetivo = new SemestreLetivo(2013, 2);
		
		List<Turma> listaTurmas = ChartService.getInstance().getTurmasPeriodo(semestreLetivo);
		
		//criaBase();
		
		mv.addObject("professor", professor); 
		mv.addObject("turmasOferecidas", listaTurmas);
		mv.addObject("semestreLetivo", semestreLetivo);
		//mv.addObject("turmasOferecidas", listaTurmas);
		
	    return mv;
		
	}	
	
	
	@RequestMapping(params="comando=pizza")
	public ModelAndView pizza(ServletRequest request){
		
		
		Turma turma = TurmaService.getInstance().getTurmaByCodigo("GTSI1234", "630011");
		
		List<Questao> questoes = ChartService.getInstance().getQuestoes();
		
		int[][] dados = ChartService.getInstance().getDadosQuestoes(turma);
				
		
		ModelAndView mv = new ModelAndView("pizza.jsp");
		
		mv.addObject("turma",turma);
		mv.addObject("questoes",questoes);
		mv.addObject("dados",dados);
		
		//criaBase();
	
		//mv.addObject("msg", "Erro ao efetuar Login");		  	
	    return mv;
		
	}	 
	
	
	

	@RequestMapping(params="comando=combo")
	public ModelAndView combo(ServletRequest request){
		
		Turma turma = TurmaService.getInstance().getTurmaByCodigo("GTSI1234", "630011");
		
		List<Questao> questoes = ChartService.getInstance().getQuestoes();
		
		int[][] dados = ChartService.getInstance().getDadosQuestoes(turma);
				
		
		ModelAndView mv = new ModelAndView("comboChart.jsp"); 	
		
		mv.addObject("turma",turma);
		mv.addObject("questoes",questoes);
		mv.addObject("dados",dados);
		mv.addObject("dado1",dados[1]);
		
		
		
		//criaBase();
	
		//mv.addObject("msg", "Erro ao efetuar Login");		  	
	    return mv;
		
	}	 
	
	
	
	@RequestMapping(params="comando=total")
	public ModelAndView total(ServletRequest request){
		
		ModelAndView mv = new ModelAndView("questionarioResp.jsp"); 	
		 return mv;
	}
	
	
	@RequestMapping(params="comando=total2")
	public ModelAndView semestre(ServletRequest request){
		
		ModelAndView mv = new ModelAndView("semestreDisc.jsp"); 	
		 return mv;
	}
	

}
