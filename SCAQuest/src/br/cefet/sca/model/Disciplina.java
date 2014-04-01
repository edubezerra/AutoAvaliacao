package br.cefet.sca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity		
@Table (name = "DISCIPLINA" )
public class Disciplina {
	
	@Id	
	private String codigo; 
	
	private String nomeDisciplina;

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	private Disciplina(){
		super();
	}
	
	public Disciplina(String nomeDisciplina,String codigo){
		this.codigo = codigo;
		this.nomeDisciplina = nomeDisciplina;
	}
	

	public String getCodigo() {
		return codigo;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	
	

}
