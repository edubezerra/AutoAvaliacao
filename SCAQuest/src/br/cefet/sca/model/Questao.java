package br.cefet.sca.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table (name = "QUESTAO" )
public class Questao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	private String descricao;	
	
	@ManyToMany	
	private List<Alternativa> alternativas= new ArrayList<Alternativa>();

	public long getId() {
		
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void addAlternativa(Alternativa alternativa) {
		this.alternativas.add(alternativa);
	}


}
