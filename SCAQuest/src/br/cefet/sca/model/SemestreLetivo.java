package br.cefet.sca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "SEMESTRE_LETIVO" )
public class SemestreLetivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private int ano;
	private int semestre;
	
	
	private SemestreLetivo(){
		
	}
	
	public SemestreLetivo(int ano, int semestre){
		this.ano = ano;
		this.semestre = semestre; 
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

	public String getDescricao() {
		return ""+ano+"/"+semestre;
	}
	
	public String toString(){
		return getDescricao();
	}


	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getAno() {
		return ano;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getSemestre() {
		return semestre;
	} 	
	

}
