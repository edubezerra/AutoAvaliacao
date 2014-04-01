package br.cefet.sca.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table (name = "PROFESSOR" )
@PrimaryKeyJoinColumn(name = "id")
public class Professor extends Usuario{
	
	private Professor(){
		
	}
	
	public Professor(String nome, String matricula,String senha){
		super.setLogin(matricula);
		super.setNome(nome);
		super.setSenha(senha);
		setMatricula(matricula);
	}
	
	
	private String matricula;
	
	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


}
