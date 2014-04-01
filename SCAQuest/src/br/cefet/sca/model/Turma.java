package br.cefet.sca.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name = "TURMA" )
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		
	
	private String codigo;
	
	@ManyToOne
	private Disciplina disciplina; 
	
	@ManyToOne
	private SemestreLetivo semestreLetivo;
	
	private Turma(){
		super();
	}
	
	public Turma(Disciplina disciplina,String codigo,SemestreLetivo semestreLetivo){
		this.disciplina = disciplina;
		this.codigo = codigo;
		this.semestreLetivo = semestreLetivo;
	}
	
	

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setSemestreLetivo(SemestreLetivo semestreLetivo) {
		this.semestreLetivo = semestreLetivo;
	}

	public SemestreLetivo getSemestreLetivo() {
		return semestreLetivo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	

}
