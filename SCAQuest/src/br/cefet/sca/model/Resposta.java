package br.cefet.sca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "RESPOSTA" )
public class Resposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long numero;
	
	@ManyToOne
	private Questao questao;
	
	@ManyToOne
	private Alternativa alternativa;	
	
	@ManyToOne
	private Turma turma;
	
	@ManyToOne
	SemestreLetivo semestreLetivo;
	
	
	
	
	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public Alternativa getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
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


	

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public long getNumero() {
		return numero;
	}
	
	
	

}
