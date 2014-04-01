<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<c:if test="${aluno != null}">

${aluno.nome}, você possui os seguintes questionários pendentes: <br/><br/>

<c:set var="turmasDisp" value="${aluno.turmas}" />

<c:forEach items="${turmasDisp}" var="turma" varStatus="statusLoop" >
      <a href="aluno.do?comando=questionario&turma=${turma.id}&matricula=${aluno.matricula}">${turma.disciplina.nomeDisciplina}</a><br/> 
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