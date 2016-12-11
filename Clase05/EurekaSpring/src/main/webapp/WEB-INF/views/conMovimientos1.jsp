<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" 
src="<c:url value='/resources/jquery/jquery.js' />"></script>
<title>CONSULTA DE MOVIMIENTOS</title>
</head>
<body>
  <h1>CONSULTA DE MOVIMIENTOS</h1>
  <form id="form1">
    <label>Cuenta:</label>
    <input type="text" name="cuenta"/>
    <input type="button" id="btnConsultar" value="Consultar" />
  </form>
  <table border="1">
    <thead>
      <tr>
        <th>CUENTA</th>
        <th>NRO.MOV.</th>
        <th>FECHA</th>
        <th>TIPO</th>
        <th>IMPORTE</th>
      </tr>
    </thead>
    <tbody id="data"></tbody>
  </table>
  <script type="text/javascript">
  
  $("#btnConsultar").click(function(){
	  $("#data").empty();
	  var data = $("#form1").serialize();
	  $.post("conMovimientos1",data,function(arreglo){
		  $.each(arreglo, function( index, obj ) {
			  var fila = "<tr>";
			  fila += "<td>" + obj.CUENCODIGO + "</td>";
			  fila += "<td>" + obj.MOVINUMERO + "</td>";
			  fila += "<td>" + obj.MOVIFECHA + "</td>";
			  fila += "<td>" + obj.TIPONOMBRE + "</td>";
			  fila += "<td>" + obj.MOVIIMPORTE + "</td>";
			  fila += "</td>";
			  $("#data").append(fila);
		  });
	  });
	  
  });
  
  
  </script>
</body>
</html>