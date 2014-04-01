package br.cefet.sca.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table (name = "QUESTIONARIO" )
public class Questionario {
	
	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne
	private Turma turma;		
	
	@OneToOne
	private SemestreLetivo semestreLetivo;
	
	@OneToOne
	private Aluno aluno;
	
	@OneToMany(cascade=CascadeType.ALL)	
	//@JoinColumn(name="matricula")
	private List<Resposta> respostas = new ArrayList<Resposta>();
	
	private Questionario(){}
	
	public Questionario(Aluno aluno,Turma turma,SemestreLetivo semestreLetivo){
		this.turma = turma;
		this.aluno = aluno;
		this.semestreLetivo = semestreLetivo;
		
	}
	
	
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public SemestreLetivo getSemestreLetivo() {
		return semestreLetivo;
	}
	public void setSemestreLetivo(SemestreLetivo semestreLetivo) {
		this.semestreLetivo = semestreLetivo;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public void addResposta(Resposta resposta){
	   this.respostas.add(resposta);	
	}
	
	
	

}
