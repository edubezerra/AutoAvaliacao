package br.cefet.sca.util;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.cefet.sca.model.Alternativa;
import br.cefet.sca.model.Aluno;
import br.cefet.sca.model.Disciplina;
import br.cefet.sca.model.Professor;
import br.cefet.sca.model.Questao;
import br.cefet.sca.model.Questionario;
import br.cefet.sca.model.Resposta;
import br.cefet.sca.model.SemestreLetivo;
import br.cefet.sca.model.Turma;


public class CreationDB {
	
	
	public static String[] NOMES = {"Joao", "Jose", "Sandro", "Maria", "Ana", "Laura", "Lucia", "Paulo", "Cesar", "Antonio", "Antonia" }; 
	public static String[] SOBRENOMES = {"de Oliveira", "Cesar", "da Silva", "de Souza", "de Paula", "Miranda", "Albuquerque", "de Almeida", "Cesar" };
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {		  
			
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("SCAPU");
			EntityManager em = emf.createEntityManager();
			
			System.out.println("Inicio");

			em.getTransaction().begin();
			
			Aluno aluno1 = new Aluno("Hugo Pinheiro de Aguiar","1111015WEB","1111015WEB");
			Aluno aluno2 = new Aluno("Jose da Silva","1111011WEB","1111011WEB");
			
			Professor prof1 =new Professor("Eduardo Bezerra","12345","12345");
					
								
		
			Disciplina disc1= new Disciplina("MICROECONOMIA","GADM7708");
			Disciplina disc2= new Disciplina("SIMULAÇÕES EMPRESARIAIS","GADM7731");
			Disciplina disc3= new Disciplina("GESTÃO ESTRATÉGICA","GADM7741");
			Disciplina disc4= new Disciplina("ECONOMIA BRASILEIRA","GADM7756");
			Disciplina disc5= new Disciplina("ARQUITETURA DE COMPUTADORES","GTSI1211");
			Disciplina disc6= new Disciplina("PROGRAMAÇÃO DE CLIENTE WEB","GTSI1212");
			Disciplina disc7= new Disciplina("PROJETO DE ALGORITMOS COMPUTACIONAIS","GTSI1213");
			Disciplina disc8= new Disciplina("LÓGICA MATEMÁTICA","GTSI1214");
			Disciplina disc9= new Disciplina("INTRODUÇÃO À ADMINISTRAÇÃO","GTSI1215");
			Disciplina disc10= new Disciplina("SISTEMAS OPERACIONAIS","GTSI1221");
			Disciplina disc11= new Disciplina("ESTRUTURAS DE DADOS","GTSI1222");
			Disciplina disc12= new Disciplina("MATEMÁTICA DISCRETA","GTSI1223");
			Disciplina disc13= new Disciplina("METODOLOGIA CIENTÍFICA","GTSI1224");
			Disciplina disc14= new Disciplina("ENGENHARIA DE REQUISITOS","GTSI1231");
			Disciplina disc15= new Disciplina("FUNDAMENTOS DE REDES DE COMPUTADORES","GTSI1232");
			Disciplina disc16= new Disciplina("PROGRAMAÇÃO ORIENTADA A OBJETOS","GTSI1233");
			Disciplina disc17= new Disciplina("EMPREENDEDORISMO","GTSI1234");
			Disciplina disc18= new Disciplina("ESTATÍSTICA E PROBABILIDADE","GTSI1235");
			Disciplina disc19= new Disciplina("PROJETO E CONSTRUÇÃO DE SISTEMAS","GTSI1254");
			Disciplina disc20= new Disciplina("EXPRESSÃO ORAL E ESCRITA","GTSI1273");
			Disciplina disc21= new Disciplina("RESPONSABILIDADE SOCIAL","GTSI1277");
			Disciplina disc22= new Disciplina("ARQUITETURAS AVANÇADAS DE COMPUTADORES","GTSI1301");
			Disciplina disc23= new Disciplina("SISTEMAS DIGITAS","GTSI1302");
			Disciplina disc24= new Disciplina("PROJETO DE BANCO DE DADOS","GTSI7311");
			Disciplina disc25= new Disciplina("MODELAGEM DE PROJETO DE SISTEMAS","GTSI7312");
			Disciplina disc26= new Disciplina("ADMINISTRAÇÃO DE BANCO DE DADOS","GTSI7415");
			Disciplina disc27= new Disciplina("PROJETO DE SOFTWARE ORIENTADOS A OBJETOS","GTSI7418");
			Disciplina disc28= new Disciplina("PROGRAMAÇÃO DE SERVIDORES WEB","GTSI7518");
			Disciplina disc29= new Disciplina("PROJETO DE INTERFACES","GTSI7519");
			Disciplina disc30= new Disciplina("PADRÕES DE SOFTWARE","GTSI7520");
			Disciplina disc31= new Disciplina("ENGENHARIA DE SOFTWARE","GTSI7521");
			Disciplina disc32= new Disciplina("PROJETO FINAL I","GTSI7523");
			Disciplina disc33= new Disciplina("TÓPICOS AVANÇADOS EM INFORMÁTICA","GTSI7624");
			Disciplina disc34= new Disciplina("NEGÓCIOS NA INTERNET","GTSI7625");
			Disciplina disc35= new Disciplina("SEGURANÇA DA INFORMAÇÃO","GTSI7626");
			Disciplina disc36= new Disciplina("INFORMÁTICA E SOCIEDADE","GTSI7627");
			Disciplina disc37= new Disciplina("PROJETO FINAL II","GTSI7628");
			Disciplina disc38= new Disciplina("ESTÁGIO SUPERVISIONADO (TECNÓLOGO EM WEB)","GTSI7629");
			Disciplina disc39= new Disciplina("APLICAÇÕES NA INTERNET PARA TV DIGITAL INTERATIVA","GTSI7702");

			Disciplina[] disciplinas = {
					disc1,
					disc2,
					disc3,
					disc4,
					disc5,
					disc6,
					disc7,
					disc8,
					disc9,
					disc10,
					disc11,
					disc12,
					disc13,
					disc14,
					disc15,
					disc16,
					disc17,
					disc18,
					disc19,
					disc20,
					disc21,
					disc22,
					disc23,
					disc24,
					disc25,
					disc26,
					disc27,
					disc28,
					disc29,
					disc30,
					disc31,
					disc32,
					disc33,
					disc34,
					disc35,
					disc36,
					disc37,
					disc38,
					disc39 };
			
			
			
			SemestreLetivo semestreLetivo = new SemestreLetivo(2013,2);
			SemestreLetivo semestreLetivo01 = new SemestreLetivo(2013,1);
			SemestreLetivo semestreLetivo02 = new SemestreLetivo(2012,2);
			SemestreLetivo semestreLetivo03 = new SemestreLetivo(2012,1);
			SemestreLetivo semestreLetivo04 = new SemestreLetivo(2011,2);
			
								
			
			Turma turma1 = new Turma(disc1,"600006",semestreLetivo);
			Turma turma2 = new Turma(disc2,"600007",semestreLetivo);
			Turma turma3 = new Turma(disc3,"600009",semestreLetivo);
			Turma turma4 = new Turma(disc4,"600014",semestreLetivo);
			Turma turma5 = new Turma(disc5,"600001",semestreLetivo);
			Turma turma6 = new Turma(disc6,"600004",semestreLetivo);
			Turma turma7 = new Turma(disc7,"600012",semestreLetivo);
			Turma turma8 = new Turma(disc8,"600003",semestreLetivo);
			Turma turma9 = new Turma(disc9,"600013",semestreLetivo);
			Turma turma10 = new Turma(disc10,"610002",semestreLetivo);
			Turma turma11 = new Turma(disc11,"690020",semestreLetivo);
			Turma turma12 = new Turma(disc12,"640018",semestreLetivo);
			Turma turma13 = new Turma(disc13,"640018",semestreLetivo);
			Turma turma14 = new Turma(disc14,"630010",semestreLetivo);
			Turma turma15 = new Turma(disc15,"620008",semestreLetivo);
			Turma turma16 = new Turma(disc16,"620009",semestreLetivo);
			Turma turma17 = new Turma(disc17,"630011",semestreLetivo);
			Turma turma18 = new Turma(disc18,"630013",semestreLetivo);
			Turma turma19 = new Turma(disc19,"600011",semestreLetivo);
			Turma turma20 = new Turma(disc20,"600010",semestreLetivo);
			Turma turma21 = new Turma(disc21,"600024",semestreLetivo);
			Turma turma22 = new Turma(disc22,"600002",semestreLetivo);
			Turma turma23 = new Turma(disc23,"600005",semestreLetivo);
			Turma turma24 = new Turma(disc24,"620005",semestreLetivo);
			Turma turma25 = new Turma(disc25,"620006",semestreLetivo);
			Turma turma26 = new Turma(disc26,"640020",semestreLetivo);
			Turma turma27 = new Turma(disc27,"630011",semestreLetivo);
			Turma turma28 = new Turma(disc28,"640014",semestreLetivo);
			Turma turma29 = new Turma(disc29,"650001",semestreLetivo);
			Turma turma30 = new Turma(disc30,"680002",semestreLetivo);
			Turma turma31 = new Turma(disc31,"630020",semestreLetivo);
			Turma turma32 = new Turma(disc32,"640017",semestreLetivo);
			Turma turma33 = new Turma(disc33,"600008",semestreLetivo);
			Turma turma34 = new Turma(disc34,"680003",semestreLetivo);
			Turma turma35 = new Turma(disc35,"640019",semestreLetivo);
			Turma turma36 = new Turma(disc36,"660000",semestreLetivo);
			Turma turma37 = new Turma(disc37,"690010",semestreLetivo);
			Turma turma38 = new Turma(disc38,"690011",semestreLetivo);
			Turma turma39 = new Turma(disc39,"600030",semestreLetivo);

			Turma[] turmas = {
					turma1,
					turma2,
					turma3,
					turma4,
					turma5,
					turma6,
					turma7,
					turma8,
					turma9,
					turma10,
					turma11,
					turma12,
					turma13,
					turma14,
					turma15,
					turma16,
					turma17,
					turma18,
					turma19,
					turma20,
					turma21,
					turma22,
					turma23,
					turma24,
					turma25,
					turma26,
					turma27,
					turma28,
					turma29,
					turma30,
					turma31,
					turma32,
					turma33,
					turma34,
					turma35,
					turma36,
					turma37,
					turma38,
					turma39}; 
			
			
			
			
			
			
			
			
			Alternativa alternativa1 = new Alternativa("Insuficiente(s) ou Ruim(ns)");
			Alternativa alternativa2 = new Alternativa("Suficiente(s) ou Regular(es)");
			Alternativa alternativa3 = new Alternativa("Bom(ns) ou Boa(s)");
			Alternativa alternativa4 = new Alternativa("Ótimo(s) ou Ótima(s)");
			
			
			Alternativa[] alternativas = new Alternativa[]{
					alternativa1,
					alternativa2,
					alternativa3,
					alternativa4
			};
			


			
			
			//quest.addAlternativa(new Alternativa("Insuficiente(s) ou Ruim(ns)"));
			//quest.addAlternativa(new Alternativa("Suficiente(s) ou Regular(es)"));
			//quest.addAlternativa(new Alternativa("Bom(ns) ou Boa(s)"));
			//quest.addAlternativa(new Alternativa("Ótimo(s) ou Ótima(s)"));
			
			
			Questao quest1 = criarQuestao("De forma geral, pode-se dizer que a apresentação do programa" +
				" e objetivos das disciplinas cursadas ocorre de maneira...",alternativas);
			
			Questao quest2 = criarQuestao("De forma geral, pode-se dizer que a atualização da bibliografia utilizada " +
					"e/ou adequação aos tópicos do programa das disciplinas cursadas ocorre de maneira...",alternativas);
			
			Questao quest3 = criarQuestao("De forma geral, pode-se dizer que o esclarecimento prévio sobre os " +
					"critérios utilizados para a avaliação dos alunos ocorre de maneira...",alternativas);
			
			Questao quest4 = criarQuestao("De forma geral, pode-se dizer que o cumprimento do conteúdo " +
					"programático ocorre de maneira...",alternativas);
			
			Questao quest5 = criarQuestao("As práticas pedagógicas promovem a contextualização. " +
					"De forma geral, pode-se dizer que a relação da teoria com a prática das disciplinas cursadas ocorre de maneira...",alternativas);
			
			Questao quest6 = criarQuestao("De forma geral, pode-se dizer que o planejamento/organização" +
					" das aulas pelos professores ocorre de maneira...",alternativas);
			
			Questao quest7 = criarQuestao("De forma geral, pode-se dizer que a assiduidade dos seus " +
					"professores ocorre de forma...",alternativas);
			
			Questao quest8 = criarQuestao("De forma geral, pode-se dizer que a pontualidade dos " +
					"seus professores pode ser avaliada como... ",alternativas);
			
			
			
			Questao[] questoes = new Questao[]{
					quest1,
					quest2,
					quest3,
					quest4,
					quest5,
					quest6,
					quest7,
					quest8
			};
			
			
			
			/*
			 -Insuficiente(s) ou Ruim(ns)
-Suficiente(s) ou Regular(es)
-Bom(ns) ou Boa(s) 
-Ótimo(s) ou Ótima(s)



1- De forma geral, pode-se dizer que a apresentação do programa e objetivos das
disciplinas cursadas ocorre de maneira...

2 - De forma geral, pode-se dizer que a atualização da bibliografia utilizada e/ou
adequação aos tópicos do programa das disciplinas cursadas ocorre de maneira...

3 - De forma geral, pode-se dizer que o esclarecimento prévio sobre os critérios
utilizados para a avaliação dos alunos ocorre de maneira...

4- De forma geral, pode-se dizer que o cumprimento do conteúdo programático
ocorre de maneira...

5- As práticas pedagógicas promovem a contextualização. De forma geral, pode-se
dizer que a relação da teoria com a prática das disciplinas cursadas ocorre de maneira...

6- De forma geral, pode-se dizer que o planejamento/organização das aulas pelos
professores ocorre de maneira...

7- De forma geral, pode-se dizer que a assiduidade dos seus professores ocorre de
forma...

8- De forma geral, pode-se dizer que a pontualidade dos seus professores pode ser
avaliada como... 
			  
			 */
			
			System.out.println("Persists");
			
			
			em.persist(disc1);
			em.persist(disc2);
			em.persist(disc3);
			em.persist(disc4);
			em.persist(disc5);
			em.persist(disc6);
			em.persist(disc7);
			em.persist(disc8);
			em.persist(disc9);
			em.persist(disc10);
			em.persist(disc11);
			em.persist(disc12);
			em.persist(disc13);
			em.persist(disc14);
			em.persist(disc15);
			em.persist(disc16);
			em.persist(disc17);
			em.persist(disc18);
			em.persist(disc19);
			em.persist(disc20);
			em.persist(disc21);
			em.persist(disc22);
			em.persist(disc23);
			em.persist(disc24);
			em.persist(disc25);
			em.persist(disc26);
			em.persist(disc27);
			em.persist(disc28);
			em.persist(disc29);
			em.persist(disc30);
			em.persist(disc31);
			em.persist(disc32);
			em.persist(disc33);
			em.persist(disc34);
			em.persist(disc35);
			em.persist(disc36);
			em.persist(disc37);
			em.persist(disc38);
			em.persist(disc39);

			
			em.persist(semestreLetivo);
			
			
			em.persist(semestreLetivo01);
			em.persist(semestreLetivo02);
			em.persist(semestreLetivo03);
			em.persist(semestreLetivo04);
			
			
			
			em.persist(turma1);
			em.persist(turma2);
			em.persist(turma3);
			em.persist(turma4);
			em.persist(turma5);
			em.persist(turma6);
			em.persist(turma7);
			em.persist(turma8);
			em.persist(turma9);
			em.persist(turma10);
			em.persist(turma11);
			em.persist(turma12);
			em.persist(turma13);
			em.persist(turma14);
			em.persist(turma15);
			em.persist(turma16);
			em.persist(turma17);
			em.persist(turma18);
			em.persist(turma19);
			em.persist(turma20);
			em.persist(turma21);
			em.persist(turma22);
			em.persist(turma23);
			em.persist(turma24);
			em.persist(turma25);
			em.persist(turma26);
			em.persist(turma27);
			em.persist(turma28);
			em.persist(turma29);
			em.persist(turma30);
			em.persist(turma31);
			em.persist(turma32);
			em.persist(turma33);
			em.persist(turma34);
			em.persist(turma35);
			em.persist(turma36);
			em.persist(turma37);
			em.persist(turma38);
			em.persist(turma39);

			
			
			
			//em.persist(usuario); 
			//em.persist(admin);

			
			em.persist(alternativa1);
			em.persist(alternativa2);
			em.persist(alternativa3);
			em.persist(alternativa4);
			
			
			em.persist(quest1);
			em.persist(quest2);
			em.persist(quest3);
			em.persist(quest4);
			em.persist(quest5);
			em.persist(quest6);
			em.persist(quest7);
			em.persist(quest8);
			
			
			aluno1.addTurma(turma37);
			aluno1.addTurma(turma30);
			aluno1.addTurma(turma19);
			aluno1.addTurma(turma13);
			aluno1.addTurma(turma33);
			aluno1.addTurma(turma38);
			aluno1.addTurma(turma27);
			
			
			aluno2.addTurma(turma1);
			aluno2.addTurma(turma2);
			aluno2.addTurma(turma3);
			aluno2.addTurma(turma4);
			
			
			responderQuestionarios(aluno1, turma37, questoes, alternativas);
			responderQuestionarios(aluno1, turma30, questoes, alternativas);
			responderQuestionarios(aluno1, turma19, questoes, alternativas);
			//responderQuestionarios(aluno1, turma13, questoes, alternativas);
			
			//aluno1.addTurma(turma37);
			//aluno1.addTurma(turma30);
			//aluno1.addTurma(turma19);
			//aluno1.addTurma(turma13);
			
			//aluno2.addTurma(turma1);
			//aluno2.addTurma(turma2);
			//aluno2.addTurma(turma3);
			//aluno2.addTurma(turma4);
			
			responderQuestionarios(aluno2, turma1, questoes, alternativas);
			responderQuestionarios(aluno2, turma2, questoes, alternativas);
			
			//QuestionarioRespondido qr1 = new QuestionarioRespondido();			
			//qr1.setTurma(turma37);			
			//qr1.setSemestreLetivo(turma37.getSemestreLetivo());
			//qr1.setAluno(aluno1);				
			
			//QuestionarioRespondido qr2 = new QuestionarioRespondido();			
			//qr2.setTurma(turma30);			
			//qr2.setSemestreLetivo(turma30.getSemestreLetivo());
			//qr2.setAluno(aluno1);	
			
			
			
			Aluno[] alunos = createStudents( turmas,questoes, alternativas);
			
			
			
			
			em.persist(aluno1);
			//em.persist(qr1);
			//em.persist(qr2);
			em.persist(aluno2);
			
			for (int i = 0; i < alunos.length; i++) {
				em.persist(alunos[i]);
			}
			
			
			
			
			em.persist(prof1);
			
			
			System.out.println("Commit");
			
			/*
			List<Turma> turmas2 = getTurmasPreenchimento(em, "1111015WEB", semestreLetivo);
			
			 System.out.println("Lista Turmas "); 
			 
			 for (Iterator iterator = turmas2.iterator(); iterator.hasNext();) {
				Turma turma = (Turma) iterator.next();
				System.out.println("Turma "+turma.getDisciplina().getNomeDisciplina()+" "+turma.getCodigo());
			}
			*/ 
			int[] resp = null;
			for (int j = 0; j < questoes.length; j++) {
				resp = getDadosQuestao(em,turma37,semestreLetivo,questoes[j],alternativas);
				
				 System.out.print("Questao"+j+": ");
				for (int i = 0; i < resp.length; i++) {
					 System.out.print(" "+resp[i]); 
				}				
				System.out.println();
			}
			
			
			
			
			
			 System.out.println("Fim"); 
			
			 
			em.getTransaction().commit();
			
			
			
			 
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private static Questao criarQuestao(String enunciado, Alternativa[] alternativas) {
		Questao quest = new Questao();
		quest.setDescricao(enunciado);
		
		for (int i = 0; i < alternativas.length; i++) {
			quest.addAlternativa(alternativas[i]);
		}
		
		
		return quest;
	}
	
	
	
	private static void responderQuestionarios(Aluno aluno, Turma turma, Questao[] questoes, Alternativa[] alternativas ){
		
		int escolha = 0;
		Questionario questionario = new  Questionario(aluno,turma,turma.getSemestreLetivo());
		
		for (int i = 0; i < questoes.length; i++) {
			
			Resposta resposta = new Resposta();
			
			resposta.setTurma(turma);
			resposta.setQuestao(questoes[i]);
			resposta.setSemestreLetivo(turma.getSemestreLetivo());
			
			escolha = (int) (Math.random()*alternativas.length);			
			resposta.setAlternativa(alternativas[escolha]);
			
			
			questionario.addResposta(resposta);	
			
		}
		
		aluno.addQuestionario(questionario);
	}	
		
		
	private static Aluno[] createStudents(Turma[] turmas, Questao[] questoes, Alternativa[] alternativas){
		
		int quant = 50;
		
		Aluno[] alunos = new Aluno[quant];
		
		String login = "";
		int number =0; 
		
		System.out.println("Criando alunos");
		
		for (int i = 0; i < quant; i++) {
			login = createRandomLogin();			
			alunos[i] = new Aluno(createRandomName(),login,login);
			
			for (int j = 0; j < 6; j++) {
				number = (int) (Math.random()*turmas.length);	
				alunos[i].addTurma(turmas[number]);				
				responderQuestionarios(alunos[i], turmas[number], questoes, alternativas);		
				
				
			} 
			
			
			
		}
		
		
		
			
		return alunos;	
			
	}
		
	
	public static String createRandomName(){
		String nome = "";
		
		nome += NOMES[ (int)(Math.random()*NOMES.length ) ] +" "+  SOBRENOMES[ (int)(Math.random()*SOBRENOMES.length ) ]+" "+   SOBRENOMES[ (int)(Math.random()*SOBRENOMES.length ) ];
			
		System.out.println("Nome:"+nome);
		
		return nome;		
	}
		
	public static String createRandomLogin(){
		String login = "111";
					
		for (int i = 0; i < 4; i++) {
			login += "" +(int)(Math.random()*10);	
		}
		login += "WEB";	
		
		System.out.println("Login:"+login);
					
		return login;		
	}	
		
		
	  public static List<Turma> getTurmasPreenchimento(EntityManager em, String matricula, SemestreLetivo semestreLetivo) {
			
			//EntityManager em = this.getEntityManager();
			
			String jpql = "SELECT T FROM Aluno A inner join A.turmas T where " +
					" A.matricula =:matricula and T.semestreLetivo.ano =:semestreLetivo.ano and T.semestreLetivo.semestre =:semestreLetivo.semestre ";
			Query query = em.createQuery(jpql);
			
			query.setParameter("matricula", matricula);
			query.setParameter("semestreLetivo", semestreLetivo);
			
			List<Turma> turmas1 = query.getResultList();
			
			
			String jpql2 = "SELECT Q.turma FROM Aluno A inner join A.questionarios Q where A.matricula =:matricula and Q.semestreLetivo.semestre =:semestreLetivo.semestre and Q.semestreLetivo.ano =:semestreLetivo.ano and " +
					" SIZE(Q.respostas) = (SELECT count(U) from Questao U) ";
			Query query2 = em.createQuery(jpql2);
			query2.setParameter("matricula", matricula);
			query2.setParameter("semestreLetivo", semestreLetivo);
			
			List<Turma> turmas2 = query2.getResultList();
			
			turmas1.removeAll(turmas2);			
			
			return turmas1;		
		}	
	  
	  
	  
	  public static Alternativa[] getAlternativas(EntityManager em){
		  String jpql = "SELECT A FROM Alternativa A ";
		  Query query = em.createQuery(jpql);
		  
		  List<Alternativa> alternativas = query.getResultList();
		  
		  alternativas.size();
		  
		  Alternativa[] resp = new Alternativa[alternativas.size()];
		  int i = 0;		  
		  
		  for (Iterator iterator = alternativas.iterator(); iterator.hasNext();) {
			Alternativa alternativa = (Alternativa) iterator.next();
			resp[i] = alternativa;
			i++;
		}
		  return resp;
	  }
	  
	
	  
	  public static int[] getDadosQuestao(EntityManager em, Turma turma, SemestreLetivo semestreLetivo, Questao questao,Alternativa[] alternativas) {
			
			//EntityManager em = this.getEntityManager();
		    
		  
		    int[] resp = new int[alternativas.length];
		    
		    //create table RESPOSTA (id  bigserial not null, numero int8 not null, alternativa_id int8, questao_id int8, semestreLetivo_id int4, turma_id int4, primary key (id));
		    //create table ALTERNATIVA (id  bigserial not null, descricao varchar(255), primary key (id));
		    //create table QUESTAO (id  bigserial not null, descricao varchar(255), primary key (id));
		    
 	    
			String sql = " SELECT count(id) FROM RESPOSTA R " +
					     " WHERE R.alternativa_id =:alternativaId and R.turma_id =:turmaId and R.questao_id =:questaoId ";
					
			Query query = em.createNativeQuery(sql);	
			
			for (int i = 0; i < resp.length; i++) {
				query.setParameter("turmaId", turma.getId());
				query.setParameter("alternativaId", alternativas[i].getId());
				query.setParameter("questaoId", questao.getId());
				int total = ((BigInteger)query.getSingleResult()).intValue();
				resp[i] = total;
			}
		
			return resp;		
			
		}	
	
	

}
