package br.cefet.sca.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table (name = "ALUNO" )
@PrimaryKeyJoinColumn(name = "id")
public class Aluno extends Usuario{
	
	
	private String matricula;
	
	private Aluno(){
		
	}
	
		
	public Aluno(String nome, String matricula,String senha){
		super.setLogin(matricula);
		super.setNome(nome);
		super.setSenha(senha);
		setMatricula(matricula);
	}	

	
	@ManyToMany
	//@JoinColumn(name="matricula")
	private Set<Turma> turmas = new HashSet<Turma>();
	
	
	//@OneToMany(cascade=CascadeType.ALL)	
	//@JoinColumn(name="matricula")
	//private List<Resposta> respostas = new ArrayList<Resposta>();
	
	@OneToMany(cascade=CascadeType.ALL)	
	private List<Questionario> questionarios = new ArrayList<Questionario>();
	
	
	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}




	public void setTurmas(Set<Turma> turmas) {
		this.turmas = turmas;
	}


	public Set<Turma> getTurmas() {
		return turmas;
	}
	
	public void addTurma(Turma turma){		
		this.turmas.add(turma);		
	}
	
	public void addQuestionario(Questionario questionario){
		this.questionarios.add(questionario);
	}


	


}
