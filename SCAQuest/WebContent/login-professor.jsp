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

${professor.nome}, você possui os seguintes graficos disponiveis: <br/><br/>

&nbsp;&nbsp; &nbsp;  <a href="chart.do?comando=pizza&turma=1">Grafico em Área</a><br/>
&nbsp;&nbsp; &nbsp;  <a href="chart.do?comando=combo&turma=1">Grafico Combo</a>

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