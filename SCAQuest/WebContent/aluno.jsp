<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt-br"> 
<head> 
	<link rel="stylesheet" href="include/estilo.css" />
	<title>SCA Questionario</title>
</head>

<body>


<h2>SCA Questionario</h2>
<br><br><br>


Questionário




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
