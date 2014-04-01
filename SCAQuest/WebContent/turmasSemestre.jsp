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
<c:if test="${msg != null}">
	<hr/>${msg}<br/>
</c:if>


<!-- 
<a href="aluno.do?comando=questionario">Questionário</a><br/>
-->
<br/>
<br/>


<c:if test="${professor != null}">

${professor.nome}, as seguintes turmas foram oferecidas em ${semestre.descricao}: }<br/><br/>

<c:set var="turmasDisp" value="${turmasOferecidas}" />

<c:forEach items="${turmasDisp}" var="turma" varStatus="statusLoop" >
      <a href="chart.do?comando=questionario&turma=${turma.id}&matricula=${aluno.matricula}">${turma.disciplina.nomeDisciplina}</a><br/> 
</c:forEach>

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
