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


<h2>SCA Questionario respondido com sucesso</h2>
<br><br><br>

&nbsp;&nbsp; &nbsp;  <a href="aluno.do?comando=menu">Voltar para o inicio</a>
<br><br>





<c:if test="${msg != null}">
	<hr/>
	<c:out value="${msg}" />
</c:if>

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
