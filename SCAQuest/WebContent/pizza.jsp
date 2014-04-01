<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-BR"> 
  <head>
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="bootstrap/signin.css" rel="stylesheet">
    
    <script type="text/javascript">
    

	
	
	 
	<c:forEach items="${questoes}" var="questao" varStatus="statusLoop"  >	  
	  var quest${statusLoop.count} =  " ${questao.descricao} ";
    </c:forEach>

	
	

      // Load the Visualization API and the piechart package.
      google.load('visualization', '1.0', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.setOnLoadCallback(drawCharts);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawCharts() {
           
    	   
  			
    	  /*
    	  drawChart(1,1,4,2,3);
    	  drawChart(2,16,1,4,1);
    	  drawChart(3,13,1,4,1);
    	  drawChart(4,13,1,4,1);
    	  drawChart(5,3,1,4,1);
    	  drawChart(6,3,1,4,1);
    	  drawChart(7,3,1,4,1);
    	  drawChart(8,3,1,4,1);
    	  */
    	  
    	  
    	  <c:forEach items="${dados}" var="dado" varStatus="statusLoop"  >	  
    	      drawChart(${statusLoop.count},${dado[0]},${dado[1]},${dado[2]},${dado[3]}); 
          </c:forEach> 
        
        
      }
      
      
      function drawChart(numero, ruim, regular, bom, otimo){
    	  
    	// Create the data table.
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'Alternativas');
          data.addColumn('number', 'Quantidade');
          data.addRows([
            ['Insuficiente(s) ou Ruim(ns)', ruim],
            ['Suficiente(s) ou Regular(es)', regular],
            ['Bom(ns) ou Boa(s)', bom],
            ['Ótimo(s) ou Ótima(s)', otimo],
            
          ]);
          
            

          // Set chart options
          var options = {'title':'Questão: '+ eval("quest"+numero),        		
                         'width':500,
                         'height':350};

          // Instantiate and draw our chart, passing in some options.
          var chart = new google.visualization.PieChart(document.getElementById('chart_div'+numero));
          chart.draw(data, options);
    	  
      } 
      
    </script>
  </head>

  <body>
  
    <h3>Grafico  Disciplina: ${turma.disciplina.nomeDisciplina}  - ${turma.semestreLetivo} </h3>
  
    <!--Div that will hold the pie chart-->
    <div class="container">
    
     <div id="chart_div1"></div>
     <div id="chart_div2"></div>
     <div id="chart_div3"></div>
     <div id="chart_div4"></div>
     <div id="chart_div5"></div>
     <div id="chart_div6"></div>
     <div id="chart_div7"></div>
     <div id="chart_div8"></div>
     
    </div> 
  </body>
</html>