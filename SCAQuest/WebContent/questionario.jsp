<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt-br"> 
<head> 
	    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="bootstrap/signin.css" rel="stylesheet">
	<title>SCA Questionario</title>
</head>

<body>


<h2>SCA Questionario</h2>  
<br><br><br>

<div class="container">

Disciplina: ${turma.disciplina.nomeDisciplina} <br/> 
Turma: ${turma.codigo} <br/>
Semestre: ${turma.semestreLetivo.descricao}<br/>
 <br/> <br/>


<form action="questionario.do?comando=responder" enctype="application/x-www-form-urlencoded" method="post">
<input type="hidden" name="matricula" value="${aluno.matricula}" /> 
<input type="hidden" name="codigoTurma" value="${turma.codigo}" /> 
<input type="hidden" name="codigoDisc" value="${turma.disciplina.codigo}" /> 


<c:forEach items="${lista}" var="questao" varStatus="statusLoop" >
   <input type="hidden" name="questao-${questao.id}" value="${questao.id}" /> 
   
   ${statusLoop.count}) ${questao.descricao}: <br/><br/>
   
   Alternativas:<br/>
   <c:forEach items="${questao.alternativas}" var="alternativa" >
   
   <input type="radio" name="resp-${questao.id}" value="${alternativa.id}" />
   ${alternativa.descricao}<br/>
   </c:forEach>    
   
   <br/>
   <br/>

</c:forEach>

<input type="submit" value="Submeter Resposta" />

</form>




<c:if test="${msg != null}">
	<hr/>
	<c:out value="${msg}" />
</c:if>

</div>

<%-- SUBSTITUIDO POR JSTL	
	String mensagem = request.getParameter("msg");
	
	if (mensagem != null)
	{
		out.write("<hr />");
		out.write(mensagem);
	}	
--%>

</body>
</html>
