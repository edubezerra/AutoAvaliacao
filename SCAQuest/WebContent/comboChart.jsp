<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html lang="pt-BR"> 
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>
      Google Visualization API Sample
    </title>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load('visualization', '1', {packages: ['corechart']});
    </script>
    <script type="text/javascript">
      function drawVisualization() {
        // Some raw data (not necessarily accurate)
                
         <c:forEach items="${dados}" var="dado" varStatus="statusLoop"  >	  
    	     <!-- drawChart(${statusLoop.count},${dado[0]},${dado[1]},${dado[2]},${dado[3]}); --> 
          </c:forEach>
        
        var data = google.visualization.arrayToDataTable([
          ['Semestre', 'Insuficiente(s) ou Ruim(ns)', 'Suficiente(s) ou Regular(es)', 'Bom(ns) ou Boa(s)', 'Ótimo(s) ou Ótima(s)'],          
          
          ['2012/1',  0,      0,        0,             0],
          ['2012/2', 0,      0,        0,             0],
          ['2013/1', 0,      0,        0,             0],
          ['2013/2', ${dado1[0]},${dado1[1]},${dado1[2]},${dado1[3]} ]
        ]);

        var options = {
          title : 'Disciplina: ${turma.disciplina.nomeDisciplina}',
          vAxis: {title: ""},
          hAxis: {title: ""},
          seriesType: "bars",
          series: {5: {type: "line"}}
        };

        var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
      google.setOnLoadCallback(drawVisualization);
    </script>
  </head>
  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>
  </body>
</html>