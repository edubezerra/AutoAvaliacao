package br.cefet.sca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "ALTERNATIVA" )
public class Alternativa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String descricao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private Alternativa(){
		
	}
	
	
	public Alternativa(String descricao){
		this.descricao = descricao;
	}
	

	public String getDescricao() {
		return descricao;
	}


	

}
