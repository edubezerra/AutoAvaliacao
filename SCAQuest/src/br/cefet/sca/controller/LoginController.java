package br.cefet.sca.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.cefet.sca.autenticacao.AutenticadorUsuario;
import br.cefet.sca.model.Aluno;
import br.cefet.sca.model.Professor;
import br.cefet.sca.model.Usuario;
import br.cefet.sca.service.LoginService;

@Controller
@RequestMapping("/login.do")
public class LoginController{
	
	
	// DAO de Alunos
	private AutenticadorUsuario autenticadorUsuario;
		
		// Métodos de Injeção
	public void setAutenticadorUsuario(AutenticadorUsuario autenticadorUsuario)
	{
		this.autenticadorUsuario = autenticadorUsuario;
	}
	
	//org.postgresql.jdbc2.Jdbc2DatabaseMetaData
	//private org.postgresql.jdbc2.Jdbc2DatabaseMetaData meta;
	
	
	
	@RequestMapping(params="comando=login")	
	public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password, HttpServletRequest request){
		
		
		//boolean autenticado = autenticadorUsuario.autentica(username,password);
		boolean autenticado = true;
		
		
		
		ModelAndView mv = null;
		
		if (autenticado) {			
			Usuario usuario = (Usuario) LoginService.getInstance().getUsuarioByLogin(username);
			System.out.println("login");
			
			request.getSession().setAttribute("usuario", usuario);
			
			if (usuario instanceof Aluno){
				Aluno aluno = (Aluno) usuario;
				
				mv = new ModelAndView("login-aluno.jsp"); 	
				mv.addObject("msg", "Login Aluno Efetuado com sucesso");
				mv.addObject("aluno",aluno);	
				
				
			} else if (usuario instanceof Professor){
				Professor professor = (Professor) usuario;
				mv = new ModelAndView("login-professor.jsp"); 	
				mv.addObject("msg", "Login Professor Efetuado com sucesso");
				mv.addObject("professor",professor);		
			}
						
						
			return mv;
		} else {		
			System.out.println("erro");
			mv = new ModelAndView("login.jsp"); 	
			mv.addObject("msg", "Erro ao efetuar Login");			
		    return mv;
		}   
		
	}
	



}
