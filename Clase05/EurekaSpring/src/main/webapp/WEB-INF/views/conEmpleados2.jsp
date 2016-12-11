<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" 
src="<c:url value='/resources/jquery/jquery.js' />"></script>
<title>CONSULTAR EMPLEADOS</title>
</head>
<body>
	<h1>CONSULTAR EMPLEADOS</h1>

	<p>ERROR: <span id="error" style="color:red;"></span></p>

	<form id="form1">
		<table>
			<tr>
				<td>
				  <label>Paterno:</label><br /> 
				  <input type="text" name="paterno"/>
				</td>
				<td>
				  <label>Materno:</label><br /> 
				  <input type="text" name="materno"/>
				</td>
				<td>
				  <label>Nombre:</label><br /> 
				  <input type="text" name="nombre"/>
				</td>
				<td>
				  <br /> 
				  <input type="button" id="btnConsultar" value="Consultar" />
				</td>
			</tr>
		</table>
	</form>

	<h1>RESULTADO</h1>
	<table>
		<thead>
			<tr>
				<td>CODIGO</td>
				<td>PATERNO</td>
				<td>MATERNO</td>
				<td>NOMBRE</td>
				<td>CIUDAD</td>
				<td>DIRECCION</td>
			</tr>
		</thead>
		<tbody id="tblData">
		</tbody>
	</table>

  <script type="text/javascript">
  
  $("#btnConsultar").click(function(){
	  var data = $("#form1").serialize();
	  $("#tblData").empty();
	  $("#error").text("");
	  $.post("conEmpleados2.htm",data,function(obj){
		  if(obj.code == 1){
			  var arreglo = $.parseJSON(obj.text);
			  $.each(arreglo, function( index, r ) {
	        var fila = "<tr>";
	        fila += "<td>" + r.codigo + "</td>";
	        fila += "<td>" + r.paterno + "</td>";
	        fila += "<td>" + r.materno + "</td>";
	        fila += "<td>" + r.nombre + "</td>";
	        fila += "<td>" + r.ciudad + "</td>";
	        fila += "<td>" + r.direccion + "</td>";
	        fila += "</td>";
	        $("#tblData").append(fila);
	      });
		  } else {
			  $("#error").text(obj.text);
		  }
	  });
  });
  
  </script>

</body>
</html>